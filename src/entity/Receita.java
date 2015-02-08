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
	private Integer id;
	
	@Column(name = "titulo", length=200, nullable = false)
	private String titulo;
	
	@Lob
	@Column(name = "taxtoReceita", nullable = false)
	private String taxtoReceita;
	
	@Lob
	@Column(name = "imagem")
	private String imagem;

	@ManyToOne
	private Usuario usuario;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTaxtoReceita() {
		return taxtoReceita;
	}

	public void setTaxtoReceita(String taxtoReceita) {
		this.taxtoReceita = taxtoReceita;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
}
