package com.epam.simpleShell.exception;

public class InvalidInputException extends InternalException {
	private static final long serialVersionUID = 1L;
	public InvalidInputException(String message) {
		super(message);
	}
}
