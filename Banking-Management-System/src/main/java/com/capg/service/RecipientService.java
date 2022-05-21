package com.capg.service;

import java.util.List;

import com.capg.entity.Recipient;

public interface RecipientService {

	Recipient addRecipient(Recipient recipient);

	Recipient updateRecipient(Recipient recipient);

	String removeRecipientByRecipientId(int recipientID);

	List<Recipient> showAllRecipient();

	Recipient showRecipientByRecipientId(int recipientID);

	void deleteRecipient(int recipientid);

}
