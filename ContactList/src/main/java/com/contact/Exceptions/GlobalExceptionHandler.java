package com.contact.Exceptions;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NameNotFoundException.class)
	public ResponseEntity<ErrorDetails> nameNotFoundException(NameNotFoundException nfd, WebRequest wf){
		ErrorDetails eDetails= new ErrorDetails();
		eDetails.setTimestamp(LocalDate.now());
		eDetails.setMessage(nfd.getMessage());
		eDetails.setDetail(wf.getDescription(false));
		
		return new ResponseEntity<>(eDetails,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(NumberNotFoundException.class)
	public ResponseEntity<ErrorDetails> numberNotFoundException(NumberNotFoundException nfd, WebRequest wf){
		ErrorDetails eDetails= new ErrorDetails();
		eDetails.setTimestamp(LocalDate.now());
		eDetails.setMessage(nfd.getMessage());
		eDetails.setDetail(wf.getDescription(false));
		
		return new ResponseEntity<>(eDetails,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(ContactNotFoundException.class)
	public ResponseEntity<ErrorDetails> contactNotFoundException(ContactNotFoundException nfd, WebRequest wf){
		ErrorDetails eDetails= new ErrorDetails();
		eDetails.setTimestamp(LocalDate.now());
		eDetails.setMessage(nfd.getMessage());
		eDetails.setDetail(wf.getDescription(false));
		
		return new ResponseEntity<>(eDetails,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(ContactalreadyExitsException.class)
	public ResponseEntity<ErrorDetails> ContactalreadyExitsException(ContactalreadyExitsException nfd, WebRequest wf){
		ErrorDetails eDetails= new ErrorDetails();
		eDetails.setTimestamp(LocalDate.now());
		eDetails.setMessage(nfd.getMessage());
		eDetails.setDetail(wf.getDescription(false));
		
		return new ResponseEntity<>(eDetails,HttpStatus.BAD_REQUEST);
		
	}
	
	

}
