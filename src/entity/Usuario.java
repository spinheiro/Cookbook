package entity;

import java.util.Calendar;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nome", length=200, nullable = false)
	private String nome;
	
	@Column(name = "email", length = 200, nullable = false)
	private String email;
	
	@Column(name = "senha", length = 20, nullable = false)
	private String senha;
	
	@Column(name = "sexo", length = 1, nullable = false)
	private String sexo;
	
	@Column(name = "dataNascimento", nullable = false)
	private Calendar dataNascimento;

	public Usuario() {
		super();
	}

	public Usuario(Integer id, String nome, String email, String senha,	String sexo, Calendar dataNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
