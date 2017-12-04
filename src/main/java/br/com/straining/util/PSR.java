package br.com.straining.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.straining.enums.Articulacao;
import br.com.straining.enums.Sexo;
import br.com.straining.modelo.Exercicio;
import br.com.straining.modelo.RestricaoFisica;
import br.com.straining.modelo.Usuario;

@SuppressWarnings("serial")
public class PSR implements Serializable {

	public PSR() {

	}

	public List<Exercicio> embaralhaExercicios(List<Exercicio> exercicios) {
		List<Exercicio> exerciciosEmbaralhados = new ArrayList<Exercicio>();

		while (!exercicios.isEmpty()) {
			int qtdExercicios = exercicios.size();
			double valorDouble = Math.random() * qtdExercicios;
			int posicaoAleatoriaDaLista = (int) valorDouble;

			exerciciosEmbaralhados.add(exercicios.get(posicaoAleatoriaDaLista));
			exercicios.remove(posicaoAleatoriaDaLista);
		}

		return exerciciosEmbaralhados;
	}

	public ExerciciosGM montaTreino(ExerciciosGM exerciciosGM, Usuario usuario) throws Exception {
		ExerciciosGM exerciciosGMRetorno = new ExerciciosGM();

		double altura = usuario.getAltura().floatValue();
		double peso = usuario.getPeso().floatValue();

		double imc = peso / Math.pow(altura, 2);

		int quantidadeSubtrair = 0;

		// SE HOMEM, IMC TERÁ OUTROS VALORES PARA CONDIÇÃO
		if (usuario.getSexo().equals(Sexo.MASCULINO)) {
			System.out.println("IMC: " + imc);
			// ABAIXO DO PESO OU MARGINALMENTE ACIMA DO PESO
			if (imc < 20.7 || imc >= 26.4 && imc < 27.8) {
				quantidadeSubtrair = 1;

				// ACIMA DO PESO IDEAL
			} else if (imc >= 27.8) {
				quantidadeSubtrair = 2;

			}

			exerciciosGMRetorno.setExerciciosPeito(
					adcExerciciosNaoRepetidos(exerciciosGM.getExerciciosPeito(), 5 - quantidadeSubtrair));
			exerciciosGMRetorno.setExerciciosCostas(
					adcExerciciosNaoRepetidos(exerciciosGM.getExerciciosCostas(), 5 - quantidadeSubtrair));
			exerciciosGMRetorno.setExerciciosBiceps(
					adcExerciciosNaoRepetidos(exerciciosGM.getExerciciosBiceps(), 3 - quantidadeSubtrair));
			exerciciosGMRetorno.setExerciciosTriceps(
					adcExerciciosNaoRepetidos(exerciciosGM.getExerciciosTriceps(), 3 - quantidadeSubtrair));
			exerciciosGMRetorno.setExerciciosAntebracos(
					adcExerciciosNaoRepetidos(exerciciosGM.getExerciciosAntebracos(), 2 - quantidadeSubtrair));
			exerciciosGMRetorno.setExerciciosPernas(
					adcExerciciosNaoRepetidos(exerciciosGM.getExerciciosPernas(), 5 - quantidadeSubtrair));
			exerciciosGMRetorno.setExerciciosOmbros(
					adcExerciciosNaoRepetidos(exerciciosGM.getExerciciosOmbros(), 3 - quantidadeSubtrair));
			exerciciosGMRetorno.setExerciciosAbdominais(
					adcExerciciosNaoRepetidos(exerciciosGM.getExerciciosAbdominais(), 2 - quantidadeSubtrair));
			exerciciosGMRetorno.setExerciciosGluteos(
					adcExerciciosNaoRepetidos(exerciciosGM.getExerciciosGluteos(), 1 - quantidadeSubtrair));

			// SE NÃO, SEXO FEMININO
		} else {
			System.out.println("IMC: " + imc);
			// ABAIXO DO PESO OU MARGINALMENTE ACIMA DO PESO
			if (imc < 19.1 || imc >= 26.4 && imc < 27.8) {
				quantidadeSubtrair = 1;

				// ACIMA DO PESO IDEAL
			} else if (imc >= 27.8) {
				quantidadeSubtrair = 2;
			}

			exerciciosGMRetorno.setExerciciosPeito(
					adcExerciciosNaoRepetidos(exerciciosGM.getExerciciosPeito(), 3 - quantidadeSubtrair));
			exerciciosGMRetorno.setExerciciosCostas(
					adcExerciciosNaoRepetidos(exerciciosGM.getExerciciosCostas(), 3 - quantidadeSubtrair));
			exerciciosGMRetorno.setExerciciosBiceps(
					adcExerciciosNaoRepetidos(exerciciosGM.getExerciciosBiceps(), 2 - quantidadeSubtrair));
			exerciciosGMRetorno.setExerciciosTriceps(
					adcExerciciosNaoRepetidos(exerciciosGM.getExerciciosTriceps(), 2 - quantidadeSubtrair));
			exerciciosGMRetorno.setExerciciosAntebracos(
					adcExerciciosNaoRepetidos(exerciciosGM.getExerciciosAntebracos(), 1 - quantidadeSubtrair));
			exerciciosGMRetorno.setExerciciosPernas(
					adcExerciciosNaoRepetidos(exerciciosGM.getExerciciosPernas(), 10 - quantidadeSubtrair));
			exerciciosGMRetorno.setExerciciosOmbros(
					adcExerciciosNaoRepetidos(exerciciosGM.getExerciciosOmbros(), 2 - quantidadeSubtrair));
			exerciciosGMRetorno.setExerciciosAbdominais(
					adcExerciciosNaoRepetidos(exerciciosGM.getExerciciosAbdominais(), 3 - quantidadeSubtrair));
			exerciciosGMRetorno.setExerciciosGluteos(
					adcExerciciosNaoRepetidos(exerciciosGM.getExerciciosGluteos(), 4 - quantidadeSubtrair));

		}

		return exerciciosGMRetorno;
	}

	// VAI ADICIONAR A QUANTIDADE DE EXERCICIOS QUE VOCÊ ESCOLHER
	// PASSA A LISTA DE EXERCICIO E A QUANTIDADE
	// ELE NÃO PEGA EXERCICIOS REPETIDOS
	public List<Exercicio> adcExerciciosNaoRepetidos(List<Exercicio> listaExercicios, int quantidadeExercicios) {
		List<Exercicio> listaExercicioRetorno = new ArrayList<Exercicio>();
		int contador = 0;

		while (contador < quantidadeExercicios) {
			for (Exercicio exercicio : listaExercicios) {

				if (!listaExercicioRetorno.contains(exercicio)) {
					listaExercicioRetorno.add(exercicio);
					contador++;
					break;
				}

			}

		}

		return listaExercicioRetorno;
	}
}
