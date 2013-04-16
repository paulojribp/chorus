/*
 * Copyright 2012 Sagarana Tech.  All rigths reserved.
 *
 * This software is the confidential and proprietary information of
 * Sagarana Tech ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with Sagarana Tech.
 */
package com.chorus.entity;

/**
 * 
 * @author kete@sagaranatech.com
 * @since Apr 15, 2013
 * @version $Revision: $ <br>
 *          $Date: $ <br>
 *          $Author: $
 */
public class Chorus {

	private Integer	id;
	private String	mensagem;
	private Usuario	usuario;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
