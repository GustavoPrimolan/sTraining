package br.com.straining.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.straining.dao.ExercicioDao;
import br.com.straining.dao.UsuarioDao;
import br.com.straining.enums.GrupoMuscular;
import br.com.straining.modelo.Exercicio;
import br.com.straining.modelo.Treino;
import br.com.straining.modelo.Usuario;
import br.com.straining.util.PSR;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class GeradorBean implements Serializable {

	@Inject
	private FacesContext context;

	@Inject
	private ExercicioDao exercicioDao;

	@Inject
	private UsuarioDao usuarioDao;

	@Inject
	private PSR psr;

	private Usuario usuario = new Usuario();

	private Treino treino = new Treino();

	// PEITO, BICEPS, TRICEPS, PERNAS, COSTAS, OMBROS, ANTEBRAÇOS, ABDOMINAIS,
	// GLUTEOS;
	private List<Exercicio> exerciciosPeito = new ArrayList<Exercicio>();
	private List<Exercicio> exerciciosCostas = new ArrayList<Exercicio>();
	private List<Exercicio> exerciciosBiceps = new ArrayList<Exercicio>();
	private List<Exercicio> exerciciosTriceps = new ArrayList<Exercicio>();
	private List<Exercicio> exerciciosPernas = new ArrayList<Exercicio>();
	private List<Exercicio> exerciciosOmbros = new ArrayList<Exercicio>();
	private List<Exercicio> exerciciosAntebracos = new ArrayList<Exercicio>();
	private List<Exercicio> exerciciosAbdominais = new ArrayList<Exercicio>();
	private List<Exercicio> exerciciosGluteos = new ArrayList<Exercicio>();

	private Integer progress;

	private Treino treinoCompleto = new Treino();

	// ESSA LISTA IRÁ ARMAZENAR TODAS AS LISTAS COM TODOS OS EXERCÍCIOS DE CADA
	// GRUPO MUSCULAR
	private List<List<Exercicio>> listasDosExercicios = new ArrayList<List<Exercicio>>();

	private List<String> gruposMusculares = Arrays.asList("PEITO", "BICEPS", "TRICEPS", "PERNAS", "COSTAS", "OMBROS",
			"ANTEBRAÇOS", "ABDOMENAIS", "GLUTEOS");

	@PostConstruct
	public void init() {

		exerciciosPeito = psr.embaralhaExercicios(exercicioDao.listaPorGrupoMuscular(GrupoMuscular.PEITO));
		exerciciosCostas = psr.embaralhaExercicios(exercicioDao.listaPorGrupoMuscular(GrupoMuscular.COSTAS));
		exerciciosBiceps = psr.embaralhaExercicios(exercicioDao.listaPorGrupoMuscular(GrupoMuscular.BÍCEPS));
		exerciciosTriceps = psr.embaralhaExercicios(exercicioDao.listaPorGrupoMuscular(GrupoMuscular.TRÍCEPS));
		exerciciosPernas = psr.embaralhaExercicios(exercicioDao.listaPorGrupoMuscular(GrupoMuscular.PERNAS));
		exerciciosOmbros = psr.embaralhaExercicios(exercicioDao.listaPorGrupoMuscular(GrupoMuscular.OMBROS));
		exerciciosAntebracos = psr.embaralhaExercicios(exercicioDao.listaPorGrupoMuscular(GrupoMuscular.ANTEBRAÇOS));
		exerciciosAbdominais = psr.embaralhaExercicios(exercicioDao.listaPorGrupoMuscular(GrupoMuscular.ABDOMINAIS));
		exerciciosGluteos = psr.embaralhaExercicios(exercicioDao.listaPorGrupoMuscular(GrupoMuscular.GLÚTEOS));

		// ADICIONA AS LISTAS DENTRO DA LISTA DOS EXERCICIOS
		listasDosExercicios.add(exerciciosPeito);
		listasDosExercicios.add(exerciciosCostas);
		listasDosExercicios.add(exerciciosBiceps);
		listasDosExercicios.add(exerciciosTriceps);
		listasDosExercicios.add(exerciciosPernas);
		listasDosExercicios.add(exerciciosOmbros);
		listasDosExercicios.add(exerciciosAntebracos);
		listasDosExercicios.add(exerciciosAbdominais);
		listasDosExercicios.add(exerciciosGluteos);

		System.out.println("Quantidade exercicios peito: " + exerciciosPeito.size());
		System.out.println("Quantidade exercicios costas: " + exerciciosCostas.size());
		System.out.println("Quantidade exercicios biceps: " + exerciciosBiceps.size());
		System.out.println("Quantidade exercicios triceps: " + exerciciosTriceps.size());
		System.out.println("Quantidade exercicios pernas: " + exerciciosPernas.size());
		System.out.println("Quantidade exercicios ombros: " + exerciciosOmbros.size());
		System.out.println("Quantidade exercicios antebraços: " + exerciciosAntebracos.size());
		System.out.println("Quantidade exercicios abdominais: " + exerciciosAbdominais.size());
		System.out.println("Quantidade exercicios gluteos: " + exerciciosGluteos.size());

	}

	public Treino getTreino() {
		return treino;
	}

	public void setTreino(Treino treino) {
		this.treino = treino;
	}

	public List<String> getGruposMusculares() {
		return gruposMusculares;
	}

	public void setGruposMusculares(List<String> gruposMusculares) {
		this.gruposMusculares = gruposMusculares;
	}

	public Integer getProgress() {
		if (progress == null) {
			progress = 0;
		} else {
			progress = progress + (int) (Math.random() * 50);

			if (progress > 100)
				progress = 100;
		}

		return progress;
	}

	public void setProgress(Integer progress) {
		this.progress = progress;
	}

	public void onComplete() {
		context.addMessage(null, new FacesMessage("Treino gerado com sucesso!"));
		treinoCompleto.setExercicios(psr.mntTreinoQuatroPorGM(listasDosExercicios));
	}

	public void cancel() {
		progress = null;
	}

	public void adicionaTreinoUsuario() {
		usuario.adicionaTreino(treinoCompleto);

	}

}
