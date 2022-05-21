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

import com.capg.entity.PrimaryAccount;
import com.capg.service.PrimaryAccountService;

@RestController
@RequestMapping("/Primary-Accounts")

public class PrimaryAccountController {
	@Autowired
	private PrimaryAccountService service;

	@PostMapping("/create")
	public ResponseEntity<PrimaryAccount> createAccount(@RequestBody PrimaryAccount Account) {
		PrimaryAccount acc = service.createAccount(Account);
		return new ResponseEntity<PrimaryAccount>(acc, HttpStatus.CREATED);
	}

	@GetMapping("/viewById/{AccountId}")
	public ResponseEntity<PrimaryAccount> viewAccount(@PathVariable("AccountId") int AccountId) {
		PrimaryAccount acc = service.viewAccountById(AccountId);
		return new ResponseEntity<PrimaryAccount>(acc, HttpStatus.OK);
	}

	@GetMapping("/viewAllAccount")
	public List<PrimaryAccount> viewAllAccount() {
		return service.viewAccount();
	}

	@PutMapping("/updateAccount")
	public PrimaryAccount updateAccount(@RequestBody PrimaryAccount Account) {
		
		return service.updateAccount(Account);
	
	}

	@DeleteMapping("/deleteAccount/{AccountId}")
	public void removeAccount(@PathVariable("AccountId") int AccountId) {
		service.removeAccount(AccountId);
	}

}

