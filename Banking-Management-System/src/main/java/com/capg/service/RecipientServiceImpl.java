package com.capg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entity.Recipient;
import com.capg.repository.RecipientRepository;


@Service
public class RecipientServiceImpl implements RecipientService{
	@Autowired
	private RecipientRepository recipientRepository;

	@Override
	public Recipient addRecipient(Recipient recipient){
	       return recipientRepository.save(recipient);
	}

	@Override
	public Recipient updateRecipient(Recipient recipient) {
		return recipientRepository.save(recipient);
	}

	@Override
	public String removeRecipientByRecipientId(int recipientID) {
		recipientRepository.deleteById(recipientID);
		return "Recipient Deleted";
	}

	@Override
	public List<Recipient> showAllRecipient() {
		return recipientRepository.findAll();
	}

	@Override
	public Recipient showRecipientByRecipientId(int recipientID) {
		return recipientRepository.findById(recipientID).get();
	}

	public void deleteRecipient(int recipientId) {
		// TODO Auto-generated method stub
		
	}
   
}