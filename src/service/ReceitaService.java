package service;

import javax.persistence.EntityManager;

import entity.Receita;

public class ReceitaService {
	private EntityManager entityManager;
	
	public ReceitaService(EntityManager entityManager){
		this.entityManager = entityManager;
	}
	
	public void postarReceita(Receita receita){
		entityManager.persist(receita);
	}
}
