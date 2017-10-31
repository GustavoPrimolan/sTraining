package br.com.straining.bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.straining.dao.RestricaoFisicaDao;
import br.com.straining.dao.UsuarioDao;
import br.com.straining.modelo.RestricaoFisica;
import br.com.straining.modelo.Usuario;
import br.com.straining.tx.Transacional;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class PerfilBean implements Serializable {

	@Inject
	private UsuarioDao usuarioDao;

	@Inject
	private RestricaoFisicaDao restricaoFisicaDao;

	@Inject
	private FacesContext context;

	private Usuario usuario = new Usuario();

	private String dataNascimento;

	List<String> sexos = Arrays.asList("MASCULINO", "FEMININO");

	private Integer restricaoFisicaId;

	@PostConstruct
	public void init() {
		Usuario sessao = (Usuario) context.getExternalContext().getSessionMap().get("usuarioLogado");
		usuario = usuarioDao.buscaPorId(sessao.getId());
	}

	public Integer getRestricaoFisicaId() {
		return restricaoFisicaId;
	}

	public void setRestricaoFisicaId(Integer restricaoFisicaId) {
		this.restricaoFisicaId = restricaoFisicaId;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<String> getSexos() {
		return sexos;
	}

	public void setSexos(List<String> sexos) {
		this.sexos = sexos;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		System.out.println("Setou usuário");
		this.usuario = usuario;
	}

	@Transacional
	public void atualizaUsuario(ActionEvent actionEvent) {
		System.out.println(usuario.getDataNascimento());
		System.out.println("Atualizou");
		usuarioDao.atualiza(this.usuario);
		addMessage("Informações atualizadas com sucesso!!");
	}

	@Transacional
	public List<RestricaoFisica> getRestricoesFisicas() {
		return restricaoFisicaDao.listaTodos();
	}
	
	public void removeRestricaoFisica(RestricaoFisica restricaoFisica) {
		this.usuario.removeRestricaoFisica(restricaoFisica);
	}

	public List<RestricaoFisica> getRestricoesFisicasDoUsuario() {
		return this.usuario.getRestricoesFisicas();
	}
	
	@Transacional
	public void gravarRestricaoFisica() {
		
		RestricaoFisica restricaoFisica = this.restricaoFisicaDao.buscaPorId(this.restricaoFisicaId);
		for (RestricaoFisica restricaoLista : this.usuario.getRestricoesFisicas()) {
			if(restricaoFisica.getArticulacao().equals(restricaoLista.getArticulacao())) {
				addMessage("Restrição já inserida");
				return;
			}
		}
		this.usuario.adicionaRestricaoFisica(restricaoFisica);
	}
	
	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		context.addMessage(null, message);
	}

}
