package edu.gmu.spring.rest;

public class TypeMismatchException extends RuntimeException {

	public TypeMismatchException(String message, Throwable cause) {
		super(message, cause);
	}

	public TypeMismatchException(String message) {
		super(message);
	}

	public TypeMismatchException(Throwable cause) {
		super(cause);
	}
}
