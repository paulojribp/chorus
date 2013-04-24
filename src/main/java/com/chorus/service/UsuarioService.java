package com.chorus.service;

import java.util.List;

import com.chorus.entity.Usuario;

public interface UsuarioService {

	String salvarUsuario(Usuario usuario) throws Exception;
	
	List<Usuario> findByUsuario(Usuario usuario);
	
	

}
