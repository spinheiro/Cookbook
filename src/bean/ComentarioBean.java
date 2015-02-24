package bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import service.ComentarioService;
import service.ReceitaService;
import service.UsuarioService;
import entity.Comentario;
import entity.Receita;
import entity.Usuario;

@ManagedBean
public class ComentarioBean extends EnttyManagerBean{

	private Usuario usuario;
	private Receita receita;
	private String textoComentario;
	private Double nota;
	private Long receitaId;
	private Long usuarioId;
	
	public String postar(){
		UsuarioService usuarioService = new UsuarioService(getEntityManager());
		usuario = usuarioService.findById(usuarioId);
		
		ReceitaService receitaService = new ReceitaService(getEntityManager());
		receita = receitaService.findById(receitaId);

		ComentarioService comentarioService = new ComentarioService(getEntityManager());
		Comentario comentario = new Comentario(receita, usuario, nota, textoComentario);
		comentarioService.postarComentario(comentario);
		
		getComentariosReceita();
		textoComentario = "";
		nota = 0.0;
		
		return "";
	}
	public List<Comentario> getComentariosReceita(){
		List<Comentario> comentarios = new ArrayList<Comentario>();
		if(receitaId != null){
			ComentarioService comentarioService = new ComentarioService(getEntityManager());
			ReceitaService receitaService = new ReceitaService(getEntityManager());
			receita = receitaService.findById(receitaId);
			comentarios = comentarioService.obterComentario(receita);
		}
		
		return comentarios;
	}
	public List<Integer> getNotas(){
	   List<Integer> retorno = new ArrayList<Integer>();
	   for (int i = 0 ; i <= 10; i++) 
	    	retorno.add(i);
		return retorno;
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
	public Long getReceitaId() {
		return receitaId;
	}
	public void setReceitaId(Long receitaId) {
		this.receitaId = receitaId;
	}
	public Long getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}
}