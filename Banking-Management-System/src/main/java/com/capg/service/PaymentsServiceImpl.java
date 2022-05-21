package com.capg.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.capg.entity.Payments;
import com.capg.repository.PaymentsRepository;

public class PaymentsServiceImpl implements PaymentsService {

	@Autowired
	private PaymentsRepository paymentsRepository;
	
	@Override
	public Payments addPayments(Payments payment){
	       return paymentsRepository.save(payment);
	}


}
