package com.springreact.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomEntityExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<Object> handleProjectIdException(ProjectIDException ex, WebRequest req){
		ProjectIDExceptionResponse errorresponse = new ProjectIDExceptionResponse(ex.getMessage());
		return new ResponseEntity(errorresponse,HttpStatus.BAD_REQUEST);
	}

}
