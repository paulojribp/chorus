package com.chorus.exceptions;

public class UsuarioEmailInvalidoException extends Exception {

	private static final long serialVersionUID = 5977461693807623613L;

	public UsuarioEmailInvalidoException() {
	}

	public UsuarioEmailInvalidoException(String message) {
		super(message);
	}

	public UsuarioEmailInvalidoException(Throwable cause) {
		super(cause);
	}

	public UsuarioEmailInvalidoException(String message, Throwable cause) {
		super(message, cause);
	}

}
