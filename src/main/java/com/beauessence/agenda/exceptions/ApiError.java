package com.beauessence.agenda.exceptions;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ApiError {

	private HttpStatus status;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
    private List<String> messages;
	private String debugMessage;
	
	private ApiError() {
		timestamp = LocalDateTime.now();
	}
	
	ApiError(HttpStatus status){
		this();
		this.status=status;
	}
	
	ApiError(HttpStatus status, Throwable ex) {
		this();
		this.status = status;
		this.messages = Arrays.asList(new String[] {"Unexpected error"});
		this.debugMessage = ex.getLocalizedMessage();
	}

	ApiError(HttpStatus status, List<String> messages, Throwable ex) {
		this();
		this.status = status;
		this.messages = messages;
		this.debugMessage = ex.getLocalizedMessage();
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessage(List<String> messages) {
		this.messages = messages;
	}

	public String getDebugMessage() {
		return debugMessage;
	}

	public void setDebugMessage(String debugMessage) {
		this.debugMessage = debugMessage;
	}
   
}
