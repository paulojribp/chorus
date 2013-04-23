package com.chorus.service;

import java.util.List;

import br.com.caelum.vraptor.ioc.Component;

import com.chorus.dao.ChorusDao;
import com.chorus.entity.Chorus;
import com.chorus.entity.Usuario;

@Component
public class ChorusServiceImpl implements ChorusService {

	private ChorusDao dao;
	
	public ChorusServiceImpl(ChorusDao chorusDao) {
		this.dao = chorusDao;
	}
	
	@Override
	public List<Chorus> loadAll() {
		return dao.loadAll();
	}

	@Override
	public void chorar(Chorus chorus) throws Exception {
		
		//TODO VALIDAR O QUE??
		//Usuario usuario = chorus.getUsuario();
		//validar(usuario);
		
		String mensagem = chorus.getMensagem();
		
		if(mensagem == null || mensagem.trim().isEmpty()){
			throw new Exception("Mensagem nao pode ser vazia.");
		}

		if(mensagem != null && mensagem.trim().length() > 144){
			throw new Exception("Mensagem nao pode exceder 144 caracteres.");
		}
		
		dao.create(chorus);
	}

	@Override
	public List<Chorus> findByUsuario(Usuario usuario) {
		return dao.findByUsuario(usuario);
	}

}
