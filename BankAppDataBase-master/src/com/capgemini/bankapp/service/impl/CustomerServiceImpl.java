package com.capgemini.bankapp.service.impl;

import com.capgemini.bankapp.dao.CustomerDao;
import com.capgemini.bankapp.dao.impl.CustomerDaoImpl;
import com.capgemini.bankapp.exceptions.PayeeAccountNotFoundException;
import com.capgemini.bankapp.model.Customer;
import com.capgemini.bankapp.service.CustomerService;

public class CustomerServiceImpl implements CustomerService{
	private CustomerDao customerDao;
	
	
	public CustomerServiceImpl() {
		super();
		this.customerDao = new CustomerDaoImpl();
	}

	@Override
	public Customer authenticate(Customer customer) throws PayeeAccountNotFoundException {
		System.out.println("serv impl");
		return customerDao.authenticate(customer);
	}

	@Override
	public Customer updateProfile(Customer customer) {
		return customerDao.updateProfile(customer);
	}

	@Override
	public boolean updatePassword(Customer customer, String oldPassword, String newPassword) {
		return customerDao.updatePassword(customer, oldPassword, newPassword);
	}

}