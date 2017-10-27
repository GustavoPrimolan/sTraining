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
public class CadastroBean implements Serializable{
	
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
	public String efetuarCadastro() {

		boolean existeEmail = usuarioDao.existeEmail(this.usuario);
		System.out.println("Existe email: " + existeEmail);
		if (existeEmail) {

			// O FLASH DURA 2 REQUISIÇÕES PARA QUE A MENSAGEM DO USUÁRIO NÃO ENCONTRADO NÃO
			// SUMA
			context.getExternalContext().getFlash().setKeepMessages(true);

			// ASSOCIA AO COMPONENTE MESSAGES
			context.addMessage(null, new FacesMessage("Email já cadastrado"));

			return "cadastro?faces-redirect=true";
		}

		usuarioDao.adiciona(usuario);

		return "login?faces-redirect=true";

	}
}
