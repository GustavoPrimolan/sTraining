package br.com.straining.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.straining.dao.ExercicioDao;

@SuppressWarnings("serial")
public class ExercicioDataModel extends LazyDataModel<Exercicio> implements Serializable {

	private List<Exercicio> listaExercicios;
    
	@Inject
	private ExercicioDao exercicioDao;
	
	@PostConstruct
	void init() {
		this.listaExercicios = exercicioDao.listaTodos();
	}
     
    @Override
    public Exercicio getRowData(String rowKey) {
        for(Exercicio exercicio : listaExercicios) {
            if(exercicio.getId().equals(rowKey))
                return exercicio;
        }
 
        return null;
    }
 
    @Override
    public Object getRowKey(Exercicio exercicio) {
        return exercicio.getId();
    }
 
    @Override
    public List<Exercicio> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {
        List<Exercicio> listaExercicios = new ArrayList<Exercicio>();
 
        for(Exercicio exercicio : this.listaExercicios) {
            boolean match = true;
 
            if (filters != null) {
                for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
                    try {
                        String filterProperty = it.next();
                        Object filterValue = filters.get(filterProperty);
                        String fieldValue = String.valueOf(exercicio.getClass().getField(filterProperty).get(exercicio));
 
                        if(filterValue == null || fieldValue.startsWith(filterValue.toString())) {
                            match = true;
                    }
                    else {
                            match = false;
                            break;
                        }
                    } catch(Exception e) {
                        match = false;
                    }
                }
            }
 
            if(match) {
                listaExercicios.add(exercicio);
            }
        }
 
        //ORDENAÇÃO
        if(sortField != null) {
            Collections.sort(listaExercicios, new ExercicioSorter(sortField, sortOrder));
        }
 
        //CONTADOR DE LINHAS
        int tamanhoDados = listaExercicios.size();
        this.setRowCount(tamanhoDados);
 
        //PAGINAÇÃO
        if(tamanhoDados > pageSize) {
            try {
                return listaExercicios.subList(first, first + pageSize);
            }
            catch(IndexOutOfBoundsException e) {
                return listaExercicios.subList(first, first + (tamanhoDados % pageSize));
            }
        }
        else {
            return listaExercicios;
        }
    }
}
