package com.tritux.ws.validation.exception;

@SuppressWarnings("serial")
public class EmailExistsException extends Throwable {

	public EmailExistsException(String message) {
		super(message);
	}

}
