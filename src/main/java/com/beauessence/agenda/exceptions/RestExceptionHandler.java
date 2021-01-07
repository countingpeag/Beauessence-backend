package com.beauessence.agenda.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		String error = "Malformed JSON request";
		List<String> errorMessages = Arrays.asList(new String[] {error});
		return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, errorMessages, ex));
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex){
		ApiError apiError = new ApiError(HttpStatus.SEE_OTHER);
		List<String> errorMessages = Arrays.asList(new String[] {ex.getMessage()});
		apiError.setMessage(errorMessages);
		return buildResponseEntity(apiError);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Object> handleEntityNotFound(ConstraintViolationException ex){
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
		List<String> errorMessages = ex.getConstraintViolations().stream().map(x -> x.getMessage()).collect(Collectors.toList());
		apiError.setMessage(errorMessages);
		return buildResponseEntity(apiError);
	}
}
