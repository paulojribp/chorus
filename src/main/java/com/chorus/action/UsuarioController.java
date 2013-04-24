package com.chorus.action;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

import com.chorus.entity.Usuario;
import com.chorus.service.UsuarioService;

@Resource
public class UsuarioController {

	private Result result;

	private UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService, Result result) {
		this.usuarioService = usuarioService;
		this.result = result;
	}

	public void salvar(Usuario usuario) throws Exception {
		usuarioService.salvarUsuario(usuario);
		//result.redirectTo(UsuarioController.class).listarAll();
	}


}
