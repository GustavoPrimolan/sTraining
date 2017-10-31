package br.com.straining.modelo;

import java.util.Comparator;
import org.primefaces.model.SortOrder;
import br.com.straining.modelo.Exercicio;
import java.lang.reflect.Field;

public class ExercicioSorter implements Comparator<Exercicio> {

	private String sortField;

	private SortOrder sortOrder;

	public ExercicioSorter(String sortField, SortOrder sortOrder) {
			this.sortField = sortField;
	        this.sortOrder = sortOrder;
	}

	public int compare(Exercicio exercicio1, Exercicio exercicio2) {
		System.out.println("Exercicio 1: " + exercicio1.getNome());
		Field[] campos = Exercicio.class.getFields();
		System.out.println("Quantidade de campos: " + Exercicio.class.getFields().length);
		for (int i = 0; i < campos.length; i++) {
			System.out.println(campos[i].toString());
		}
		
			
		System.out.println("Exercicio 2:" + exercicio2.getNome());
		try {
			System.out.println("Entrou try");
			Object value1 = Exercicio.class.getField(this.sortField).get(exercicio1);
			System.out.println(value1.toString());
			Object value2 = Exercicio.class.getField(this.sortField).get(exercicio2);

			int value = ((Comparable) value1).compareTo(value2);

			return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
		} catch (Exception e) {
			System.out.println(e);
			throw new RuntimeException();
		}
	}

}
