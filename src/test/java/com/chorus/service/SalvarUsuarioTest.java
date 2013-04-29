package com.chorus.service;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import com.chorus.dao.UsuarioDao;
import com.chorus.dto.UsuarioDto;
import com.chorus.exceptions.UsuarioConfirmacaoSenhaException;
import com.chorus.exceptions.UsuarioEmailInvalidoException;
import com.chorus.exceptions.UsuarioSenhaInvalidaException;
import com.chorus.exceptions.UsuarioUsernameInvalidoException;

public class SalvarUsuarioTest {
	
	private UsuarioService service;
	private UsuarioDao usuarioDao;

	@Before
	public void beforeClass() {
		usuarioDao = mock(UsuarioDao.class);
		service = new UsuarioServiceImpl(usuarioDao);
	}
	
	private UsuarioDto getUsuarioExemplo() {
		UsuarioDto usuario = new UsuarioDto();
		usuario.setUsername("username");
		usuario.setSenha("senha6");
		usuario.setConfirmaSenha("senha6");
		usuario.setEmail("maluco@beleza.com");
		
		return usuario;
	}

	@Test(expected = UsuarioUsernameInvalidoException.class)
	public void salvarUsuarioComLoginNull() throws Exception {
		UsuarioDto usuario = getUsuarioExemplo();
		usuario.setUsername(null);
		
		service.salvar(usuario);
	}

	@Test(expected = UsuarioSenhaInvalidaException.class)
	public void salvarUsuarioComSenhaNull() throws Exception {
		UsuarioDto usuario = getUsuarioExemplo();
		usuario.setSenha(null);
		
		service.salvar(usuario);
	}

	@Test(expected = UsuarioConfirmacaoSenhaException.class)
	public void salvarUsuarioComConfirmacaoSenhaInvalida() throws Exception {
		UsuarioDto usuario = getUsuarioExemplo();
		usuario.setSenha("senha6");
		usuario.setConfirmaSenha("ssssss");
		
		service.salvar(usuario);
	}
	
	@Test(expected = UsuarioEmailInvalidoException.class)
	public void salvarUsuarioComEmailNull() throws Exception {
		UsuarioDto usuario = getUsuarioExemplo();
		usuario.setEmail(null);
		
		service.salvar(usuario);
	}

	@Test(expected = UsuarioSenhaInvalidaException.class)
	public void salvarUsuarioComSenhaMenorQSeis() throws Exception {
		UsuarioDto usuario = getUsuarioExemplo();
		usuario.setSenha("1234");
		
		service.salvar(usuario);
	}

}
