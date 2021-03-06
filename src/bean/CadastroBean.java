package bean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.bean.ManagedBean;

import service.UsuarioService;
import entity.Usuario;

@ManagedBean
public class CadastroBean extends EnttyManagerBean{
	private String nome;
	private String email;
	private String confirmacaoEmail;
	private String senha;
	private Integer dia;
	private Integer mes;
	private Integer ano;	
	private String sexo;
	private String msgConfirmacaoEmail;
	private String msg;
	
	public String cadastrar(){
		
		UsuarioService usuarioService = new UsuarioService(getEntityManager());
		
		if(!email.equals(confirmacaoEmail)){
			msgConfirmacaoEmail = "Confirmação de email não confere.";
			return "login";
		}
		
		if(!validarEmail(email)){
			msgConfirmacaoEmail = "Email iválido.";
			return "login";
		}
		
		Usuario usuario = new Usuario(null, nome, confirmacaoEmail, senha, sexo, populaDataNascimento());
		
		try {
			usuarioService.inserir(usuario);
			msg = "Cadastro realizado com sucesso.";
		} catch (Exception e) {
			msg = "Ocorreu um erro em seu cadastro.";
		}
		
		return "login";
	}
	
	private boolean validarEmail(String email) {
		if ((email == null) || (email.trim().length() == 0))
			return false;
	
		String emailPattern = "\\b(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b";
		Pattern pattern = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	private Calendar populaDataNascimento() {
		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.set(Calendar.DATE, dia);
		dataNascimento.set(Calendar.MONTH, mes);
		dataNascimento.set(Calendar.YEAR, ano);
		return dataNascimento;
	}
	
	public List<Integer> getDias(){
		   List<Integer> retorno = new ArrayList<Integer>();
		    for (int i = 1; i <= 31; i++) 
		    	retorno.add(i);
		return retorno;
	}
	
	public Map<String,Integer> getMeses(){
		Map<String,Integer> retorno = new LinkedHashMap();
		retorno.put("Janeiro",0);
		retorno.put("Fevereiro",1);
		retorno.put("Março",2);
		retorno.put("Abril",3);
		retorno.put("Maio",4);
		retorno.put("Junho",5);
		retorno.put("Julho",6);
		retorno.put("Agosto",7);
		retorno.put("Setembro",8);
		retorno.put("Outubro",9);
		retorno.put("Novembro",10);
		retorno.put("Dezembro",11);
		return retorno;
	}
	
	public List<Integer> getAnos(){
		   List<Integer> retorno = new ArrayList<Integer>();
		   int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
		    for (int i = anoAtual ; i >= 1910; i--) 
		    	retorno.add(i);
		return retorno;
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
	public String getConfirmacaoEmail() {
		return confirmacaoEmail;
	}
	public void setConfirmacaoEmail(String confirmacaoEmail) {
		this.confirmacaoEmail = confirmacaoEmail;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Integer getDia() {
		return dia;
	}
	public void setDia(Integer dia) {
		this.dia = dia;
	}
	public Integer getMes() {
		return mes;
	}
	public void setMes(Integer mes) {
		this.mes = mes;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getMsgConfirmacaoEmail() {
		return msgConfirmacaoEmail;
	}

	public void setMsgConfirmacaoEmail(String msgConfirmacaoEmail) {
		this.msgConfirmacaoEmail = msgConfirmacaoEmail;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}