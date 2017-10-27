package br.com.straining.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
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
public class PerfilBean implements Serializable{

	@Inject
	private UsuarioDao usuarioDao;
	
	@Inject
	private RestricaoFisicaDao restricaoFisicaDao;
	
	@Inject
	private FacesContext context;

	private List<RestricaoFisica> restricoesFisicas = new ArrayList<RestricaoFisica>();
	
	private Usuario usuario = new Usuario();

	List<String> sexos = Arrays.asList("MASCULINO", "FEMININO");
	
	@PostConstruct
	public void init(){
		Usuario sessao = (Usuario) context.getExternalContext().getSessionMap().get("usuarioLogado");
		usuario = usuarioDao.buscaPorId(sessao.getId());
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
	public void atualizaUsuario() {
		System.out.println("Atualizou");
		usuarioDao.atualiza(this.usuario);
	}
	
	@Transacional
	public List<RestricaoFisica> listaRestricoesFisicas() {
		return restricaoFisicaDao.listaTodos();
	}
	
	public void adicionaRestricaoFisica(RestricaoFisica restricaoFisica) {
		listaRestricoesFisicas().add(restricaoFisica);
	}
	
}
