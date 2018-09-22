package com.capgemini.bankapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.capgemini.bankapp.dao.BankAccountDao;
import com.capgemini.bankapp.database.DbUtil;
import com.capgemini.bankapp.exceptions.PayeeAccountNotFoundException;



public class BankAccountDaoImpl implements BankAccountDao {

	@Override
	public double getBalance(long accountId) {
		String query = "SELECT balance FROM bankaccount WHERE accountId = ?";
		try (Connection connection = DbUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {
			
			statement.setLong(1, accountId);
			try(ResultSet result = statement.executeQuery()){
			if (result.next()) {
				return result.getDouble(1);
			}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountId;
	}
		

	@Override
	public boolean updateBalance(long accountId, double newBalance) {
		String query = "UPDATE bankaccount SET balance = ? WHERE accountId = ?";
		try (Connection connection = DbUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setDouble(1, newBalance);
			statement.setLong(2, accountId);
			if(statement.executeUpdate() != 0) {
				System.out.println("Record inserted successfully");
			return true;}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


}