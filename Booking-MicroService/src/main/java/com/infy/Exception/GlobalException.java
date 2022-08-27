package com.infy.Exception;

import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<String> handel(ConstraintViolationException ex){
		String error=ex.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(""));
		return new ResponseEntity<String>(error,HttpStatus.BAD_GATEWAY);
	}

}
