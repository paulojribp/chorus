package com.chorus.action;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

import com.chorus.entity.Chorus;
import com.chorus.entity.Usuario;
import com.chorus.service.ChorusService;

@Resource
@Path("/timeline")
public class TimelineController {

	private Result result;

	private ChorusService chorusService;

	public TimelineController(ChorusService chorusService, Result result) {
		this.chorusService = chorusService;
		this.result = result;
	}

	public void publicar(Chorus chorus) throws Exception {
		chorusService.chorar(chorus);
		result.redirectTo(TimelineController.class).listar();
	}


	@Path("/listar/{usuario.login}")
	@Get
	public void listar(Usuario usuario) throws Exception {
		result.include("chorinhos", chorusService.findByUsuario(usuario));
		result.redirectTo("listar");
	}

	public void listar() throws Exception {
		result.include("chorinhos", chorusService.loadAll());
	}
}
