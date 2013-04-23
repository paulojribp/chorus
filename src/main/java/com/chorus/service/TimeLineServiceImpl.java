package com.chorus.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import br.com.caelum.vraptor.ioc.Component;

import com.chorus.dao.TimelineDao;
import com.chorus.entity.Chorus;
import com.chorus.entity.Usuario;

@Component
public class TimeLineServiceImpl implements TimeLineService {
	
	private TimelineDao dao;
	
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
	
	private List<Chorus> listarAll() {
		List<Chorus> all = new ArrayList<Chorus>();
		
		Set<Usuario> keySet = null; //mapChorusByUser.keySet();
		for (Usuario usuario : keySet) {
			all.addAll(null); //mapChorusByUser.get(usuario));
		}
		return all;
	}


	@Override
	public List<Chorus> loadAll() {
		return dao.loadAll();
	}

}
