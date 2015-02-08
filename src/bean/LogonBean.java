package bean;

import javax.faces.bean.ManagedBean;

import service.UsuarioService;

@ManagedBean
public class LogonBean extends EnttyManagerBean{

	private String email;
	private String senha;
	private String falhaLogin;
	
	public String autenticar(){
		UsuarioService usuarioService = new UsuarioService(getEntityManager());
		
		
		if (usuarioService.autenticar(email, senha))
			return "OK";
		
		falhaLogin = "Login inválido";
		return "login";
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

	public String getFalhaLogin() {
		return falhaLogin;
	}

	public void setFalhaLogin(String falhaLogin) {
		this.falhaLogin = falhaLogin;
	}
}
