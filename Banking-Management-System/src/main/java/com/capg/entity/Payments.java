package com.capg.entity;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;
@Entity@Data

public class Payments {
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int payment_id;
 
@OneToOne(cascade = CascadeType.ALL)
 @JoinColumn(name="transaction_id")
private Transactions transactions;

}