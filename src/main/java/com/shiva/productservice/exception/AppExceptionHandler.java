package com.shiva.productservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler(value = ResourceNotFoundException.class)
	public ResponseEntity<Void> handleResourceNotFoundException(Exception ex, WebRequest request) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(value = BadRequestException.class)
	public ResponseEntity<Void> handleBadRequestException(Exception ex, WebRequest request) {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}

}
