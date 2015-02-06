package bean;

import javax.faces.bean.ManagedBean;

import service.UsuarioService;

@ManagedBean
public class LogonBean extends EnttyManagerBean{

	private String email;
	private String senha;
	
	public String autenticar(){
		UsuarioService usuarioService = new UsuarioService(getEntityManager());
		
		if (usuarioService.autenticar(email, senha))
			return "OK";
		
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
