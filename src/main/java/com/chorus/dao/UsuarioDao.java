package com.chorus.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.vraptor.ioc.Component;

import com.chorus.entity.Usuario;


@Component
public class UsuarioDao extends GenericDao<Usuario>{

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void add(Usuario usuario) {
		entityManager.persist(usuario);
	}

	
	public List<Usuario> findByUsuario(Usuario usuario) {
		String sql = "select username,login, email, senha from Usuario  where user.username = ?";
		Query q = entityManager.createQuery(sql);
		q.setParameter(1, usuario.getUsername());
		
		return q.getResultList();
	}


	
	
}
