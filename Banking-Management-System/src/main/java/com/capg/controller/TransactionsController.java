package com.capg.controller;

import java.util.List;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.capg.entity.PrimaryAccount;
import com.capg.entity.SavingsAccount;
import com.capg.entity.Transactions;
import com.capg.service.TransactionsServiceImpl;


@RestController
@RequestMapping("/transactions")
public class TransactionsController {
 
	 @Autowired
	private TransactionsServiceImpl transactionsServiceImpl;
	 
	 
	 @PostMapping("/createTransactions")
	 public ResponseEntity<Transactions> createTransactions(@RequestBody Transactions transactions)
	 {
		 Transactions t=transactionsServiceImpl.addTransactions(transactions);
		 return new ResponseEntity<Transactions>(t,HttpStatus.CREATED);
	 }
	 
		@GetMapping(path = "/viewAllTransactions")
		public ResponseEntity<List<Transactions>> getAllTransactions(){
			ResponseEntity<List<Transactions>> response = null;
			List<Transactions> list = transactionsServiceImpl.viewTransactions();
			response = new ResponseEntity<List<Transactions>>(list, HttpStatus.OK);
			return response;
		}
		
//---------------------------Primary Account Withdraw--------------------------------------------	
		
	    @GetMapping("/Primary Account-Amount withdraw")
	    public String menu(Model model, HttpSession session) {
	        model.addAttribute("account", new PrimaryAccount());
	        int accnum = (int)session.getAttribute("accountNum");
	        model.addAttribute("accnum", accnum);
	        return "withdraw"; //view
	    }
	    
	    
	    @PostMapping("/Primary Account-Amount withdraw")
	    public String withdrawMoney(@ModelAttribute PrimaryAccount account, HttpSession session, Model model) {
	        int accountNum = (Integer)session.getAttribute("accountNum");
	        boolean result = account.withdrawMoney(accountNum,
	                account.getAccountBalance());
	        Object balance = account.getAccountBalance();
	        if (result) {
	            model.addAttribute("message", "You withdrew $" + account.getAccountBalance());
	            model.addAttribute("balance", balance);
	            model.addAttribute("accountNum", accountNum);
	        } else {
	            model.addAttribute("message", "Low balance. Could not withdraw. ");
	        }
	        return "withdraw";
	    }
	    
//----------------------------------Primary Account Deposit--------------------------------------	    
	    @GetMapping("/Primary Account-Amount deposit")
	    public String deposit(Model model) {
	        model.addAttribute("account", new PrimaryAccount());
	        return "deposit"; //view
	    }
	    
	    @PostMapping("/Primary Account-Amount deposit")
	    public String depositMoney(@ModelAttribute PrimaryAccount account, HttpSession session, Model model) {
	        int accountNum = (Integer)session.getAttribute("accountNum");
	        boolean result = PrimaryAccount.depositMoney(accountNum,
	                account.getAccountBalance());
	        Object balance = account.getAccountBalance(accountNum);
	        if (result) {
	            model.addAttribute("message", "You deposited $" + account.getAccountBalance());
	            model.addAttribute("balance", balance);
	            model.addAttribute("accountNum", accountNum);
	        } else {
	            model.addAttribute("message", "Error while depositing.");
	        }
	        return "deposit";
	    }
	    
//---------------------------Savings Account Withdraw--------------------------------------------	
		
	    @GetMapping("/Savings Account-Amount withdraw")
	    public String menu1(Model model, HttpSession session) {
	        model.addAttribute("account", new SavingsAccount());
	        int accnum = (int)session.getAttribute("accountNum");
	        model.addAttribute("accnum", accnum);
	        return "withdraw"; //view
	    }
	    
	    
	    @PostMapping("/Savings Account-Amount withdraw")
	    public String withdrawMoney1(@ModelAttribute SavingsAccount account, HttpSession session, Model model) {
	        int accountNum = (Integer)session.getAttribute("accountNum");
	        boolean result = account.withdrawMoney(accountNum,
	                account.getAccountBalance());
	        Object balance = account.getAccountBalance();
	        if (result) {
	            model.addAttribute("message", "You withdrew $" + account.getAccountBalance());
	            model.addAttribute("balance", balance);
	            model.addAttribute("accountNum", accountNum);
	        } else {
	            model.addAttribute("message", "Low balance. Could not withdraw. ");
	        }
	        return "withdraw";
	    }
	    
//----------------------------------Savings Account Deposit--------------------------------------	    
	    @GetMapping("/Savings Account-Amount deposit")
	    public String deposit1(Model model) {
	        model.addAttribute("account", new SavingsAccount());
	        return "deposit"; //view
	    }
	    
	    @PostMapping("/Savings Account-Amount deposit")
	    public String depositMoney1(@ModelAttribute SavingsAccount account, HttpSession session, Model model) {
	        int accountNum = (Integer)session.getAttribute("accountNum");
	        boolean result = PrimaryAccount.depositMoney(accountNum,
	                account.getAccountBalance());
	        Object balance = account.getAccountBalance(accountNum);
	        if (result) {
	            model.addAttribute("message", "You deposited $" + account.getAccountBalance());
	            model.addAttribute("balance", balance);
	            model.addAttribute("accountNum", accountNum);
	        } else {
	            model.addAttribute("message", "Error while depositing.");
	        }
	        return "deposit";
	    }

}
