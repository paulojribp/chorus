/*
 * Copyright 2012 Sagarana Tech.  All rigths reserved.
 *
 * This software is the confidential and proprietary information of
 * Sagarana Tech ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with Sagarana Tech.
 */
package com.chorus.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.ioc.Component;


import com.chorus.dao.TimelineDao;
import com.chorus.entity.Chorus;
import com.chorus.entity.Usuario;

/**
 * 
 * @author kete@sagaranatech.com
 * @since Apr 15, 2013
 * @version $Revision:  $ <br>
 *          $Date:  $ <br> 
 *          $Author:  $
 */
@Component
public class TimeLineServiceImpl implements TimeLineService {
	
	private TimelineDao dao;

	private static Map<Usuario, List<Chorus>> mapChorusByUser = new HashMap<Usuario, List<Chorus>>();
	public TimeLineServiceImpl(TimelineDao dao) {
		this.dao = dao;
	}

	
	/* (non-Javadoc)
	 * @see com.chorus.service.TimeLineService#publicarNaTimeLine(com.chorus.entity.Chorus)
	 */
	@Override
	public Chorus publicarNaTimeLine(Chorus chorus) throws Exception {
		
		Usuario usuario = chorus.getUsuario();
		
		validar(usuario);
		
		String mensagem = chorus.getMensagem();
		
/*		if(mensagem == null || mensagem.isEmpty()){
			throw new Exception("Mensagem nao pode ser vazia.");
		}

		if(mensagem.length() > 144){
			throw new Exception("Mensagem nao pode exceder 144 caracteres.");
		}*/
		
/*		List<Chorus> chorinhos = mapChorusByUser.get(usuario);
		if(chorinhos == null){
			chorinhos = new ArrayList<Chorus>();
		}
		

		chorinhos.add(chorus);
		mapChorusByUser.put(usuario, chorinhos);*/
		this.dao.add(chorus);
		return chorus;
	}


	private void validar(Usuario usuario) throws Exception {
		if(usuario == null || !usuario.isValido()){
			throw new Exception("Usuario nao encontrado.");
		}
	}


	/* (non-Javadoc)
	 * @see com.chorus.service.TimeLineService#listar(com.chorus.entity.Usuario)
	 */
	@Override
	public List<Chorus> listar(Usuario usuario) throws Exception {
//		validar(usuario);
		Chorus chorus = new Chorus();
		chorus.setMensagem("Saindo da aula de XP");
		usuario = new Usuario("Chorao");
		chorus.setUsuario(usuario);
		publicarNaTimeLine(chorus);
		
		List<Chorus> chorinhos = mapChorusByUser.get(usuario);
		return chorinhos;
	}

}
