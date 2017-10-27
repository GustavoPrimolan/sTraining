package br.com.straining.bean;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.straining.dao.UsuarioDao;
import br.com.straining.modelo.Usuario;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class PrincipalBean implements Serializable{
	
	@Inject
	private UsuarioDao usuarioDao;
	
	private Usuario usuario;
	
	
}
