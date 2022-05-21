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

import com.capg.entity.Recipient;
import com.capg.exceptions.RecordNotFoundException;
import com.capg.repository.RecipientRepository;
import com.capg.service.RecipientServiceImpl;



@RestController
@RequestMapping("/RecipientDetails")
public class RecipientController {
	
	@Autowired
	private RecipientServiceImpl RecipientService;
	@Autowired
	private RecipientRepository RecipientRepository;
	
	@PostMapping("/createRecipient")
	public ResponseEntity<Recipient> createRecipient(@RequestBody Recipient Recipient) throws RecordNotFoundException{
		Recipient bd = RecipientService.addRecipient(Recipient);
		return new ResponseEntity<Recipient>(bd,HttpStatus.CREATED);
	}
	@PutMapping("/updateRecipient")
	public ResponseEntity<Recipient> updateRecipient(@RequestBody Recipient Recipient) throws RecordNotFoundException{
		Integer id = Recipient.getRecipientId();
	    if(RecipientRepository.findById(id).isPresent()) {
	    	Recipient bd = RecipientService.updateRecipient(Recipient);
	    return new ResponseEntity<Recipient>(bd,HttpStatus.OK);
	    }
	    else {
	    	throw new RecordNotFoundException("Recipient Details with Id: "+id+" not found!!");
	    }
	}
	@DeleteMapping("/deleteById/{Recipient_id}")
	public ResponseEntity<String> deleteRecipient(@PathVariable int Recipient_id) throws RecordNotFoundException{
	    if(RecipientRepository.findById(Recipient_id).isPresent()) {
	    	String bd = RecipientService.removeRecipientByRecipientId(Recipient_id);
	    return new ResponseEntity<String>(bd,HttpStatus.OK);
	    }
	    else {
	    	throw new RecordNotFoundException("Recipient Details with Id: "+Recipient_id+" not found!!");
	    }
	}
	@GetMapping("/getById/{Recipient_id}")
	public ResponseEntity<Recipient> getRecipient(@PathVariable int Recipient_id) throws RecordNotFoundException{
	    if(RecipientRepository.findById(Recipient_id).isPresent()) {
	    	Recipient bd = RecipientService.showRecipientByRecipientId(Recipient_id);
	    return new ResponseEntity<Recipient>(bd,HttpStatus.OK);
	    }
	    else {
	    	throw new RecordNotFoundException("Recipient Details with Id: "+Recipient_id+" not found!!");
	    }
	}
	@GetMapping("/list")
	public List<Recipient> getAllRecipient(){
		return RecipientService.showAllRecipient();
	}
}