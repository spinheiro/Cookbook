package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entity.Receita;

public class ReceitaService {
	private EntityManager entityManager;
	
	public ReceitaService(EntityManager entityManager){
		this.entityManager = entityManager;
	}
	
	public void postarReceita(Receita receita){
		entityManager.persist(receita);
	}

	@SuppressWarnings("unchecked")
	public List<Receita> findReceitasByUsuario(Integer usuarioId) {
		Query query = entityManager.createQuery("select r from Receita r where usuario_id = :usuarioId");
		query.setParameter("usuarioId", usuarioId);
		
		return query.getResultList();
	}
}
