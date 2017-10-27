package br.com.straining.tx;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

@SuppressWarnings("serial")
@Transacional // PEGA A ANOTA��O QUE CRIEI
@Interceptor // NO MUNDO CDI, ESSES TIPOS DE CLASSE QUE FAZEM ALGO ANTES (EXECUTA BEGIN) E
				// DEPOIS(EXECUTA COMMIT) SE CHAMA INTERCEPTORS
				// � NECESS�RIO COLOCAR A CLASSE O ARQUIVO BEANS.XML
public class GerenciadorDeTransacao implements Serializable {

	@Inject
	EntityManager manager;

	// EXECUTA TRANSA��O E O CDI IR� GERENCIAR
	// CONTEXTO DE INVOCA��O COMO PAR�METRO
	// PARA SABER QUAL M�TODO DO LIVRO BEAN DEVER� SER EXECUTADO
	// FAZ O GER�NCIADOR EXECUTAR ESSE M�TODO
	@AroundInvoke
	public Object executaTX(InvocationContext contexto) throws Exception {
		// ABRE TRANSA��O
		manager.getTransaction().begin();

		System.out.println("Abrindo TX");

		// CHAMA OS DAOS QUE PRECISAM DE UMA TX (TRANSA��O)
		Object resultado = contexto.proceed();

		System.out.println("Fechando TX");
		// COMMITA A TRANSA��O
		manager.getTransaction().commit();

		return resultado;
	}

}
