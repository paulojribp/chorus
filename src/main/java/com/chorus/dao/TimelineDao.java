package com.chorus.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.caelum.vraptor.ioc.Component;

import com.chorus.entity.Chorus;
import com.chorus.entity.Usuario;


@Component
public class TimelineDao {

	private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void add(Chorus chorus) {
		entityManager.persist(chorus);
	}
	
//	@SuppressWarnings("unchecked")
//	public List<Timeline> searchSimilarTitle(String mensagem) {
//		Session session = (Session) entityManager.getDelegate();
//		return session.createCriteria(Timeline.class).add(
//				Restrictions.ilike("mensagem", "%" + mensagem + "%")).list();
//	}
	
	@SuppressWarnings("unchecked")
	public List<Chorus> loadByUser(Usuario usuario) {
		String sql = "from Chorus where usuario = ?";
		Query q = entityManager.createQuery(sql);
		q.setParameter(0, usuario);
		
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Chorus> loadAll() {
		return entityManager.createQuery("from Chorus").getResultList();
	}
	
}
