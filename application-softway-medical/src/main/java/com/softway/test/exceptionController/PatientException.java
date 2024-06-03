package com.softway.test.exceptionController;

//This class represents a custom exception specific to patient-related errors.
//It extends RuntimeException, making it an unchecked exception.
public class PatientException extends RuntimeException {

	// Constructor that takes an error message and passes it to the superclass
	// (RuntimeException).
	public PatientException(String message) {
		super(message);
	}
}
