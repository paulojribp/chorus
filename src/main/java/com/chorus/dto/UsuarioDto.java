package com.chorus.dto;

import com.chorus.entity.Usuario;

public class UsuarioDto {

	private String username;
	
	private String email;
	
	private String senha;
	
	private String confirmaSenha;

	public Usuario getUsuario() {
		Usuario u = new Usuario();
		u.setUsername(username);
		u.setEmail(email);
		u.setSenha(senha);
		
		return u;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmaSenha() {
		return confirmaSenha;
	}

	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}
	
}
