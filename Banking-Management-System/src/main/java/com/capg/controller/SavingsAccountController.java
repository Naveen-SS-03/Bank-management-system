package com.capg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.entity.SavingsAccount;

import com.capg.service.SavingsAccountService;



@RestController
@RequestMapping("/Savings-Accounts")

public class SavingsAccountController {
	@Autowired
	private SavingsAccountService service;

	@PostMapping("/create")
	public ResponseEntity<SavingsAccount> createAccount(@RequestBody SavingsAccount Account) {
		SavingsAccount acc = service.createAccount(Account);
		return new ResponseEntity<SavingsAccount>(acc, HttpStatus.CREATED);
	}

	@GetMapping("/viewById/{AccountId}")
	public ResponseEntity<SavingsAccount> viewAccount(@PathVariable("AccountId") int AccountId) {
		SavingsAccount acc = service.viewAccountById(AccountId);
		return new ResponseEntity<SavingsAccount>(acc, HttpStatus.OK);
	}

	@GetMapping("/viewAllAccount")
	public List<SavingsAccount> viewAllAccount() {
		return service.viewAccount();
	}

	@PutMapping("/updateAccount")
	public SavingsAccount updateAccount(@RequestBody SavingsAccount Account) {
		
		return service.updateAccount(Account);
	
	}

	@DeleteMapping("/deleteAccount/{AccountId}")
	public void removeAccount(@PathVariable("AccountId") int AccountId) {
		service.removeAccount(AccountId);
	}

}

