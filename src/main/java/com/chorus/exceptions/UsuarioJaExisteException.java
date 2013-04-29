package com.chorus.exceptions;

public class UsuarioJaExisteException extends Exception {

	private static final long serialVersionUID = -2069914908618501521L;

	public UsuarioJaExisteException() {
		super();
	}

	public UsuarioJaExisteException(String message, Throwable cause) {
		super(message, cause);
	}

	public UsuarioJaExisteException(String message) {
		super(message);
	}

	public UsuarioJaExisteException(Throwable cause) {
		super(cause);
	}

}
