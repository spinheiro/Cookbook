package bean;

import java.util.Map;

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
	
	protected String getParam(String paramName) {
		Map<String, String> params =FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		return params.get(paramName);
	}
	
	protected ExternalContext getExternalContext() {
		return externalContext;
	}
}
