package br.com.straining.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.straining.modelo.Exercicio;

@SuppressWarnings("serial")
public class ExercicioDao implements Serializable{

	@Inject
	EntityManager em;
	private DAO<Exercicio> dao;
	
	@PostConstruct
	void init(){
		this.dao = new DAO<Exercicio>(this.em, Exercicio.class);
	}
	
	
	
	public List<Exercicio> listaTodos() {
		
		return this.dao.listaTodos();
	}

	public void remove(Exercicio Exercicio) {
		
		this.dao.remove(Exercicio);
	}

	public void atualiza(Exercicio Exercicio) {
		this.dao.atualiza(Exercicio);
	}

	public void adiciona(Exercicio Exercicio) {
		
		this.dao.adiciona(Exercicio);
	}

	public Exercicio buscaPorId(Integer autorId) {
		
		return this.dao.buscaPorId(autorId);
	}



	public int quantidadeDeElementos() {

		return this.dao.quantidadeDeElementos();
	}



	public List<Exercicio> listaTodosPaginada(int inicio, int quantidade, String string, String titulo) {

		return this.dao.listaTodosPaginada(inicio, quantidade, string, titulo);
	}
	
	
	//LISTA TODOS PELO OBJETO E NÃO PELO CAMPO
	public List<Exercicio> listaTodosPaginada(int inicio, int quantidade, Exercicio exercicio) {
		
		String jpql = "select e from Exercicio e where e.nome like :pNome or e.grupoMuscular like :pGrupoMuscular or e.execucao like :pExecucao";
		
		
		Query query = em.createQuery(jpql);
		query.setParameter("pNome", exercicio.getNome()+"%");
		query.setParameter("pGrupoMuscular", exercicio.getGrupoMuscular());
		query.setParameter("pExecucao", exercicio.getExecucao());
		
		List<Exercicio> listaExercicios = query.setFirstResult(inicio).setMaxResults(quantidade).getResultList();
		
		return listaExercicios;
	}
	
	
	
}
