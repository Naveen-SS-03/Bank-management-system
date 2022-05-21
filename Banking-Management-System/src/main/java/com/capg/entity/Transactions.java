package com.capg.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;
@Data
@Entity
public class Transactions {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY )
	private int transaction_id;
	private double amount;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="account_id")
	private PrimaryAccount account;
	
}
