package br.com.straining.util;

import java.util.ArrayList;
import java.util.List;

import br.com.straining.modelo.Exercicio;

public class ExerciciosGM {

	private List<Exercicio> exerciciosPeito = new ArrayList<Exercicio>();
	private List<Exercicio> exerciciosCostas = new ArrayList<Exercicio>();
	private List<Exercicio> exerciciosBiceps = new ArrayList<Exercicio>();
	private List<Exercicio> exerciciosTriceps = new ArrayList<Exercicio>();
	private List<Exercicio> exerciciosPernas = new ArrayList<Exercicio>();
	private List<Exercicio> exerciciosOmbros = new ArrayList<Exercicio>();
	private List<Exercicio> exerciciosAntebracos = new ArrayList<Exercicio>();
	private List<Exercicio> exerciciosAbdominais = new ArrayList<Exercicio>();
	private List<Exercicio> exerciciosGluteos = new ArrayList<Exercicio>();
	
	
	public ExerciciosGM() {
		
	}
	
	public List<Exercicio> getExerciciosPeito() {
		return exerciciosPeito;
	}

	public void setExerciciosPeito(List<Exercicio> exerciciosPeito) {
		this.exerciciosPeito = exerciciosPeito;
	}

	public List<Exercicio> getExerciciosCostas() {
		return exerciciosCostas;
	}

	public void setExerciciosCostas(List<Exercicio> exerciciosCostas) {
		this.exerciciosCostas = exerciciosCostas;
	}

	public List<Exercicio> getExerciciosBiceps() {
		return exerciciosBiceps;
	}

	public void setExerciciosBiceps(List<Exercicio> exerciciosBiceps) {
		this.exerciciosBiceps = exerciciosBiceps;
	}

	public List<Exercicio> getExerciciosTriceps() {
		return exerciciosTriceps;
	}

	public void setExerciciosTriceps(List<Exercicio> exerciciosTriceps) {
		this.exerciciosTriceps = exerciciosTriceps;
	}

	public List<Exercicio> getExerciciosPernas() {
		return exerciciosPernas;
	}

	public void setExerciciosPernas(List<Exercicio> exerciciosPernas) {
		this.exerciciosPernas = exerciciosPernas;
	}

	public List<Exercicio> getExerciciosOmbros() {
		return exerciciosOmbros;
	}

	public void setExerciciosOmbros(List<Exercicio> exerciciosOmbros) {
		this.exerciciosOmbros = exerciciosOmbros;
	}

	public List<Exercicio> getExerciciosAntebracos() {
		return exerciciosAntebracos;
	}

	public void setExerciciosAntebracos(List<Exercicio> exerciciosAntebracos) {
		this.exerciciosAntebracos = exerciciosAntebracos;
	}

	public List<Exercicio> getExerciciosAbdominais() {
		return exerciciosAbdominais;
	}

	public void setExerciciosAbdominais(List<Exercicio> exerciciosAbdominais) {
		this.exerciciosAbdominais = exerciciosAbdominais;
	}

	public List<Exercicio> getExerciciosGluteos() {
		return exerciciosGluteos;
	}

	public void setExerciciosGluteos(List<Exercicio> exerciciosGluteos) {
		this.exerciciosGluteos = exerciciosGluteos;
	}

}
