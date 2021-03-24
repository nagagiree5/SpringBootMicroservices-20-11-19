package com.springboot.microservices.advice;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.springboot.microservices.exceptions.NoSuchUserException;


  
@RestControllerAdvice
public class PlanDetailsAdvice {
	
	@ExceptionHandler(NoSuchUserException.class)
	public     ResponseEntity<ErrorMessage>    exceptionHandler1(NoSuchUserException   e){
		ErrorMessage    errMessage=new  ErrorMessage();
		errMessage.setErrorCode("500");
		errMessage.setErrorMessage("User with given Id  doesn't exist in Database");
		return    new   ResponseEntity<ErrorMessage>(errMessage, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public    ResponseEntity<ErrorMessage>    exceptionHandler2(Exception   e) {
		ErrorMessage    errMessage =new  ErrorMessage();
		errMessage.setErrorCode("400");
		errMessage.setErrorMessage("The request url is not valid");
		return   new  ResponseEntity<ErrorMessage>(errMessage, HttpStatus.NOT_FOUND);
	}

}
