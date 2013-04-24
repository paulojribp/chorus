package com.chorus.service;

import java.util.List;

import br.com.caelum.vraptor.ioc.Component;

import com.chorus.dao.UsuarioDao;
import com.chorus.entity.Usuario;

@Component
public class UsuarioServiceImpl implements UsuarioService {

	public UsuarioServiceImpl() {

	}

	
	
	
	private UsuarioDao dao;

	private void validar(Usuario usuario) throws Exception {
		Usuario userExists = new Usuario();
		if (usuario == null || !usuario.isValido()) {
			throw new Exception("Usuario nao encontrado.");
		}
		if (usuario.getSenha().length() < 6) {
			throw new Exception("Senha deve ser maior que 6");
		}
		if (usuario.getLogin() == null) {
			throw new Exception("Login nao pode ser nulo");
		}
		if (usuario.getEmail() == null) {
			throw new Exception("Email nao pode ser nulo");
		}
		if(dao.findByUsuario(usuario).get(0).getLogin().equals(userExists.getLogin())){
			throw new Exception("Usuario já existe");
		}	

	}

	@Override
	public String salvarUsuario(Usuario usuario) throws Exception {
		validar(usuario);
		dao.create(usuario);
		return dao.findByUsuario(usuario).get(0).getLogin();
	}

	@Override
	public List<Usuario> findByUsuario(Usuario usuario) {
		return dao.findByUsuario(usuario);
	}

}
