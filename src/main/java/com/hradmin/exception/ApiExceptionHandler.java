package com.hradmin.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{

	
	@ExceptionHandler(DAOException.class)
	public ResponseEntity<?> handleApiException(DAOException e)
	{
		HttpStatus badRequest=HttpStatus.BAD_REQUEST;
		ApiResponseEntity apiResponseEntity=new ApiResponseEntity(e.getMessage(), badRequest,
				ZonedDateTime.now(ZoneId.of("Z")));
		 return new ResponseEntity<>(apiResponseEntity,badRequest);
	}
	
	@ExceptionHandler(RecordsNotFoundException.class)
	public ResponseEntity<?> handleApiUserNotFoundException(RecordsNotFoundException e)
	{
		HttpStatus notFound=HttpStatus.NOT_FOUND;
		ApiResponseEntity apiResponseEntity=new ApiResponseEntity(e.getMessage(), notFound,
				ZonedDateTime.now(ZoneId.of("Z"))
				);
		 return new ResponseEntity<>(apiResponseEntity,notFound);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handlGlobalException(Exception e)
	{
		HttpStatus internalServerError=HttpStatus.INTERNAL_SERVER_ERROR;
		ApiResponseEntity apiResponseEntity=new ApiResponseEntity(e.getMessage(), internalServerError,
				ZonedDateTime.now(ZoneId.of("Z"))
				);
		 return new ResponseEntity<>(apiResponseEntity,internalServerError);
	}
}
