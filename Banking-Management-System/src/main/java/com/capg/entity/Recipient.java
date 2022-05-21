package com.capg.entity;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recipient {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "recipient_id")
	private int RecipientId;
	@Column(name = "recipient_name")
	private String name;
	@Column(name = "recipient_phonenumber")
	private int phonenumber;	
	@Column(name = "accountNumber")
	private int accountnumber;
	private double amount;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="account_id")
	private PrimaryAccount account;
		
}