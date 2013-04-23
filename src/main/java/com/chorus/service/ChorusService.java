package com.chorus.service;

import java.util.List;

import com.chorus.entity.Chorus;
import com.chorus.entity.Usuario;

public interface ChorusService {

	List<Chorus> loadAll();
	
	void chorar(Chorus chorus) throws Exception;
	
	List<Chorus> findByUsuario(Usuario usuario);
	
}
