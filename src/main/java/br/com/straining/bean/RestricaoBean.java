package br.com.straining.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.straining.modelo.RestricaoFisica;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class RestricaoBean implements Serializable{

	
	
	List<RestricaoFisica> restricoesFisicas = new ArrayList<RestricaoFisica>();
	
	
}
