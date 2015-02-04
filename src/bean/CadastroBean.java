package bean;

import java.util.Calendar;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
public class CadastroBean {
	private String nome;
	private String email;
	private String confirmaEmail;
	private Calendar dataNascimento;
	private String sexo;
	
	public String cadastrar(){
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
		EntityManager entityManager = (EntityManager) request.getAttribute("entityManager");
		
		if(entityManager != null)
			entityManager.persist(null);
		
		return "home";
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getConfirmaEmail() {
		return confirmaEmail;
	}
	public void setConfirmaEmail(String confirmaEmail) {
		this.confirmaEmail = confirmaEmail;
	}
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
}
