package com.chorus.service;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.ioc.Component;

import com.chorus.dao.ChorusDao;
import com.chorus.dao.TimelineDao;
import com.chorus.entity.Chorus;
import com.chorus.entity.Usuario;

@Component
public class TimeLineServiceImpl implements TimeLineService {
	
	private TimelineDao dao;
	private ChorusDao chorusDao;
	
	public TimeLineServiceImpl(TimelineDao dao, ChorusDao chorusDao) {
		this.dao = dao;
		this.chorusDao = chorusDao;
	}

	
	/* (non-Javadoc)
	 * @see com.chorus.service.TimeLineService#publicarNaTimeLine(com.chorus.entity.Chorus)
	 */
	@Override
	public Chorus publicarNaTimeLine(Chorus chorus) throws Exception {
		
		Usuario usuario = chorus.getUsuario();
		
		validar(usuario);
		
		String mensagem = chorus.getMensagem();
		
		if(mensagem == null || mensagem.isEmpty()){
			throw new Exception("Mensagem nao pode ser vazia.");
		}

		if(mensagem.length() > 144){
			throw new Exception("Mensagem nao pode exceder 144 caracteres.");
		}
		
		List<Chorus> chorinhos = null; //mapChorusByUser.get(usuario);
		if(chorinhos == null){
			chorinhos = new ArrayList<Chorus>();
		}
		

		chorinhos.add(chorus);
		this.dao.add(chorus);
		//mapChorusByUser.put(usuario, chorinhos);
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
		return dao.loadByUser(usuario);
	}


	@Override
	public List<Chorus> loadAll() {
		return chorusDao.loadAll();
	}

}
