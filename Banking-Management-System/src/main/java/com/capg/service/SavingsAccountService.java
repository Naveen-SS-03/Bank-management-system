package com.capg.service;

import java.util.List;

import com.capg.entity.SavingsAccount;

public interface SavingsAccountService {

	SavingsAccount createAccount(SavingsAccount Account);

	SavingsAccount viewAccountById(int AccountId);

	List<SavingsAccount> viewAccount();

	SavingsAccount updateAccount(SavingsAccount Account);

	void removeAccount(int AccountId);

	SavingsAccount viewAccountById1(int AccountId);

}
