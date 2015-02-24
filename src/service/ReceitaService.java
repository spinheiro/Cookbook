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

	public List<Receita> findReceitasByUsuario(Long usuarioId) {
		Query query = entityManager.createQuery("select r from Receita r where usuario_id = :usuarioId");
		query.setParameter("usuarioId", usuarioId);
		
		return query.getResultList();
	}

	public List<Receita> findReceitasByTitulo(String titulo) {
		StringBuffer qry = new StringBuffer("select r from Receita r ");
		qry.append("left join r.usuario u ");
		if(titulo != null && !"".equals(titulo))
			qry.append("where upper(r.titulo) like '%" + titulo.toUpperCase() +"%' ");
		qry.append("order by r.id desc ");
		
		Query query = entityManager.createQuery(qry.toString());
		return query.getResultList();
	}

	public Receita findById(Long receitaId) {
		Query query = entityManager.createQuery("select r from Receita r where r.id = :receitaId");
		query.setParameter("receitaId", receitaId);

		return (Receita) query.getSingleResult();
	}
}
