package com.chorus.exceptions;

public class UsuarioSenhaInvalidaException extends Exception {

	private static final long serialVersionUID = 1134538488891825417L;

	public UsuarioSenhaInvalidaException() {
	}

	public UsuarioSenhaInvalidaException(String message) {
		super(message);
	}

	public UsuarioSenhaInvalidaException(Throwable cause) {
		super(cause);
	}

	public UsuarioSenhaInvalidaException(String message, Throwable cause) {
		super(message, cause);
	}

}
