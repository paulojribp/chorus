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
