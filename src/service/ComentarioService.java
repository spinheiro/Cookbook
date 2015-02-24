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
		Query query = entityManager.createQuery("select c from Comentario c "
				+ "left join c.usuario u "
				+ "where c.receita.id = :receitaId "
				+ "order by c.id desc");
		query.setParameter("receitaId", receita.getId());
		
		return query.getResultList();
	}

	public Double getMediaNotaByReceitaId(Long receitaId) {
		Query query = entityManager.createQuery("select avg(c.nota) from Comentario c where c.receita.id = :receitaId ");
		query.setParameter("receitaId", receitaId);
		
		return (Double) query.getSingleResult();
	}
}
