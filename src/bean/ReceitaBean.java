package bean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;

import service.ReceitaService;
import entity.Receita;
import entity.Usuario;

@ManagedBean
public class ReceitaBean extends EnttyManagerBean {
	private String titulo;
	private String textoReceita;
	private String imagem;
	private String pesquisa;
	private Part arquivo;
	private Integer usuarioId;
	private String msg;
	private String msgPesquisa;
	private List<Receita> minhasReceitas;
	private List<Receita> receitasPesquisa;
	private String path;

	public String postar() throws IOException{
		try {
			ReceitaService receitaService = new ReceitaService(getEntityManager());
			
			if(arquivo != null) salvaImagem();
			
			Usuario usuario = new Usuario();
			usuario.setId(usuarioId);
			
			Receita receita = new Receita(titulo, textoReceita, imagem, usuario);
			receitaService.postarReceita(receita);
			
			msg = "Cadastro realizado com sucesso.";
			getMinhasReceitas();
	
		} catch (Exception e) {
			msg = "Ocorreu um erro no cadastro da receita.";
		}
			
		return "";
	}
	
	private void salvaImagem() throws IOException {
		imagem = new Date().getTime() + getNomeArquivo(arquivo);
		String path = getExternalContext().getRealPath("" + java.io.File.separatorChar);
		File outputFilePath = new File(path + java.io.File.separatorChar + "image"  + java.io.File.separatorChar + imagem);
		
		InputStream inputStream = null;
		OutputStream outputStream = null;
		try {
			inputStream = arquivo.getInputStream();
			outputStream = new FileOutputStream(outputFilePath);
		 
			int read = 0;
			final byte[] bytes = new byte[1024];
			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (outputStream != null) outputStream.close();
			if (inputStream != null) inputStream.close();
		}
	}
	
	private String getNomeArquivo(Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}
	
	public void validarArquivo(FacesContext ctx, UIComponent comp, Object value) {
		List<FacesMessage> msgs = new ArrayList<FacesMessage>();
		Part file = (Part)value;
		
		if (file.getSize() > 20000*1024) {
			msgs.add(new FacesMessage("Arquivo muito Grande."));
		}
		if (!"image/jpeg".equals(file.getContentType())) {
			msgs.add(new FacesMessage("Arqui tem que ter o formato JPG"));
		}
		if (!msgs.isEmpty()) {
			throw new ValidatorException(msgs);
		}
	}
	public String pesquisar(){
		ReceitaService receitaService = new ReceitaService(getEntityManager());
		receitasPesquisa = receitaService.findReceitasByTitulo(pesquisa);
		
		if(receitasPesquisa.size() == 0 )
			msgPesquisa = "Não existem dados para a pesquisa informada: " + pesquisa ;
		
		return "";
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

	public Part getArquivo() {
		return arquivo;
	}

	public void setArquivo(Part arquivo) {
		this.arquivo = arquivo;
	}

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<Receita> getMinhasReceitas() {
		ReceitaService receitaService = new ReceitaService(getEntityManager());
		path = "image" + java.io.File.separatorChar;
		minhasReceitas = receitaService.findReceitasByUsuario(usuarioId);
		return minhasReceitas;
	}

	public void setMinhasReceitas(List<Receita> minhasReceitas) {
		this.minhasReceitas = minhasReceitas;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public List<Receita> getReceitasPesquisa() {
		return receitasPesquisa;
	}

	public void setReceitasPesquisa(List<Receita> receitasPesquisa) {
		this.receitasPesquisa = receitasPesquisa;
	}

	public String getMsgPesquisa() {
		return msgPesquisa;
	}

	public void setMsgPesquisa(String msgPesquisa) {
		this.msgPesquisa = msgPesquisa;
	}
}