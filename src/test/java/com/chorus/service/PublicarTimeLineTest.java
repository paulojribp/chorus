/*
 * Copyright 2012 Sagarana Tech.  All rigths reserved.
 *
 * This software is the confidential and proprietary information of
 * Sagarana Tech ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with Sagarana Tech.
 */

package com.chorus.service;

import static junit.framework.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.chorus.entity.Chorus;
import com.chorus.entity.Usuario;

/**
 * 
 * @author kete@sagaranatech.com
 * @since Apr 15, 2013
 * @version $Revision: $ <br>
 *          $Date: $ <br>
 *          $Author: $
 */
@Ignore
public class PublicarTimeLineTest {

	private static TimeLineService	service;

	@BeforeClass
	public static void beforeClass() {
		
//		service = new TimeLineServiceImpl();
	}

	
	@Test(expected = Exception.class)
	public void publicarNaTimeLineComUsuarioNull() throws Exception {
		Chorus chorus = new Chorus();
		Usuario usuario = new Usuario();
		chorus.setUsuario(usuario);
		Chorus publicado = service.publicarNaTimeLine(chorus);
		assertEquals(publicado, chorus);
	}
	
	@Test
	public void publicarNaTimeLineComUsuarioValido() throws Exception {
		Chorus chorus = new Chorus();
		Usuario usuario = new Usuario();
		usuario.setUsername("Chorao");
		chorus.setUsuario(usuario);
		chorus.setMensagem("In above example, the divisionWithException() method will throw an ArithmeticException Exception, since this is an expected exception.");
		Chorus publicado = service.publicarNaTimeLine(chorus);
		assertEquals(publicado, chorus);
	}

	@Test(expected = Exception.class)
	public void publicarNaTimeLineComMensagemVazia() throws Exception {
		Chorus chorus = new Chorus();
		Usuario usuario = new Usuario();
		usuario.setUsername("Chorao");
		chorus.setUsuario(usuario);
		Chorus publicado = service.publicarNaTimeLine(chorus);
		assertEquals(publicado, chorus);
	}

	@Test(expected = Exception.class)
	public void publicarNaTimeLineComMensagemMaiorQue144() throws Exception {
		Chorus chorus = new Chorus();
		Usuario usuario = new Usuario();
		usuario.setUsername("Chorao");
		chorus.setUsuario(usuario);
		chorus.setMensagem("In above example, the divisionWithException() method will throw an ArithmeticException Exception, since this is an expected exception, so the unit test will pass.");
		Chorus publicado = service.publicarNaTimeLine(chorus);
		assertEquals(publicado, chorus);
	}
	
	
	
}
