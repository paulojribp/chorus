package com.chorus.action;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

import com.chorus.entity.Chorus;
import com.chorus.entity.Usuario;
import com.chorus.service.ChorusService;

@Resource
public class TimelineController {

	private Result result;

	private ChorusService chorusService;

	public TimelineController(ChorusService chorusService, Result result) {
		this.chorusService = chorusService;
		this.result = result;
	}

	public void publicar(Chorus chorus) throws Exception {
		chorusService.chorar(chorus);
		result.redirectTo(TimelineController.class).listarAll();
	}

	@Path("/listar/{usuario.username}")
	public void listar(Usuario usuario) throws Exception {
		result.include("chorinhos", chorusService.findByUsuario(usuario));
	}

	public void listarAll() throws Exception {
		result.include("chorinhos", chorusService.loadAll());
	}
}
