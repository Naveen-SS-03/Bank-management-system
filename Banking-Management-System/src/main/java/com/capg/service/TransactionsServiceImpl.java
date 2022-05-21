package com.capg.service;

import java.util.List;

import javax.transaction.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entity.Transactions;
import com.capg.repository.TransactionsRepository;

@Service
public class TransactionsServiceImpl implements TransactionsService {
	@Autowired
	private TransactionsRepository transactionsrepository;

	@Override
	public Transactions addTransactions(Transactions transactions) {

		return transactionsrepository.save(transactions);

	}

	public List<Transactions> viewTransactions() {
		List<Transactions> listTrans = transactionsrepository.findAll();
		return listTrans;
	}

	public Transactions save(Transactions transactions) {
		// TODO Auto-generated method stub
		return transactions;
	}



}
