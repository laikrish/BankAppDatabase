package com.capgemini.bankapp.service;
import com.capgemini.bankapp.exceptions.PayeeAccountNotFoundException;
import com.capgemini.bankapp.model.Customer;

public interface CustomerService {
	public Customer authenticate(Customer customer) throws PayeeAccountNotFoundException;
	public Customer updateProfile(Customer customer);
	public boolean updatePassword(Customer customer, String oldPassword, String newPassword);

}