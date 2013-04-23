package com.chorus.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.caelum.vraptor.ioc.Component;

import com.chorus.entity.Chorus;
import com.chorus.entity.Usuario;

@Component
public class ChorusDao extends GenericDao<Chorus> {

	public List<Chorus> findByUsuario(Usuario usuario) {
		String sql = "select chorus from Chorus chorus inner join chorus.usuario user where user.username = ?";
		Query q = entityManager.createQuery(sql);
		q.setParameter(1, usuario.getUsername());
		
		return q.getResultList();
	}
	
}
