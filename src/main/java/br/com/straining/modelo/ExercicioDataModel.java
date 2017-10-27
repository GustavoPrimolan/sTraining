package br.com.straining.modelo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.straining.dao.ExercicioDao;

@SuppressWarnings("serial")
public class ExercicioDataModel extends LazyDataModel<Exercicio> implements Serializable{
	
	@Inject
	private ExercicioDao dao;
	
	@PostConstruct
	public void init(){
		
		super.setRowCount(dao.quantidadeDeElementos());
	}
	
	@Override
	public List<Exercicio> load(int inicio, int quantidade, String campoOrdenacao, SortOrder sentidoOrdenacao, Map<String, Object> filtros) {
	    String nome = (String) filtros.get("nome");

	    return dao.listaTodosPaginada(inicio, quantidade, "nome", nome);
	}
	
}
