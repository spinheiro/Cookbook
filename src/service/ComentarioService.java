package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entity.Comentario;
import entity.Receita;

public class ComentarioService {
	
	private EntityManager entityManager;
	
	public ComentarioService(EntityManager entityManager){
		this.entityManager = entityManager;
	}
	
	public void postarComentario(Comentario comentario){
		entityManager.persist(comentario);
	}
	
	@SuppressWarnings("unchecked")
	public List<Comentario> obterComentario(Receita receita){
		Query query = entityManager.createQuery("select c from Comentario c where c.receita.id = :receitaId");
		query.setParameter("receitaId", receita.getId());
		
		return query.getResultList();
	}
}
