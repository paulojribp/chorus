package com.chorus.entity;

import java.io.Serializable;

import javax.persistence.Column;
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
public class Usuario implements Serializable{

	private static final long	serialVersionUID	= -1025205414857764041L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USUARIO_SEQ")
	@SequenceGenerator(name="USUARIO_SEQ", sequenceName="USUARIO_SEQ", allocationSize=1)
	private Integer	id;

	@Column(unique=true)
	private String username;
	
	private String senha;
	
	private String email;

	public Usuario(){}
	
	public Usuario(String username){
		this.username = username;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
		return (username != null && !username.isEmpty());
	}

}
