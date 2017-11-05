package br.com.straining.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.straining.modelo.Exercicio;

@SuppressWarnings("serial")
public class PSR implements Serializable{

	public PSR() {
		
	}
	
	public List<Exercicio> embaralhaExercicios(List<Exercicio> exercicios){
		List<Exercicio> exerciciosEmbaralhados = new ArrayList<Exercicio>();
		
		while (!exercicios.isEmpty()) {
			int qtdExercicios = exercicios.size();
			double valorDouble = Math.random() * qtdExercicios;
			int posicaoAleatoriaDaLista = (int) valorDouble;
			
			System.out.println("Quantidade de Exercicios passados para o método: " + qtdExercicios);
			System.out.println("Posição Aleatória da Lista: " + posicaoAleatoriaDaLista);
			exerciciosEmbaralhados.add(exercicios.get(posicaoAleatoriaDaLista));
			exercicios.remove(posicaoAleatoriaDaLista);
		}
		
		
		return exerciciosEmbaralhados;
	}
	
	//ESSE ALGORTIMO SIMPLESMENTE MONTA O TREINO COM 4 EXERCÍCIOS DE CADA GRUPO MUSCULAR
	//FAZENDO APENAS A COMPARAÇÃO SE O EXERCÍCIO JÁ SE ENCONTRA NA LISTA
	public List<Exercicio> mntTreinoQuatroPorGM(List<List<Exercicio>> listasDosExercicios){
		
		List<Exercicio> treinoCompleto = new ArrayList<Exercicio>();
		
		for (List<Exercicio> listaExerciciosGM : listasDosExercicios) {
			int qtdGrupoMuscular = 0;
			for (Exercicio exercicio : listaExerciciosGM) {
				if (!treinoCompleto.contains(exercicio)) {
					treinoCompleto.add(exercicio);
					qtdGrupoMuscular++;
				}
				if (qtdGrupoMuscular > 3) {
					break;
				}
			}
		}
		
		return treinoCompleto;
	}
}
