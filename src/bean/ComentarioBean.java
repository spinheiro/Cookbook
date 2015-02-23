package bean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import service.ComentarioService;
import service.ReceitaService;
import entity.Comentario;
import entity.Receita;
import entity.Usuario;

@ManagedBean
public class ComentarioBean extends EnttyManagerBean{

	private Usuario usuario;
	private Receita receita;
	private String textoComentario;
	private Double nota;
	private Integer receitaId;
	
	public String postar(){
		ComentarioService comentarioService = new ComentarioService(getEntityManager());
		Comentario comentario = new Comentario(receita, usuario, nota, textoComentario);
		comentarioService.postarComentario(comentario);
		
		return "";
	}
	
	public List<Comentario> getComentariosReceita(){
		ComentarioService comentarioService = new ComentarioService(getEntityManager());
		ReceitaService receitaService = new ReceitaService(getEntityManager());
		
		receita = new Receita();
		receita.setId(1);
		receita = receitaService.findReceitas(receita);
		
		List<Comentario> comentarios = comentarioService.obterComentario(receita);
		
		return comentarios;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Receita getReceita() {
		return receita;
	}
	public void setReceita(Receita receita) {
		this.receita = receita;
	}
	public String getTextoComentario() {
		return textoComentario;
	}
	public void setTextoComentario(String textoComentario) {
		this.textoComentario = textoComentario;
	}
	public Double getNota() {
		return nota;
	}
	public void setNota(Double nota) {
		this.nota = nota;
	}

	public Integer getReceitaId() {
		return receitaId;
	}

	public void setReceitaId(Integer receitaId) {
		this.receitaId = receitaId;
	}
}