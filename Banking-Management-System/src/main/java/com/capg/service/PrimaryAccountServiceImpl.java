package com.capg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entity.PrimaryAccount;
import com.capg.repository.PrimaryAccountRepository;


 @Service
public class PrimaryAccountServiceImpl implements PrimaryAccountService {
	@Autowired
	private PrimaryAccountRepository repository;

	@Override
	public PrimaryAccount createAccount(PrimaryAccount Account) {
		return repository.save(Account);
	}

	@Override
	public PrimaryAccount viewAccountById(int AccountId) {
		return repository.findById(AccountId).get();
	}

	@Override
	public List<PrimaryAccount> viewAccount() {
		List<PrimaryAccount> Account = new ArrayList<PrimaryAccount>();
		repository.findAll().forEach(b1 -> Account.add(b1));
		return Account;
	}

	@Override
	public PrimaryAccount updateAccount(PrimaryAccount Account) {
		
		return repository.save(Account);
	}

	@Override
	public void removeAccount(int AccountId) {
		repository.deleteById(AccountId);
	}

	@Override
	public PrimaryAccount viewAccountById1(int AccountId) {
		// TODO Auto-generated method stub
		return null;
	}
}

