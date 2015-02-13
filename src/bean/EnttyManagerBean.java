package bean;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

public class EnttyManagerBean {
	
	private ExternalContext externalContext;

	protected EntityManager getEntityManager() 
	{
		FacesContext facesContext = FacesContext.getCurrentInstance();
		externalContext = facesContext.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
		EntityManager entityManager = (EntityManager) request.getAttribute("entityManager");
		return entityManager;
	}
	
	public ExternalContext getExternalContext() {
		return externalContext;
	}
}
