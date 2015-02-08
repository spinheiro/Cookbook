package bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class ReceitaBean extends EnttyManagerBean {
	private String titulo;
	private String textoReceita;
	private String imagem;
	private String pesquisa;
	
	public String postar(){
		return "OK";
	}
	
	public String pesquisar(){
		return "home";
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getTextoReceita() {
		return textoReceita;
	}

	public void setTextoReceita(String textoReceita) {
		this.textoReceita = textoReceita;
	}

	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}
}
