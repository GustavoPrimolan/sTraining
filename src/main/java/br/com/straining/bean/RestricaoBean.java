package br.com.straining.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.straining.dao.RestricaoFisicaDao;
import br.com.straining.modelo.RestricaoFisica;
import br.com.straining.tx.Log;
import br.com.straining.tx.Transacional;
import br.com.straining.util.RedirectView;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class RestricaoBean implements Serializable {

	// IRÁ INJETAR O DAO NO BEAN (CDI) Context and Dependency Injection
	@Inject
	private RestricaoFisicaDao restricaoFisicaDao; // CDI faz new AutorDao() e injeta

	private RestricaoFisica restricaoFisica = new RestricaoFisica();

	private Integer restricaoFisicaId;

	public Integer getRestricaoFisicaId() {
		return restricaoFisicaId;
	}

	public void setRestricaoFisicaId(Integer restricaoFisicaId) {
		this.restricaoFisicaId = restricaoFisicaId;
	}

	@Log
	public void carregarRestricaoFisicaPelaId() {
		this.restricaoFisica = this.restricaoFisicaDao.buscaPorId(restricaoFisicaId);
	}

	public RestricaoFisica getRestricaoFisica() {
		return this.restricaoFisica;
	}

	@Log
	public List<RestricaoFisica> getRestricoesFisicas() {

		return this.restricaoFisicaDao.listaTodos();
	}

	@Transacional
	public RedirectView gravar() {
		System.out.println("Gravando nova Restrição " + this.restricaoFisica.getArticulacao());

		if (restricaoFisica.getId() == null) {
			this.restricaoFisicaDao.adiciona(this.restricaoFisica);
		} else {
			this.restricaoFisicaDao.atualiza(this.restricaoFisica);
		}

		// NECESSÁRIO FAZER ISSO POIS QUANDO O BOTÃO É CLICADO EM GRAVAR
		// A VIEW NÃO PUXARÁ O MESMO OBJETO, FAZENDO COM QUE O INPUT NÃO VENHA
		// PREENCHIDO APÓS SER INSERIDO
		// UM NOVO AUTOR
		this.restricaoFisica = new RestricaoFisica();

		// ESSE RETORNO FAZ O REDIRECIONAMENTO DA PÁGINA PARA A PÁGINA LIVROS E
		// DO LADO DO CLIENTE
		// POR CONTA DO PARÂMETRO FACES-REDIRECT=TRUE
		// return "livro?faces-redirect=true";

		// PARA DEFINIR MELHOR A INTENÇÃO DO RETORNO É UTILIZADO A LINHA ABAIXO:
		return new RedirectView("perfil");

	}

	@Transacional
	public void remove(RestricaoFisica restricaoFisica) {
		System.out.println("Removendo Restrição");

		this.restricaoFisicaDao.remove(restricaoFisica);
	}

	public void carregar(RestricaoFisica restricaoFisica) {
		System.out.println("Carregando Restrição");

		this.restricaoFisica = restricaoFisica;
	}

}
