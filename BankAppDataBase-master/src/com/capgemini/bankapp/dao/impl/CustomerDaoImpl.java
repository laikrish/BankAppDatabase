package com.capgemini.bankapp.dao.impl;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.capgemini.bankapp.dao.CustomerDao;
import com.capgemini.bankapp.database.DbUtil;
import com.capgemini.bankapp.model.BankAccount;
import com.capgemini.bankapp.model.Customer;


public class CustomerDaoImpl implements CustomerDao {

	@Override
	public Customer authenticate(Customer customer)  {
		String customerQuery = "SELECT * FROM customer WHERE customerId = ? AND password = ?";
		String accountQuery = "SELECT * FROM bankaccount WHERE customerId = ?";
		try (Connection connection = DbUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(customerQuery);
				PreparedStatement statement2 = connection.prepareStatement(accountQuery)) {

			statement.setLong(1, customer.getCustomerId());
			statement.setString(2, customer.getPassword());
			try (ResultSet result = statement.executeQuery()) {
				if (result.next()) {
					customer.setCustomerName(result.getString(1));
					customer.setEmail(result.getString(4));
					customer.setAddress(result.getString(5));
					customer.setDateOfBirth(result.getDate(6).toLocalDate());

					statement2.setLong(1, customer.getCustomerId());
					try (ResultSet result2 = statement2.executeQuery()) {
						if (result2.next()) {
							BankAccount bank = new BankAccount();
							bank.setAccountId(result2.getLong(1));
							bank.setAccountType(result2.getString(3));
							bank.setBalance(result2.getDouble(4));
							customer.setBankAccount(bank);
							return customer; 
						}
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}
		

	@Override
	public Customer updateProfile(Customer customer) {
		String query = "UPDATE customer SET email=?,address = ?  WHERE customerId = ? ";
		String customerQuery = "SELECT * FROM bankaccount WHERE customerId = ?";

		try (Connection connection = DbUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(query);
				PreparedStatement statement2 = connection.prepareStatement(customerQuery)) {
			
			statement.setString(1, customer.getEmail());
			statement.setString(2, customer.getAddress());
			statement.setInt(3, customer.getCustomerId());
			
			

			if (statement.executeUpdate() != 0) {
				statement2.setLong(1, customer.getCustomerId());
				try (ResultSet result = statement2.executeQuery()) {
					if (result.next()) {
						
						customer.setEmail(result.getString(4));
						customer.setAddress(result.getString(5));
						
						return customer;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public boolean updatePassword(Customer customer, String oldPassword, String newPassword) {
		String query = "UPDATE customer SET password = ?  WHERE customerId = ? AND password = ? ";

		try (Connection connection = DbUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setString(1, newPassword);
			statement.setLong(2, customer.getCustomerId());
			statement.setString(3, oldPassword);
			if(statement.executeUpdate() != 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static Customer sessionUpdate(long customerId)
	{
		Customer customer = new Customer();
		String customerQuery = "SELECT * FROM customer WHERE customerId = ?";
		String accountQuery = "SELECT * FROM bankaccount WHERE customerId = ?";
		try (Connection connection = DbUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(customerQuery);
				PreparedStatement statement2 = connection.prepareStatement(accountQuery)) {

			statement.setLong(1, customerId);
			try (ResultSet result = statement.executeQuery()) {
				if (result.next()) {
					customer.setCustomerName(result.getString(1));
					customer.setCustomerId(result.getInt(2));
					customer.setPassword(result.getString(3));
					customer.setEmail(result.getString(4));
					customer.setAddress(result.getString(5));
					customer.setDateOfBirth(result.getDate(6).toLocalDate());

					statement2.setLong(1, customer.getCustomerId());
					try (ResultSet result2 = statement2.executeQuery()) {
						if (result2.next()) {
							BankAccount bank = new BankAccount();
							bank.setAccountId(result2.getLong(1));
							bank.setAccountType(result2.getString(3));
							bank.setBalance(result2.getDouble(4));
							customer.setBankAccount(bank);
							return customer; 
						}
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}
	}
