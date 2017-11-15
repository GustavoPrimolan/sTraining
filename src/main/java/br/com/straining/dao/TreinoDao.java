package br.com.straining.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.straining.modelo.Treino;

@SuppressWarnings("serial")
public class TreinoDao implements Serializable{
	
	@Inject
	private EntityManager em;
	
	DAO<Treino> dao;
	
	
	@PostConstruct
	void init() {
		dao = new DAO<Treino>(this.em, Treino.class);
	}


	public List<Treino> buscaTreinosPorIdUsuario(Integer id) {
		
		String jpql = "select t from Treino t join t.usuario u where u = :pUsuarioId";
		
		Query query = em.createQuery(jpql);
		query.setParameter("pUsuarioId", id);
		
		List<Treino> treinos = query.getResultList();
		
		return treinos;
		
	}
	
	
	public void adiciona(Treino treino) {
		dao.adiciona(treino);
	}
	
	
	
	
	
	
	
}
