package bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class LogonBean {

	private String email;
	private String senha;
	
	public String autenticar(){
		return "";
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
