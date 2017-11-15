package br.com.straining.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.straining.dao.TreinoDao;
import br.com.straining.dao.UsuarioDao;
import br.com.straining.modelo.Treino;
import br.com.straining.modelo.Usuario;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class PrincipalBean implements Serializable {
	
	@Inject
	private FacesContext context;

	@Inject
	private TreinoDao treinoDao;
	
	@Inject
	private UsuarioDao usuarioDao;
	
	private Usuario usuario = new Usuario();
	
	private List<Treino> treinos = new ArrayList<Treino>();

	
	@PostConstruct
	public void init() {
		Usuario sessao = (Usuario) context.getExternalContext().getSessionMap().get("usuarioLogado");
		usuario = usuarioDao.buscaPorId(sessao.getId());
		
		treinos = usuario.getTreinos();
		System.out.println(treinos.size());
		
	}

	public List<Treino> getTreinos() {
		return treinos;
	}

	public void setTreinos(List<Treino> treinos) {
		this.treinos = treinos;
	}


}
