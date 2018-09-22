package com.capgemini.bankapp.service.impl;

import com.capgemini.bankapp.dao.BankAccountDao;
import com.capgemini.bankapp.dao.impl.BankAccountDaoImpl;
import com.capgemini.bankapp.exceptions.PayeeAccountNotFoundException;
import com.capgemini.bankapp.service.BankAccountService;

public class BankAccountServiceImpl implements BankAccountService {

	private BankAccountDao bankAccountDao;
	
	public BankAccountServiceImpl() {
		bankAccountDao=new BankAccountDaoImpl();
	}

	@Override
	public double getBalance(long accountId) throws PayeeAccountNotFoundException {
		return bankAccountDao.getBalance(accountId);
	}

	@Override
	public boolean withdraw(long accountId, double amount) throws PayeeAccountNotFoundException {
		if(bankAccountDao.updateBalance(accountId, bankAccountDao.getBalance(accountId)-amount)) {
			return true;}
		return false;
	}

	@Override
	public boolean deposit(long accountId, double amount) {
		System.out.println("BankAccountServiceImpl");
		if(bankAccountDao.updateBalance(accountId, bankAccountDao.getBalance(accountId)+ amount)) {
			System.out.println("BankAccountServiceImpdepositlIf");
			return true;}
		return false;
	}

	@Override
	public boolean fundTransfer(long fromAcc, long toAcc, double amount) throws PayeeAccountNotFoundException{
		
		
		if(withdraw(fromAcc, amount)) {
			System.out.println("withdraw");
			if(deposit(toAcc,amount))
			return true;
		}
			return false;	
	}

}