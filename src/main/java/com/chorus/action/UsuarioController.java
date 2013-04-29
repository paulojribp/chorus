package com.chorus.action;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

import com.chorus.dto.ReturnDto;
import com.chorus.dto.UsuarioDto;
import com.chorus.service.UsuarioService;

@Resource
@Path("/usuario")
public class UsuarioController {

	private Result result;
	
	private UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService, Result result) {
		this.usuarioService = usuarioService;
		this.result = result;
	}

	@Post
	@Path("/salvar")
	public void salvar(UsuarioDto usuario) throws Exception {
		ReturnDto returndto = new ReturnDto();
		try {
			usuarioService.salvar(usuario);
			returndto.setSuccess(true);
		} catch (Exception e) {
			returndto.setSuccess(false);
			returndto.setMessage(e.getMessage());
		}
		
		result.use(Results.json()).from(returndto).serialize();
	}


}
