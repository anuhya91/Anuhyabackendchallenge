package com.enroll.service.exceptions;

import java.sql.SQLException;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler 
{

	@ExceptionHandler(value = ResourceAlreadyExist.class)
	public ResponseEntity<ApiError> ResourceAlreadyExist(ResourceAlreadyExist exception, WebRequest request) {

		ApiError apiError = new ApiError(new Date(), exception.getMsg(), request.getDescription(false),
				HttpStatus.CONFLICT.getReasonPhrase());

		return new ResponseEntity<ApiError>(apiError, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(value = ResourceNotFoundException.class)
	public ResponseEntity<ApiError> ResourceNotFoundException(ResourceNotFoundException exception, WebRequest request) {

		ApiError apiError = new ApiError(new Date(), exception.getMsg(), request.getDescription(false),
				HttpStatus.NOT_FOUND.getReasonPhrase());

		return new ResponseEntity<ApiError>(apiError, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = SQLException.class)

	public ResponseEntity<ApiError> sqlException(SQLException exception, WebRequest request) {

		ApiError apiError = new ApiError(new Date(), "Unable to connect to DB", request.getDescription(false),

				HttpStatus.SERVICE_UNAVAILABLE.getReasonPhrase());

		return new ResponseEntity<ApiError>(apiError, HttpStatus.SERVICE_UNAVAILABLE);

	}

	@ExceptionHandler(value = Exception.class)

	public ResponseEntity<ApiError> exception(Exception exception, WebRequest request) {

		ApiError apiError = new ApiError(new Date(), "Something Went Wrong", request.getDescription(false),

				HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());

		return new ResponseEntity<ApiError>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);

	}
}