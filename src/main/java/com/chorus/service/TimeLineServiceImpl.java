package com.chorus.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.com.caelum.vraptor.ioc.Component;

import com.chorus.entity.Chorus;
import com.chorus.entity.Usuario;

@Component
public class TimeLineServiceImpl implements TimeLineService {
	
	private static Map<Usuario, List<Chorus>> mapChorusByUser = new HashMap<Usuario, List<Chorus>>();
	
	public TimeLineServiceImpl() {
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
		
		List<Chorus> chorinhos = mapChorusByUser.get(usuario);
		if(chorinhos == null){
			chorinhos = new ArrayList<Chorus>();
		}
		

		chorinhos.add(chorus);
		mapChorusByUser.put(usuario, chorinhos);
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
		
		if(usuario == null){
			return listarAll();
		}
		
		validar(usuario);
		List<Chorus> chorinhos = mapChorusByUser.get(usuario);
		
		return chorinhos;
	}
	
	private List<Chorus> listarAll() {
		List<Chorus> all = new ArrayList<Chorus>();
		
		Set<Usuario> keySet = mapChorusByUser.keySet();
		for (Usuario usuario : keySet) {
			all.addAll(mapChorusByUser.get(usuario));
		}
		return all;
	}

}
