package com.chorus.service;

import java.util.List;

import com.chorus.dto.UsuarioDto;
import com.chorus.entity.Usuario;

public interface UsuarioService {

	String salvar(UsuarioDto usuario) throws Exception;
	
	List<Usuario> findByUsuario(Usuario usuario);
	
	

}
