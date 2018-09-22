package com.capgemini.bankapp.service;

import com.capgemini.bankapp.exceptions.PayeeAccountNotFoundException;

public interface BankAccountService {

	
	public double getBalance(long accountId) throws PayeeAccountNotFoundException;
	public boolean withdraw(long accountId, double amount) throws PayeeAccountNotFoundException;
	public boolean deposit(long accountId, double amount);
	public boolean fundTransfer(long fromAcc, long toAcc, double amount) throws PayeeAccountNotFoundException;

}