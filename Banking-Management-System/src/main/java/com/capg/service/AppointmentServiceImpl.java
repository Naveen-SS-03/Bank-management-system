package com.capg.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entity.Appointment;
import com.capg.exceptions.RecordNotFoundException;
import com.capg.repository.AppointmentRepository;


@Service
public class AppointmentServiceImpl implements AppointmentService {
	
	@Autowired
	AppointmentRepository repository;
	
	@Override
	public List<Appointment> getAllAppointments() throws RecordNotFoundException {
		 List<Appointment> list = new ArrayList<Appointment>();
		 repository.findAll().forEach(add1 -> list.add(add1));
		 return list;
	} 
	
	@Override
	public Appointment getAppointmentById1(int id) throws RecordNotFoundException {
		if(repository.findById(id).isPresent()) {
			Appointment appointment=repository.findById(id).get();
		        return appointment;
	} else {
	    throw new RecordNotFoundException("Appointment with Id" +id + "doesn't exist");
		}
	}	
	
	@Override
	public void updateAppointment(Appointment appointment) throws RecordNotFoundException {
		if(repository.findById(appointment.updateAppointment()).isPresent()) {
		        repository.save(appointment);
	} else {
	    throw new RecordNotFoundException("Appointment Id" + appointment + "doesn't exist");
		}
	}

	@Override
	public List<Appointment> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Appointment getAppointmentById(int appointmentId) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Appointment addAppointments(Appointment app) {
		// TODO Auto-generated method stub
		return null;
	}	
}

