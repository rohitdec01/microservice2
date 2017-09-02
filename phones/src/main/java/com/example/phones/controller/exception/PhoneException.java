package com.example.phones.controller.exception;

/**
 * @author rb611j
 *
 */
public class PhoneException extends Exception {

	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public PhoneException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public PhoneException() {
		super();
	}
}
