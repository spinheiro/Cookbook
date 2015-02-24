package service;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entity.Usuario;

public class UsuarioService {
	
	private EntityManager entityManager;
	
	public UsuarioService(EntityManager entityManager){
		this.entityManager = entityManager;
	}
	
	public boolean autenticar(String login,String senha){
		Query query = entityManager.createQuery("select u from Usuario u where email = :login and senha = :senha");
		query.setParameter("login", login);
		query.setParameter("senha", senha);
		
		return query.getResultList().size()>0;
	}
	
	public void inserir(Usuario usuario){
		entityManager.persist(usuario);
	}
	
	public Usuario findUsuarioByLoginSenha(String login,String senha)
	{
		Query query = entityManager.createQuery("select u from Usuario u where email = :login and senha = :senha");
		query.setParameter("login", login);
		query.setParameter("senha", senha);
		
		return (Usuario) query.getSingleResult();
	}

	public Usuario findById(Long usuarioId) {
		Query query = entityManager.createQuery("select u from Usuario u where u.id = :usuarioId");
		query.setParameter("usuarioId", usuarioId);
		
		return (Usuario) query.getSingleResult();
	}
}
