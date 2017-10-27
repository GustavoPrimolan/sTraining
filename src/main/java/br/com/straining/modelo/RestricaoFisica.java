package br.com.straining.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.straining.enums.Articulacao;

@SuppressWarnings("serial")
@Entity
public class RestricaoFisica implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Enumerated(EnumType.STRING)
	private Articulacao articulacao;
	
	private String descricao;
	
	
	public RestricaoFisica() {
		
	}
	
	public RestricaoFisica(Articulacao articulacao, String descricao) {
		this.articulacao = articulacao;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Articulacao getArticulacao() {
		return articulacao;
	}

	public void setArticulacao(Articulacao articulacao) {
		this.articulacao = articulacao;
	}

	
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
