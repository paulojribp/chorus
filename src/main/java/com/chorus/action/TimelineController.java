package com.chorus.action;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

import com.chorus.entity.Chorus;
import com.chorus.entity.Usuario;
import com.chorus.service.TimeLineService;

@Resource
public class TimelineController {

	private Result			result;

	private TimeLineService	service;

	/**
 * 
 */
	public TimelineController(TimeLineService	service, Result result) {
		this.service = service;
		this.result = result;
	}

	public void publicar(Chorus chorus) throws Exception {
		result.include(service.publicarNaTimeLine(chorus));
		result.redirectTo(TimelineController.class).listarAll();
	}

	@Path("/listar/{usuario.login}")
	public void listar(Usuario usuario) throws Exception {
		result.include("chorinhos", service.listar(usuario));
	}

	public void listarAll() throws Exception {
		result.include("chorinhos", service.listar(null));
	}
}
