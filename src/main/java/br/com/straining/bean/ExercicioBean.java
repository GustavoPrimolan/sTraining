package br.com.straining.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.straining.dao.ExercicioDao;
import br.com.straining.enums.Execucao;
import br.com.straining.enums.GrupoMuscular;
import br.com.straining.enums.Nivel;
import br.com.straining.modelo.Exercicio;
import br.com.straining.modelo.ExercicioDataModel;
import br.com.straining.tx.Log;
import br.com.straining.tx.Transacional;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class ExercicioBean implements Serializable {

	@Inject
	ExercicioDao exercicioDao;

	@Inject
	ExercicioDataModel exercicioDataModel;

	private Exercicio exercicio = new Exercicio();

	private List<String> gruposMusculares = new ArrayList<String>();

	private List<String> niveisAntagonistas = new ArrayList<String>();

	private List<String> execucoes = new ArrayList<String>();

	@PostConstruct
	public void init() {
		for (int i = 0; i < GrupoMuscular.values().length; i++) {
			gruposMusculares.add(GrupoMuscular.values()[i].toString());
		}
		
		for (int i = 0; i < Nivel.values().length; i++) {
			niveisAntagonistas.add(Nivel.values()[i].toString());
		}
		
		for (int i = 0; i < Execucao.values().length; i++) {
			execucoes.add(Execucao.values()[i].toString());
		}
		
	}

	public List<String> getExecucoes() {
		return execucoes;
	}

	public void setExecucoes(List<String> execucoes) {
		this.execucoes = execucoes;
	}

	public List<String> getGruposMusculares() {
		return gruposMusculares;
	}

	public void setGruposMusculares(List<String> gruposMusculares) {
		this.gruposMusculares = gruposMusculares;
	}

	public List<String> getNiveisAntagonistas() {
		return niveisAntagonistas;
	}

	public void setNiveisAntagonistas(List<String> niveisAntagonistas) {
		this.niveisAntagonistas = niveisAntagonistas;
	}

	public Exercicio getExercicio() {
		return exercicio;
	}

	public void setExercicio(Exercicio exercicio) {
		this.exercicio = exercicio;
	}

	public ExercicioDataModel getExercicioDataModel() {
		return exercicioDataModel;
	}

	public void setExercicioDataModel(ExercicioDataModel exercicioDataModel) {
		this.exercicioDataModel = exercicioDataModel;
	}

	@Log
	@Transacional
	public List<Exercicio> getExercicios() {

		return this.exercicioDao.listaTodos();
	}

	@Transacional
	public void gravar() {
		System.out.println("Gravando exercicio: " + this.exercicio.getNome());

		if (exercicio.getId() == null) {
			this.exercicioDao.adiciona(this.exercicio);
		} else {
			this.exercicioDao.atualiza(this.exercicio);
		}

		this.exercicio = new Exercicio();

	}

	@Transacional
	public void remove(Exercicio exericio) {
		System.out.println("Removendo exercicio");

		this.exercicioDao.remove(exercicio);
	}

	public void carregar(Exercicio exercicio) {
		System.out.println("Carregando exercicio");

		this.exercicio = exercicio;
	}

}
