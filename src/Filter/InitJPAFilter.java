package Filter;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(servletNames = {"Faces Servlet"})
public class InitJPAFilter implements Filter{

	private EntityManagerFactory factory;
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		this.factory = Persistence.createEntityManagerFactory("Cookbook");
	}

	@Override
	public void destroy() {
		this.factory.close();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
		EntityManager entityManager = this.factory.createEntityManager();
		request.setAttribute("entityManager", entityManager);
		entityManager.getTransaction().begin();
		chain.doFilter(request, response);
		
		try {
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}finally{
			entityManager.close();
		}
	}
}