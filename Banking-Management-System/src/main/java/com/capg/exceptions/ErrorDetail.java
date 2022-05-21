package com.capg.exceptions;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor 
@AllArgsConstructor
public class ErrorDetail{

	
	private Date timestamp;
	
	private String message;
	
	private String details;

}
