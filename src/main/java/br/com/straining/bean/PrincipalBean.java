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
	
	private List<Treino> treinos = new ArrayList<Treino>();

	@PostConstruct
	public void init() {
		Usuario sessao = (Usuario) context.getExternalContext().getSessionMap().get("usuarioLogado");
		treinos = treinoDao.buscaTreinosPorIdUsuario(sessao.getId());
	}

	public List<Treino> getTreinos() {
		return treinos;
	}

	public void setTreinos(List<Treino> treinos) {
		this.treinos = treinos;
	}

	

}
