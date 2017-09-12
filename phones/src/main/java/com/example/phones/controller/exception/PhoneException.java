package com.example.phones.controller.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author rb611j
 *
 */
/*@ResponseStatus(org.springframework.http.HttpStatus.NOT_FOUND)*/
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
