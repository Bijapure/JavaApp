package com.hradmin.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

public class ApiResponseEntity {

	private final String message;
	//private final Throwable throwable;
	private final HttpStatus httpStatus;
	private final ZonedDateTime zonedDateTime;
	
	public ApiResponseEntity(String message, HttpStatus httpStatus, ZonedDateTime zonedDateTime) {
		super();
		this.message = message;
	//	this.throwable = throwable;
		this.httpStatus = httpStatus;
		this.zonedDateTime = zonedDateTime;
	}

	public String getMessage() {
		return message;
	}

//	public Throwable getThrowable() {
//		return throwable;
//	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public ZonedDateTime getZonedDateTime() {
		return zonedDateTime;
	}
	
	

}
