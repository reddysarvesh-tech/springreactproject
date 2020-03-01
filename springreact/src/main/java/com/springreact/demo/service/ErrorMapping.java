package com.springreact.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@Service
public class ErrorMapping {
	
	
	public ResponseEntity<?> mapErrors(BindingResult result){
		if(result.hasErrors()) {
			Map<String, String> errormap = new HashMap<String,String>();
			for(FieldError errors: result.getFieldErrors()) {
				errormap.put(errors.getField(), errors.getDefaultMessage());
			}
			return new ResponseEntity<Map>(errormap,HttpStatus.BAD_REQUEST);
		}
		return null;
	}

}
