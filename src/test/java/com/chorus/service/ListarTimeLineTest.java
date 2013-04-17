/*
 * Copyright 2012 Sagarana Tech.  All rigths reserved.
 *
 * This software is the confidential and proprietary information of
 * Sagarana Tech ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with Sagarana Tech.
 */
package com.chorus.service;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

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
public class ListarTimeLineTest {
	
	private static TimeLineService	service;
	
	private static TimelineDao dao;

	@BeforeClass
	public static void beforeClass() {
		service = new TimeLineServiceImpl(dao);
	}
	
	@Test(expected=Exception.class)
	public void listarComUsuarioInvalido() throws Exception {
		Usuario usuario = new Usuario();
		service.listar(usuario);
	}

	@Test(expected=Exception.class)
	public void listarComUsuarioQueNaoTemChorus() throws Exception {
		Usuario usuario = new Usuario();
		usuario.setLogin("Chorao");
		List<Chorus> chorinhos = service.listar(usuario);
		assertEquals(0, chorinhos.size());
	}
	
	@Test
	public void listarChorusUsuarioQueTemCincoMensagens() throws Exception {
		Usuario usuario = new Usuario();
		usuario.setLogin("Chorao");
		int quant = 5;
		publicarMensagens(usuario, quant);
		List<Chorus> chorinhos = service.listar(usuario);
		assertNotNull(chorinhos);
		assertEquals(quant, chorinhos.size());
	}

	private void publicarMensagens(Usuario usuario, int quant) throws Exception {
		int i = 0;
		while (i < quant){
			Chorus chorus = new Chorus();
			chorus.setUsuario(usuario);
			chorus.setMensagem("Mensagem do "+ usuario.getLogin() + " "+ quant);
			service.publicarNaTimeLine(chorus);
			i++;
		}
	}
	
}
