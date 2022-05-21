package com.capg.service;

import java.util.List;

import com.capg.entity.PrimaryAccount;

public interface PrimaryAccountService {

	PrimaryAccount createAccount(PrimaryAccount Account);

	PrimaryAccount viewAccountById(int AccountId);

	List<PrimaryAccount> viewAccount();

	PrimaryAccount updateAccount(PrimaryAccount Account);

	void removeAccount(int AccountId);

	PrimaryAccount viewAccountById1(int AccountId);

}
