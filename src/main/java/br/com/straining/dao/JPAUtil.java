package br.com.straining.dao;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	//PRECISA SER O NOME DO UNIT DO ARQUIVO PERSIST
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("straining");
	
	//CDI INSTANCIA O ENTITY MANAGER A CADA REQUEST
	@Produces
	@RequestScoped
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	//MÉTODO QUE FECHA O ENTITY MANAGER
	public void close(@Disposes EntityManager em){
		em.close();
	}

}
