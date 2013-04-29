package com.chorus.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.caelum.vraptor.ioc.Component;

import com.chorus.entity.Chorus;
import com.chorus.entity.Usuario;

@Component
public class ChorusDao extends GenericDao<Chorus> {

	public List<Chorus> findByUsuario(Usuario usuario) {
		String sql = "select c from Chorus c inner join fetch c.usuario where c.usuario.login = ?";
		Query q = entityManager.createQuery(sql);
		q.setParameter(1, usuario.getLogin());
		
		return q.getResultList();
	}
	
	public List<Chorus> loadAll() {
		return entityManager.createQuery("from Chorus").getResultList();
	}
	
}
