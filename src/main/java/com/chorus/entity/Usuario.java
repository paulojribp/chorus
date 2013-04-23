package com.chorus.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 
 * @author kete@sagaranatech.com
 * @since Apr 15, 2013
 * @version $Revision: $ <br>
 *          $Date: $ <br>
 *          $Author: $
 */
@Entity
public class Usuario implements Serializable{

	private static final long	serialVersionUID	= -1025205414857764041L;

	@Id
	private Integer	id;
	
	private String	login;
	
	private String	senha;
	
	private String	email;

	public Usuario(){}
	public Usuario(String login){
		this.login = login;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isValido(){
		return (login != null && !login.isEmpty());
	}
}
