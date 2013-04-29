package com.chorus.exceptions;

public class UsuarioUsernameInvalidoException extends Exception {

	private static final long serialVersionUID = -5786118015526921677L;

	public UsuarioUsernameInvalidoException() {
		super();
	}

	public UsuarioUsernameInvalidoException(String message, Throwable cause) {
		super(message, cause);
	}

	public UsuarioUsernameInvalidoException(String message) {
		super(message);
	}

	public UsuarioUsernameInvalidoException(Throwable cause) {
		super(cause);
	}

}
