package com.example.demo.handler;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.error.ResourceNotFoundDetails;
import com.example.demo.error.ResourceNotFoundException;
import com.example.demo.error.ValidationErrorDetails;

@ControllerAdvice
public class RestExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException rfnException) {
		ResourceNotFoundDetails rfnDetails = ResourceNotFoundDetails.Builder.newBuilder()
		.timestamp(new Date(0).getTime())
		.status(HttpStatus.NOT_FOUND.value())
		.title("Not found")
		.detail(rfnException.getMessage())
		.developerMessage(rfnException.getClass().getName())
		.build();
		
		return new ResponseEntity<>(rfnDetails, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException manvException) {
		List<FieldError> fieldErros = manvException.getBindingResult().getFieldErrors();	
		String fields = fieldErros.stream().map(FieldError::getField).collect(Collectors.joining(""));
		String fieldMessages = fieldErros.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(""));
		ValidationErrorDetails rfnDetails = ValidationErrorDetails.Builder.newBuilder()
		.timestamp(new Date(0).getTime())
		.status(HttpStatus.BAD_REQUEST.value())
		.title("Field validation error")
		.detail("Field validation error")
		.developerMessage(manvException.getClass().getName())
		.field(fields)
		.fieldMessage(fieldMessages)
		.build();
		
		return new ResponseEntity<>(rfnDetails, HttpStatus.BAD_REQUEST);
	}

}
