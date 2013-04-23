package com.chorus.service;

import java.util.List;

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
public interface TimeLineService {

	/**
	 * @param user
	 * @param chorus
	 * @return
	 * @throws Exception 
	 */
	Chorus publicarNaTimeLine(Chorus chorus) throws Exception;

	/**
	 * @param usuario
	 * @throws Exception 
	 */
	List<Chorus> listar(Usuario usuario) throws Exception;
	
	/**
	 * 
	 * @return all chorus
	 */
	List<Chorus> loadAll();

}
