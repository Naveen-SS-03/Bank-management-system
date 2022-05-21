package com.capg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.entity.Appointment;
import com.capg.exceptions.RecordNotFoundException;
import com.capg.repository.AppointmentRepository;

@RestController
@RequestMapping("/Appointment")
public class AppointmentController {
	    
		@Autowired
		private AppointmentRepository service;
		  
	    @GetMapping("/appointment-list")
	    public List<Appointment> getAllappointments() {
		   return (List<Appointment>) service.findAll();		
		}
	    
		@GetMapping("/appointment-list/{AppointmentId}")
		public ResponseEntity<Appointment> getAppointment(@PathVariable("AppointmentId") int AppointmentId) throws RecordNotFoundException {
			Appointment app = service.getAppointmentById(AppointmentId);
			return new ResponseEntity<Appointment>(app, HttpStatus.OK);
		}
 
		@PostMapping( "/appointment-save") 
	    public ResponseEntity<Appointment> createAppointment(@Validated @RequestBody Appointment app) {
	       Appointment appointment = service.save(app);
		   return new ResponseEntity<Appointment>(appointment, HttpStatus.CREATED);
		 } 
		   
		@PutMapping( "/update-appointment") 
	    public ResponseEntity<Appointment> updateAppointment(@Validated @RequestBody Appointment app) {
		   Appointment appointment = service.save(app);
		   return new ResponseEntity<Appointment>(appointment, HttpStatus.CREATED);
		 }  
}
