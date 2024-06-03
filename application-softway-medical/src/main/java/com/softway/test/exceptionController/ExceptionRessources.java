package com.softway.test.exceptionController;

import java.time.OffsetDateTime;

import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;

//This class is a RestControllerAdvice that handles exceptions thrown in the application and provides a standardized API error response.
@RestControllerAdvice
public class ExceptionRessources {

	// This method handles PatientException, which typically indicates a resource
	// not found.
	// It sets the response status to NOT_FOUND (404) and builds an ApiError object
	// with relevant details.
	@ExceptionHandler(PatientException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ApiError handle(PatientException exception, ServletWebRequest request) {
		return ApiError.builder().label(HttpStatus.NOT_FOUND.getReasonPhrase())
				.path(request.getRequest().getRequestURI()).status(HttpStatus.NOT_FOUND.value())
				.timestamp(OffsetDateTime.now())
				// The message from the PatientException is included in the error response.
				.message(exception.getMessage()).build();
	}

	// This method handles generic Exceptions, which are usually unexpected server
	// errors.
	// It sets the response status to INTERNAL_SERVER_ERROR (500) and builds an
	// ApiError object.
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ApiError handle(Exception exception, ServletWebRequest request) {
		return ApiError.builder().timestamp(OffsetDateTime.now()).path(request.getRequest().getRequestURI())
				// The message from the Exception is included in the error response.
				.message(exception.getMessage()).status(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.label(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()).build();
	}

	// This method handles BadRequestException, which typically indicates an invalid
	// request.
	// It sets the response status to BAD_REQUEST (400) and builds an ApiError
	// object.
	@ExceptionHandler(BadRequestException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiError handle(BadRequestException exception, ServletWebRequest request) {
		return ApiError.builder().timestamp(OffsetDateTime.now()).path(request.getRequest().getRequestURI())
				// The message from the BadRequestException is included in the error response.
				.message(exception.getMessage()).status(HttpStatus.BAD_REQUEST.value())
				.label(HttpStatus.BAD_REQUEST.getReasonPhrase()).build();
	}
}
