package com.chorus.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class GenericDao<Model> {

	protected EntityManager entityManager;
	
	private Class<Model> entityClass;
	
	public GenericDao() {
		entityClass = getEntityClassByGenericAttribute();
	}
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void create(Model model) {
		entityManager.persist(model);
	}
	
	public void update(Model model) {
		entityManager.merge(model);
	}
	
	@SuppressWarnings("unchecked")
	public List<Model> loadAll() {
		return entityManager.createQuery("from " + entityClass.getSimpleName()).getResultList();
	}
	
	public Class<Model> getEntityClass() {
		return entityClass;
	}
	
	@SuppressWarnings("unchecked")
	private Class<Model> getEntityClassByGenericAttribute() {
		return (Class<Model>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
}
