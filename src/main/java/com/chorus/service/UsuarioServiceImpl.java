package com.chorus.service;

import java.util.List;

import br.com.caelum.vraptor.ioc.Component;

import com.chorus.dao.UsuarioDao;
import com.chorus.dto.UsuarioDto;
import com.chorus.entity.Usuario;
import com.chorus.exceptions.UsuarioConfirmacaoSenhaException;
import com.chorus.exceptions.UsuarioEmailInvalidoException;
import com.chorus.exceptions.UsuarioJaExisteException;
import com.chorus.exceptions.UsuarioSenhaInvalidaException;
import com.chorus.exceptions.UsuarioUsernameInvalidoException;

@Component
public class UsuarioServiceImpl implements UsuarioService {

	private UsuarioDao dao;
	
	public UsuarioServiceImpl(UsuarioDao usuarioDao) {
		dao = usuarioDao;
	}

	private void validar(UsuarioDto usuario) throws Exception {
		Usuario userToSave = usuario.getUsuario();
		
		if (userToSave.getSenha() == null || userToSave.getSenha().length() < 6) {
			throw new UsuarioSenhaInvalidaException("Senha deve ser maior que 6 caracteres");
		}
		if (!usuario.getSenha().equals(usuario.getConfirmaSenha())) {
			throw new UsuarioConfirmacaoSenhaException("A confirmação de senha é inválida");
		}
		if (userToSave == null || !userToSave.isValido()) {
			throw new UsuarioUsernameInvalidoException("Usuário não é válido.");
		}
		if (userToSave.getUsername() == null) {
			throw new UsuarioUsernameInvalidoException("Username não pode ser nulo");
		}
		if (userToSave.getEmail() == null) {
			throw new UsuarioEmailInvalidoException("Email não pode ser nulo");
		}
		
		List<Usuario> users = dao.findByUsuario(userToSave);
		if(users != null && !users.isEmpty()){
			throw new UsuarioJaExisteException("Usuario já existe");
		}	
	}

	@Override
	public String salvar(UsuarioDto usuario) throws Exception {
		validar(usuario);
		dao.create(usuario.getUsuario());
		return usuario.getUsername();
	}

	@Override
	public List<Usuario> findByUsuario(Usuario usuario) {
		return dao.findByUsuario(usuario);
	}

}
