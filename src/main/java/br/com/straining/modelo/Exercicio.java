package br.com.straining.modelo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.straining.enums.Execucao;
import br.com.straining.enums.GrupoMuscular;
import br.com.straining.enums.Nivel;

@Entity
public class Exercicio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;
	
	@Enumerated(EnumType.STRING)
	private GrupoMuscular grupoMuscular;
	
	@Enumerated(EnumType.STRING)
	private GrupoMuscular antagonista;
	
	@Enumerated(EnumType.STRING)
	private Nivel nivelAntagonista;
	
	@Enumerated(EnumType.STRING)
	private Execucao execucao;
	
	private String descricao;
	
	public Exercicio() {
		
	}
	
	public Exercicio(String nome, GrupoMuscular grupoMuscular, GrupoMuscular antagonista, Nivel nivelAntagonista, Execucao execucao, String descricao) {
		this.nome = nome;
		this.grupoMuscular = grupoMuscular;
		this.antagonista = antagonista;
		this.nivelAntagonista = nivelAntagonista;
		this.execucao = execucao;
		
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public GrupoMuscular getGrupoMuscular() {
		return grupoMuscular;
	}

	public void setGrupoMuscular(GrupoMuscular grupoMuscular) {
		this.grupoMuscular = grupoMuscular;
	}

	public GrupoMuscular getAntagonista() {
		return antagonista;
	}

	public void setAntagonista(GrupoMuscular antagonista) {
		this.antagonista = antagonista;
	}


	public Nivel getNivelAntagonista() {
		return nivelAntagonista;
	}

	public void setNivelAntagonista(Nivel nivelAntagonista) {
		this.nivelAntagonista = nivelAntagonista;
	}

	public Execucao getExecucao() {
		return execucao;
	}

	public void setExecucao(Execucao execucao) {
		this.execucao = execucao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
	
}
