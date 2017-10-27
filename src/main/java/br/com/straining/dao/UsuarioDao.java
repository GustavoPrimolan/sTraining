package br.com.straining.dao;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.straining.modelo.Usuario;


@SuppressWarnings("serial")
public class UsuarioDao implements Serializable{
	
	@Inject
	private EntityManager em;
	
	private DAO<Usuario> dao;
	
	@PostConstruct
	void init() {
		dao = new DAO<Usuario>(this.em, Usuario.class);
		
	}
	
	public Usuario existe(Usuario usuario) {

		TypedQuery<Usuario> query = em.createQuery(
				"select u from Usuario u where u.email = " + ":pEmail and u.senha = :pSenha", Usuario.class);

		query.setParameter("pEmail", usuario.getEmail());
		query.setParameter("pSenha", usuario.getSenha());

		try {

			usuario = query.getSingleResult();
		
		} catch (NoResultException ex) {
			return null;
		}

		return usuario;
	}
	
	public boolean existeEmail(Usuario usuario) {
		TypedQuery<Usuario> query = em.createQuery(
				"select u from Usuario u where u.email = " + ":pEmail", Usuario.class);

		query.setParameter("pEmail", usuario.getEmail());
		
		try {

			query.getSingleResult();
			
		} catch (NoResultException ex) {
			return false;
		}

		return true;
		
	}
	
	/*
	public void buscaRestricoes(Usuario usuario){
		TypedQuery<UsuarioRestricaoFisica> query = em.createQuery(
				"select urf from UsuarioRestricaoFisica urf where urf.usuario_id = :pUsuarioId", UsuarioRestricaoFisica.class);

		query.setParameter("pUsuarioId", usuario.getId());
		
		try {
			usuario.setRestricoes(query.getResultList());
			
			
		}catch(NoResultException ex) {
			return;
		}
		
	}
	*/
	public Usuario buscaPorId(Integer id) {
		return dao.buscaPorId(id);
	}
	
	public void adiciona(Usuario usuario) {
		dao.adiciona(usuario);
	}
	
	public void atualiza(Usuario usuario) {
		dao.atualiza(usuario);
	}
	
}
