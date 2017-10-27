package br.com.straining.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.straining.dao.UsuarioDao;
import br.com.straining.modelo.Usuario;
import br.com.straining.tx.Transacional;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class LoginBean implements Serializable{
	
	@Inject
	private UsuarioDao usuarioDao;

	@Inject
	private FacesContext context;
	
	private Usuario usuario = new Usuario();
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@Transacional
	public String efetuarLogin() {
		System.out.println("Fazendo login do usuario: " + this.usuario.getEmail());

		this.usuario = usuarioDao.existe(this.usuario);
		// FAZER A AUTENTICA��O PARA VERIFICAR SE O USU�RIO PODE ACESSAR AS OUTRAS
		// P�GINAS
		if (this.usuario != null) {

			// COLOCA OS DADOS DO USU�RIO NA SESSION
			context.getExternalContext().getSessionMap().put("usuarioLogado", this.usuario);
			System.out.println("Nome do usu�rio: " + this.usuario.getNome());

			return "principal?faces-redirect=true";
		}

		// O FLASH DURA 2 REQUISI��ES PARA QUE A MENSAGEM DO USU�RIO N�O ENCONTRADO N�O
		// SUMA
		context.getExternalContext().getFlash().setKeepMessages(true);
		// ASSOCIA AO COMPONENTE MESSAGES
		context.addMessage(null, new FacesMessage("Usu�rio n�o encontrado"));
		return "login?faces-redirect=true";
	}

	public String deslogar() {

		context.getExternalContext().getSessionMap().remove("usuarioLogado");
		return "login?faces-redirect=true";
	}

}
