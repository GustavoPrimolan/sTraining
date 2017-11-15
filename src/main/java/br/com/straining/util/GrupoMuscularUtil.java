package br.com.straining.util;

import java.util.ArrayList;
import java.util.List;

import br.com.straining.modelo.Exercicio;

public class GrupoMuscularUtil {
	private String nome;
	
	private List<Exercicio> exercicios = new ArrayList<Exercicio>();
	
	public GrupoMuscularUtil() {
		
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Exercicio> getExercicios() {
		return exercicios;
	}
	public void setExercicios(List<Exercicio> exercicios) {
		this.exercicios = exercicios;
	}
	
	
}
