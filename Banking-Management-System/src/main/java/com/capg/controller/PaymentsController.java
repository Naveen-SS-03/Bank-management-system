package com.capg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.entity.Payments;
import com.capg.repository.PaymentsRepository;

@RestController
@RequestMapping("/payment")
public class PaymentsController {
	
	@Autowired
	private PaymentsRepository service;
	@PostMapping( "/payment-save") 
    public ResponseEntity<Payments> createPayments(@Validated @RequestBody Payments payments) {
       Payments payment = service.save(payments);
	   return new ResponseEntity<Payments>(payment, HttpStatus.CREATED);
	 } 
	
}

