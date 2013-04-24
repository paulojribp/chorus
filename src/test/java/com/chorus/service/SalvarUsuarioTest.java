package com.chorus.service;

import static junit.framework.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.chorus.entity.Usuario;

public class SalvarUsuarioTest {
	private static UsuarioService service;

	@BeforeClass
	public static void beforeClass() {
		service = new UsuarioServiceImpl();
	}

	@Test(expected = Exception.class)
	public void salvarUsuarioComLoginNull() throws Exception {

		Usuario usuario = new Usuario();
		usuario.setLogin(null);
//		Usuario salvo = service.salvarUsuario(usuario);
//		assertEquals(salvo, usuario);
	}

	@Test(expected = Exception.class)
	public void salvarUsuarioComSenhaNull() throws Exception {

		Usuario usuario = new Usuario();
		usuario.setSenha(null);
//		Usuario salvo = service.salvarUsuario(usuario);
//		assertEquals(salvo, usuario);
	}

	@Test(expected = Exception.class)
	public void salvarUsuarioComEmailNull() throws Exception {

		Usuario usuario = new Usuario();
		usuario.setEmail(null);
//		Usuario salvo = service.salvarUsuario(usuario);
//		assertEquals(salvo, usuario);
	}

	@Test(expected = Exception.class)
	public void salvarUsuarioComSenhaMenorQSeis() throws Exception {

		Usuario usuario = new Usuario();
		usuario.setSenha("1234");
//		Usuario salvo = service.salvarUsuario(usuario);
//		assertEquals(salvo, usuario);
	}

}
