package br.com.straining.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.straining.modelo.RestricaoFisica;

@SuppressWarnings("serial")
public class RestricaoFisicaDao implements Serializable{

	@Inject
	private EntityManager em;
	
	private DAO<RestricaoFisica> dao;
	
	@PostConstruct
	public void init() {
		dao = new DAO<RestricaoFisica>(this.em, RestricaoFisica.class);
	}
	
	
	public List<RestricaoFisica> listaTodos(){
		return dao.listaTodos();
	}
	
	public RestricaoFisica buscaPorId(Integer id) {
		return dao.buscaPorId(id);
	}
	
}
