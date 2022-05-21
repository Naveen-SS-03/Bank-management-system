package com.capg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entity.SavingsAccount;
import com.capg.repository.SavingsAccountRepository;


 @Service
public class SavingsAccountServiceImpl implements SavingsAccountService {
	@Autowired
	private SavingsAccountRepository repository;

	@Override
	public SavingsAccount createAccount(SavingsAccount Account) {
		return repository.save(Account);
	}

	@Override
	public SavingsAccount viewAccountById(int AccountId) {
		return repository.findById(AccountId).get();
	}

	@Override
	public List<SavingsAccount> viewAccount() {
		List<SavingsAccount> Account = new ArrayList<SavingsAccount>();
		repository.findAll().forEach(b1 -> Account.add(b1));
		return Account;
	}

	@Override
	public SavingsAccount updateAccount(SavingsAccount Account) {
		
		return repository.save(Account);
	}

	@Override
	public void removeAccount(int AccountId) {
		repository.deleteById(AccountId);
	}

	@Override
	public SavingsAccount viewAccountById1(int AccountId) {
		// TODO Auto-generated method stub
		return null;
	}
}

