package com.capg.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class SavingsAccount {
 @Id
 @GeneratedValue(strategy=GenerationType.SEQUENCE)
 private int id;
 private int accountnumber;
 private String name;
 private BigDecimal accountBalance;

 public SavingsAccount() {
 }
 

 public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public int getAccountnumber() {
	return accountnumber;
}

public void setAccountnumber(int accountnumber) {
	this.accountnumber = accountnumber;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public BigDecimal getAccountBalance() {
	return accountBalance;
}

public void setAccountBalance(BigDecimal accountBalance) {
	this.accountBalance = accountBalance;
}


public boolean withdrawMoney(int accountNum, BigDecimal accountBalance2) {
	// TODO Auto-generated method stub
	return false;
}


public Object getAccountBalance(int accountNum) {
	// TODO Auto-generated method stub
	return null;
}
}
