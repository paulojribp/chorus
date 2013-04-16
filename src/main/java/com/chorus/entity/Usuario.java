/*
 * Copyright 2012 Sagarana Tech.  All rigths reserved.
 *
 * This software is the confidential and proprietary information of
 * Sagarana Tech ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with Sagarana Tech.
 */
package com.chorus.entity;

import java.io.Serializable;

/**
 * 
 * @author kete@sagaranatech.com
 * @since Apr 15, 2013
 * @version $Revision: $ <br>
 *          $Date: $ <br>
 *          $Author: $
 */
public class Usuario implements Serializable{

	private static final long	serialVersionUID	= -1025205414857764041L;

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
