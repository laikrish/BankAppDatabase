package com.capgemini.bankapp.dao;

import com.capgemini.bankapp.exceptions.PayeeAccountNotFoundException;

public interface BankAccountDao {
	public double getBalance(long accountId);
	public boolean updateBalance(long accountId, double newBalance);

}