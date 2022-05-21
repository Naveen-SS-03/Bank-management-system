package com.capg.service;

import java.util.List;

import com.capg.entity.Appointment;
import com.capg.exceptions.RecordNotFoundException;

public interface AppointmentService {

	List<Appointment> findAll();

	Appointment getAppointmentById(int appointmentId) throws RecordNotFoundException;

	List<Appointment> getAllAppointments() throws RecordNotFoundException;

	Appointment getAppointmentById1(int id) throws RecordNotFoundException;

	void updateAppointment(Appointment appointment) throws RecordNotFoundException;

	Appointment addAppointments(Appointment app);
}
