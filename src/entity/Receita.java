package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "receita")
public class Receita {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "titulo", length=200, nullable = false)
	private String titulo;
	
	@Lob
	@Column(name = "textoReceita", nullable = false)
	private String textoReceita;
	
	@Lob
	@Column(name = "imagem")
	private String imagem;

	@ManyToOne
	private Usuario usuario;

	public Receita(){
	}
	
	public Receita(String titulo, String textoReceita, String imagem, Usuario usuario) {
		super();
		this.titulo = titulo;
		this.textoReceita = textoReceita;
		this.imagem = imagem;
		this.usuario = usuario;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
