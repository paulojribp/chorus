package com.chorus.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * 
 * @author kete@sagaranatech.com
 */
@Entity
public class Chorus {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CHORUS_SEQ")
	@SequenceGenerator(name="CHORUS_SEQ", sequenceName="CHORUS_SEQ", allocationSize=1)
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
