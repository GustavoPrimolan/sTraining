package br.com.straining.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.straining.dao.ExercicioDao;
import br.com.straining.dao.TreinoDao;
import br.com.straining.dao.UsuarioDao;
import br.com.straining.enums.GrupoMuscular;
import br.com.straining.modelo.Exercicio;
import br.com.straining.modelo.Treino;
import br.com.straining.modelo.Usuario;
import br.com.straining.tx.Transacional;
import br.com.straining.util.ExerciciosGM;
import br.com.straining.util.GrupoMuscularUtil;
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
	private TreinoDao treinoDao;
	
	@Inject
	private PSR psr;
	
	
	
	private Usuario usuario = new Usuario();

	private Treino treino = new Treino();

	private List<GrupoMuscularUtil> listaGrupoMuscularUtil = new ArrayList<GrupoMuscularUtil>();
	
	// OBJETO COM LISTAS DE CADA GRUPO MUSCULAR
	// OBJETO AUXILIAR
	private ExerciciosGM exerciciosGMAux = new ExerciciosGM();

	private ExerciciosGM exerciciosGM = new ExerciciosGM();

	private Integer progress;

	private List<String> gruposMusculares = new ArrayList<String>();

	@PostConstruct
	public void init() {
		
		Usuario sessao = (Usuario) context.getExternalContext().getSessionMap().get("usuarioLogado");
		usuario = usuarioDao.buscaPorId(sessao.getId());
		
		// PEGA OS VALORES DO ENUM PARA A LISTA
		capturaGruposMusculares();

		// MÉTODO QUE CAPTURA NO BANCO OS EXERCICIOS E SETA AS LISTAS
		// EMBARALHANDO ELAS COM O MÉTODO DA CLASSE PSR
		configuraListasExerciciosGM();

		System.out.println("Nome do usuário: " + usuario.getNome());
	}

	public void capturaGruposMusculares() {
		for (int i = 0; i < GrupoMuscular.values().length; i++) {
			gruposMusculares.add(GrupoMuscular.values()[i].toString());
		}
	}

	// MÉTODO QUE CAPTURA DO BANCO OS EXERCICIOS DOS GRUPOS MUSCULARES
	// E EMBARALHA ELES PARA QUE A ORDEM SEJA ALEATÓRIA
	public void configuraListasExerciciosGM() {
		exerciciosGMAux
				.setExerciciosPeito(psr.embaralhaExercicios(exercicioDao.listaPorGrupoMuscular(GrupoMuscular.PEITO)));
		exerciciosGMAux
				.setExerciciosCostas(psr.embaralhaExercicios(exercicioDao.listaPorGrupoMuscular(GrupoMuscular.COSTAS)));
		exerciciosGMAux
				.setExerciciosBiceps(psr.embaralhaExercicios(exercicioDao.listaPorGrupoMuscular(GrupoMuscular.BÍCEPS)));
		exerciciosGMAux.setExerciciosTriceps(
				psr.embaralhaExercicios(exercicioDao.listaPorGrupoMuscular(GrupoMuscular.TRÍCEPS)));
		exerciciosGMAux
				.setExerciciosPernas(psr.embaralhaExercicios(exercicioDao.listaPorGrupoMuscular(GrupoMuscular.PERNAS)));
		exerciciosGMAux
				.setExerciciosOmbros(psr.embaralhaExercicios(exercicioDao.listaPorGrupoMuscular(GrupoMuscular.OMBROS)));
		exerciciosGMAux.setExerciciosAntebracos(
				psr.embaralhaExercicios(exercicioDao.listaPorGrupoMuscular(GrupoMuscular.ANTEBRAÇOS)));
		exerciciosGMAux.setExerciciosAbdominais(
				psr.embaralhaExercicios(exercicioDao.listaPorGrupoMuscular(GrupoMuscular.ABDOMINAIS)));
		exerciciosGMAux.setExerciciosGluteos(
				psr.embaralhaExercicios(exercicioDao.listaPorGrupoMuscular(GrupoMuscular.GLÚTEOS)));

		System.out.println("Quantidade exercicios peito: " + exerciciosGMAux.getExerciciosPeito().size());
		System.out.println("Quantidade exercicios costas: " + exerciciosGMAux.getExerciciosCostas().size());
		System.out.println("Quantidade exercicios biceps: " + exerciciosGMAux.getExerciciosBiceps().size());
		System.out.println("Quantidade exercicios triceps: " + exerciciosGMAux.getExerciciosTriceps().size());
		System.out.println("Quantidade exercicios pernas: " + exerciciosGMAux.getExerciciosPernas().size());
		System.out.println("Quantidade exercicios ombros: " + exerciciosGMAux.getExerciciosOmbros().size());
		System.out.println("Quantidade exercicios antebraços: " + exerciciosGMAux.getExerciciosAntebracos().size());
		System.out.println("Quantidade exercicios abdominais: " + exerciciosGMAux.getExerciciosAbdominais().size());
		System.out.println("Quantidade exercicios gluteos: " + exerciciosGMAux.getExerciciosGluteos().size());
		
		
		
	}

	public List<GrupoMuscularUtil> getListaGrupoMuscularUtil() {
		return listaGrupoMuscularUtil;
	}

	public void setListaGrupoMuscularUtil(List<GrupoMuscularUtil> listaGrupoMuscularUtil) {
		this.listaGrupoMuscularUtil = listaGrupoMuscularUtil;
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
			progress = progress + (int) (Math.random() * 100);

			if (progress > 100)
				progress = 100;
		}

		return progress;
	}

	public void setProgress(Integer progress) {
		this.progress = progress;
	}

	public void onComplete() {
		

		
		System.out.println("GEROU TREINO");

		try {
			exerciciosGM = psr.montaTreino(exerciciosGMAux, usuario);
		}catch(Exception e) {
			
			context.addMessage(null, new FacesMessage("Não foi possível gerar treino! Informações no perfil não preenchidas!"));
			return;
		}
		GrupoMuscularUtil grupoMuscularUtil = new GrupoMuscularUtil();
		grupoMuscularUtil.setNome("Peito");
		grupoMuscularUtil.setExercicios(exerciciosGM.getExerciciosPeito());
		listaGrupoMuscularUtil.add(grupoMuscularUtil);
		
		
		grupoMuscularUtil = new GrupoMuscularUtil();
		grupoMuscularUtil.setNome("Costas");
		grupoMuscularUtil.setExercicios(exerciciosGM.getExerciciosCostas());
		listaGrupoMuscularUtil.add(grupoMuscularUtil);

		
		grupoMuscularUtil = new GrupoMuscularUtil();
		grupoMuscularUtil.setNome("Bíceps");
		grupoMuscularUtil.setExercicios(exerciciosGM.getExerciciosBiceps());
		listaGrupoMuscularUtil.add(grupoMuscularUtil);

		
		grupoMuscularUtil = new GrupoMuscularUtil();
		grupoMuscularUtil.setNome("Tríceps");
		grupoMuscularUtil.setExercicios(exerciciosGM.getExerciciosTriceps());
		listaGrupoMuscularUtil.add(grupoMuscularUtil);

		
		grupoMuscularUtil = new GrupoMuscularUtil();
		grupoMuscularUtil.setNome("Antebraços");
		grupoMuscularUtil.setExercicios(exerciciosGM.getExerciciosAntebracos());
		listaGrupoMuscularUtil.add(grupoMuscularUtil);

		
		grupoMuscularUtil = new GrupoMuscularUtil();
		grupoMuscularUtil.setNome("Ombros");
		grupoMuscularUtil.setExercicios(exerciciosGM.getExerciciosOmbros());
		listaGrupoMuscularUtil.add(grupoMuscularUtil);

		
		grupoMuscularUtil = new GrupoMuscularUtil();
		grupoMuscularUtil.setNome("Pernas");
		grupoMuscularUtil.setExercicios(exerciciosGM.getExerciciosPernas());
		listaGrupoMuscularUtil.add(grupoMuscularUtil);

		
		grupoMuscularUtil = new GrupoMuscularUtil();
		grupoMuscularUtil.setNome("Abdominais");
		grupoMuscularUtil.setExercicios(exerciciosGM.getExerciciosAbdominais());
		listaGrupoMuscularUtil.add(grupoMuscularUtil);

		
		grupoMuscularUtil = new GrupoMuscularUtil();
		grupoMuscularUtil.setNome("Glúteos");
		grupoMuscularUtil.setExercicios(exerciciosGM.getExerciciosGluteos());
		listaGrupoMuscularUtil.add(grupoMuscularUtil);

		
		
		for (Exercicio exercicioPeito : exerciciosGM.getExerciciosPeito()) {
			System.out.println(exercicioPeito.getNome());
		}
		
		for (Exercicio exercicioCostas : exerciciosGM.getExerciciosCostas()) {
			System.out.println(exercicioCostas.getNome());
		}
		
		
		System.out.println("COMPLETOU");
		context.addMessage(null, new FacesMessage("Treino gerado com sucesso!"));
	}

	public void cancel() {
		progress = null;
	}
	
	
	@Transacional
	public void adicionaTreinoUsuario() {
		
		treino.getExercicios().addAll(exerciciosGM.getExerciciosPeito());
		treino.getExercicios().addAll(exerciciosGM.getExerciciosCostas());
		treino.getExercicios().addAll(exerciciosGM.getExerciciosBiceps());
		treino.getExercicios().addAll(exerciciosGM.getExerciciosTriceps());
		treino.getExercicios().addAll(exerciciosGM.getExerciciosAntebracos());
		treino.getExercicios().addAll(exerciciosGM.getExerciciosPernas());
		treino.getExercicios().addAll(exerciciosGM.getExerciciosOmbros());
		treino.getExercicios().addAll(exerciciosGM.getExerciciosGluteos());
		
		for (Exercicio exercicio : treino.getExercicios()) {
			System.out.println(exercicio.getNome());
		}
		
		System.out.println("Adicionou treino");
		treinoDao.adiciona(treino);
		
		usuario.adicionaTreino(treino);
		
		usuarioDao.atualiza(usuario);

	}

}
