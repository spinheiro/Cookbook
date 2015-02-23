package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entity.Receita;

@SuppressWarnings("unchecked")
public class ReceitaService {
	private EntityManager entityManager;
	
	public ReceitaService(EntityManager entityManager){
		this.entityManager = entityManager;
	}
	
	public void postarReceita(Receita receita){
		entityManager.persist(receita);
	}

	public List<Receita> findReceitasByUsuario(Integer usuarioId) {
		Query query = entityManager.createQuery("select r from Receita r where usuario_id = :usuarioId");
		query.setParameter("usuarioId", usuarioId);
		
		return query.getResultList();
	}

	public List<Receita> findReceitasByTitulo(String titulo) {
		Query query = entityManager.createQuery("select r from Receita r where upper(r.titulo) like '%" + titulo.toUpperCase() +"%'");
		
		return query.getResultList();
	}

	public Receita findReceitas(Receita receita) {
		Query query = entityManager.createQuery("select r from Receita r where r.id = :receitaId");
		query.setParameter("receitaId", receita.getId());

		return (Receita) query.getSingleResult();
	}
}
