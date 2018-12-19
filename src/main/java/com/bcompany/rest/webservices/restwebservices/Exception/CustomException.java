package com.bcompany.rest.webservices.restwebservices.Exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bcompany.rest.webservices.restwebservices.User.UserNotFoundException;

@ControllerAdvice
@RestController

public class CustomException 
extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, 
			WebRequest request){
		ExceptionResponse exceptionResponse  = new ExceptionResponse(new Date(),
				ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, 
			WebRequest request){
		ExceptionResponse exceptionResponse  = new ExceptionResponse(new Date(),
				ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity(exceptionResponse,HttpStatus.NOT_FOUND);
	}


}
