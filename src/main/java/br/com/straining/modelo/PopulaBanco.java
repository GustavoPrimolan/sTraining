package br.com.straining.modelo;

import javax.persistence.EntityManager;

import br.com.straining.dao.JPAUtil;
import br.com.straining.enums.Articulacao;
import br.com.straining.enums.Execucao;
import br.com.straining.enums.GrupoMuscular;
import br.com.straining.enums.Nivel;

public class PopulaBanco {
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		insereExercicios(em);
		insereRestricoes(em);
		em.close();
		
		
	}
	
	
	
	public static void insereExercicios(EntityManager em) {
		Exercicio exercicio1 = new Exercicio("Flex�o alternada dos antebra�os com rota��o do punho e eleva��o dos cotovelos",GrupoMuscular.B�CEPS,GrupoMuscular.OMBROS,Nivel.BAIXO,Execucao.LIVRE,null);
		Exercicio exercicio2 = new Exercicio("Flex�o alternada do antebra�o, com haltere, cotovelo apoiado sobre a coxa",GrupoMuscular.B�CEPS,null,null,Execucao.LIVRE,null);
		Exercicio exercicio3 = new Exercicio("Flex�o dos antebra�os com halteres pequenos mantidos em 'pegada martelo'",GrupoMuscular.B�CEPS,null,null,null,null);
		Exercicio exercicio4 = new Exercicio("Flex�o alternada dos antebra�os com polia baixa",GrupoMuscular.B�CEPS,null,null,null,null);
		Exercicio exercicio5 = new Exercicio("B�ceps, bra�os em cruz, com polia alta",GrupoMuscular.B�CEPS,null,null,null,null);
		Exercicio exercicio6 = new Exercicio("Flex�o dos antebra�os com barra, m�os em supina��o",GrupoMuscular.B�CEPS,null,null,null,null);
		Exercicio exercicio7 = new Exercicio("B�ceps com aparelho 'Larry Scott'",GrupoMuscular.B�CEPS,null,null,null,null);
		Exercicio exercicio8 = new Exercicio("Flex�o dos antebra�os com barra no banco 'Larry Scott'",GrupoMuscular.B�CEPS,null,null,null,null);
		Exercicio exercicio9 = new Exercicio("Flex�o dos antebra�os com barra, m�os em prona��o",GrupoMuscular.B�CEPS,null,null,null,null);
		Exercicio exercicio10 = new Exercicio("Extens�o dos punhos com barra",GrupoMuscular.ANTEBRA�OS,null,null,null,null);
		Exercicio exercicio11 = new Exercicio("Flex�o dos punhos com barra",GrupoMuscular.ANTEBRA�OS,null,null,null,null);
		Exercicio exercicio12 = new Exercicio("Tr�ceps com polia alta, m�os em prona��o",GrupoMuscular.TR�CEPS,null,null,null,null);
		Exercicio exercicio13 = new Exercicio("Tr�ceps com polia alta, m�os em supina��o",GrupoMuscular.TR�CEPS,null,null,null,null);
		Exercicio exercicio14 = new Exercicio("Extens�o alternada dos antebra�os com polia alta, m�os em supina��o",GrupoMuscular.TR�CEPS,null,null,null,null);
		Exercicio exercicio15 = new Exercicio("Extens�o dos antebra�os com barra, deitado sobre um banco",GrupoMuscular.TR�CEPS,null,null,null,null);
		Exercicio exercicio16 = new Exercicio("Extens�o dos anatebra�os, deitado com halteres",GrupoMuscular.TR�CEPS,null,null,null,null);
		Exercicio exercicio17 = new Exercicio("Extens�o vertical alternada dos bra�os com haltere",GrupoMuscular.TR�CEPS,null,null,null,null);
		Exercicio exercicio18 = new Exercicio("Extens�o dos antebra�os; sentado, com haltere seguro pelas duas m�os",GrupoMuscular.TR�CEPS,null,null,null,null);
		Exercicio exercicio19 = new Exercicio("Extens�o dos antebra�os, sentado, com barra",GrupoMuscular.TR�CEPS,null,null,null,null);
		Exercicio exercicio20 = new Exercicio("Extens�o alternada dos antebra�os com um haltere, tronco inclinado para a frente",GrupoMuscular.TR�CEPS,null,null,null,null);
		Exercicio exercicio21 = new Exercicio("Repuls�o entre dois bancos",GrupoMuscular.TR�CEPS,null,null,null,null);
		Exercicio exercicio22 = new Exercicio("Desenvolvimento atr�s da nuca com barra",GrupoMuscular.OMBROS,null,null,null,null);
		Exercicio exercicio23 = new Exercicio("Desenvolvimento 'pela frente' com barra",GrupoMuscular.OMBROS,null,null,null,null);
		Exercicio exercicio24 = new Exercicio("Desenvolvimento sentado com halteres",GrupoMuscular.OMBROS,null,null,null,null);
		Exercicio exercicio25 = new Exercicio("Desenvolvimento 'pela frente' com rota��o do punho",GrupoMuscular.OMBROS,null,null,null,null);
		Exercicio exercicio26 = new Exercicio("Eleva��o lateral dos bra�os com halteres",GrupoMuscular.OMBROS,null,null,null,null);
		Exercicio exercicio27 = new Exercicio("Eleva��o lateral, tronco inclinado para a frente",GrupoMuscular.OMBROS,null,null,null,null);
		Exercicio exercicio28 = new Exercicio("Eleva��o alternada 'para a frente' com halteres",GrupoMuscular.OMBROS,null,null,null,null);
		Exercicio exercicio29 = new Exercicio("Eleva��o lateral, deitado de lado",GrupoMuscular.OMBROS,null,null,null,null);
		Exercicio exercicio30 = new Exercicio("Eleva��o lateral alternada com polia baixa",GrupoMuscular.OMBROS,null,null,null,null);
		Exercicio exercicio31 = new Exercicio("Eleva��o 'pela frente' alternada com polia baixa",GrupoMuscular.OMBROS,null,null,null,null);
		Exercicio exercicio32 = new Exercicio("Eleva��o lateral com polia baixa, tronco inclinado para a frente",GrupoMuscular.OMBROS,null,null,null,null);
		Exercicio exercicio33 = new Exercicio("Eleva��o 'para a frente ou frontal' com um haltere",GrupoMuscular.OMBROS,null,null,null,null);
		Exercicio exercicio34 = new Exercicio("Eleva��o 'para a frente ou frontal' com barra",GrupoMuscular.OMBROS,null,null,null,null);
		Exercicio exercicio35 = new Exercicio("Puxada vertical com barra, n�os separadas (ou rowing vertical)",GrupoMuscular.OMBROS,null,null,null,null);
		Exercicio exercicio36 = new Exercicio("Eleva��o lateral com aparelho espec�fico",GrupoMuscular.OMBROS,null,null,null,null);
		Exercicio exercicio37 = new Exercicio("Posterior dos OMBROSs com aparelho espec�fico ",GrupoMuscular.OMBROS,null,null,null,null);
		Exercicio exercicio38 = new Exercicio("Supino ou bench press",GrupoMuscular.PEITO,null,null,null,null);
		Exercicio exercicio39 = new Exercicio("Supino, m�os aproximadas",GrupoMuscular.PEITO,null,null,null,null);
		Exercicio exercicio40 = new Exercicio("Supino inclinado",GrupoMuscular.PEITO,null,null,null,null);
		Exercicio exercicio41 = new Exercicio("Supino em declive",GrupoMuscular.PEITO,null,null,null,null);
		Exercicio exercicio42 = new Exercicio("Flex�es ou repuls�es frente ao solo",GrupoMuscular.PEITO,null,null,null,null);
		Exercicio exercicio43 = new Exercicio("Dips ou repuls�es em barras paralelas",GrupoMuscular.PEITO,null,null,null,null);
		Exercicio exercicio44 = new Exercicio("Supino com halteres",GrupoMuscular.PEITO,null,null,null,null);
		Exercicio exercicio45 = new Exercicio("Abdu��o-adu��o, deitado com halteres",GrupoMuscular.PEITO,null,null,null,null);
		Exercicio exercicio46 = new Exercicio("Supino, inlcinado, com halteres",GrupoMuscular.PEITO,null,null,null,null);
		Exercicio exercicio47 = new Exercicio("Abdu��o-adu��o, inclinado, com halteres",GrupoMuscular.PEITO,null,null,null,null);
		Exercicio exercicio48 = new Exercicio("Abdu��o-adu��o com aparelho espec�fico",GrupoMuscular.PEITO,null,null,null,null);
		Exercicio exercicio49 = new Exercicio("Abdu��o-adu��o em p� com uma polia em face",GrupoMuscular.PEITO,null,null,null,null);
		Exercicio exercicio50 = new Exercicio("Pull-over com haltere",GrupoMuscular.PEITO,null,null,null,null);
		Exercicio exercicio51 = new Exercicio("Pull-over com barra, deitado sobre um banco horizontal",GrupoMuscular.PEITO,null,null,null,null);
		Exercicio exercicio52 = new Exercicio("Tra��o na barra fixa",GrupoMuscular.COSTAS,null,null,null,null);
		Exercicio exercicio53 = new Exercicio("Tra��o na barra fixa, m�os em supna��o",GrupoMuscular.COSTAS,null,null,null,null);
		Exercicio exercicio54 = new Exercicio("Puxada na frente com polia alta",GrupoMuscular.COSTAS,null,null,null,null);
		Exercicio exercicio55 = new Exercicio("Puxada atr�s com polia alta",GrupoMuscular.COSTAS,null,null,null,null);
		Exercicio exercicio56 = new Exercicio("Puxada na frente com polia alta, com um pegagdor de pegada aproximada",GrupoMuscular.COSTAS,null,null,null,null);
		Exercicio exercicio57 = new Exercicio("Puxada com os bra�os estendidos com polia alta",GrupoMuscular.COSTAS,null,null,null,null);
		Exercicio exercicio58 = new Exercicio("Remada com polia baixa, pegada com as m�os juntas e em semi-prona��o",GrupoMuscular.COSTAS,null,null,null,null);
		Exercicio exercicio59 = new Exercicio("Puxada horizontal com um haltere",GrupoMuscular.COSTAS,null,null,null,null);
		Exercicio exercicio60 = new Exercicio("Puxada horizontal com barra, m�os em prona��o",GrupoMuscular.COSTAS,null,null,null,null);
		Exercicio exercicio61 = new Exercicio("Puxada na barra em T",GrupoMuscular.COSTAS,null,null,null,null);
		Exercicio exercicio62 = new Exercicio("Levantamento terra",GrupoMuscular.COSTAS,null,null,null,null);
		Exercicio exercicio63 = new Exercicio("Levantamento terra, pernas estendidas",GrupoMuscular.COSTAS,null,null,null,null);
		Exercicio exercicio64 = new Exercicio("Extens�o do tronco sobre um banco espec�fico",GrupoMuscular.COSTAS,null,null,null,null);
		Exercicio exercicio65 = new Exercicio("Puxada vertical com barra, m�os juntas",GrupoMuscular.COSTAS,null,null,null,null);
		Exercicio exercicio66 = new Exercicio("Eleva��o dos ombros com barra",GrupoMuscular.COSTAS,null,null,null,null);
		Exercicio exercicio67 = new Exercicio("Eleva��o e rota��o dos ombros com halteres",GrupoMuscular.COSTAS,null,null,null,null);
		Exercicio exercicio68 = new Exercicio("Eleva��o dos ombros com multi-exercitador ou com aparelho espec�fico",GrupoMuscular.COSTAS,null,null,null,null);
		Exercicio exercicio69 = new Exercicio("O agachamento",GrupoMuscular.PERNAS,null,null,null,null);
		Exercicio exercicio70 = new Exercicio("Agachamento com as pernas afastadas",GrupoMuscular.PERNAS,null,null,null,null);
		Exercicio exercicio71 = new Exercicio("Agachamento com a barra na frente",GrupoMuscular.PERNAS,null,null,null,null);
		Exercicio exercicio72 = new Exercicio("Flex�o das coxas com halteres",GrupoMuscular.PERNAS,null,null,null,null);
		Exercicio exercicio73 = new Exercicio("Leg press inclinado",GrupoMuscular.PERNAS,null,null,null,null);
		Exercicio exercicio74 = new Exercicio("Prensa inclinada ou hack squat",GrupoMuscular.PERNAS,null,null,null,null);
		Exercicio exercicio75 = new Exercicio("Extens�o dos joelhos com aparelho espec�fico ou leg extension",GrupoMuscular.PERNAS,null,null,null,null);
		Exercicio exercicio76 = new Exercicio("Flex�o dos joelhos com aparelho espec�fico ou leg curl",GrupoMuscular.PERNAS,null,null,null,null);
		Exercicio exercicio77 = new Exercicio("Flex�o dos joelhos, em p�, com aparelho espec�fico",GrupoMuscular.PERNAS,null,null,null,null);
		Exercicio exercicio78 = new Exercicio("Flex�o dos joelhos, sentado, com aparelho espec�fico",GrupoMuscular.PERNAS,null,null,null,null);
		Exercicio exercicio79 = new Exercicio("Flex�o do tronco para a frente ou good morning",GrupoMuscular.PERNAS,null,null,null,null);
		Exercicio exercicio80 = new Exercicio("Adutores com polia baixa",GrupoMuscular.PERNAS,null,null,null,null);
		Exercicio exercicio81 = new Exercicio("Autores com aparelho espec�fico",GrupoMuscular.PERNAS,null,null,null,null);
		Exercicio exercicio82 = new Exercicio("Extens�o dos p�s com aparelho espec�fico",GrupoMuscular.PERNAS,null,null,null,null);
		Exercicio exercicio83 = new Exercicio("Extens�o dos p�s com aparelho (peso repousando sobre a pelve) ou donkey calf raise",GrupoMuscular.PERNAS,null,null,null,null);
		Exercicio exercicio84 = new Exercicio("Extens�o dos p�s com aparelho espec�fico ou prensa dos s�leos",GrupoMuscular.PERNAS,null,null,null,null);
		Exercicio exercicio85 = new Exercicio("Afundo para a frente",GrupoMuscular.GL�TEOS,null,null,null,null);
		Exercicio exercicio86 = new Exercicio("Extens�o do quadril com polia baixa",GrupoMuscular.GL�TEOS,null,null,null,null);
		Exercicio exercicio87 = new Exercicio("Extens�o do quadril com aparelho espec�fico",GrupoMuscular.GL�TEOS,null,null,null,null);
		Exercicio exercicio88 = new Exercicio("Extens�o do quadril no solo",GrupoMuscular.GL�TEOS,null,null,null,null);
		Exercicio exercicio89 = new Exercicio("Eleva��o da pelve do solo",GrupoMuscular.GL�TEOS,null,null,null,null);
		Exercicio exercicio90 = new Exercicio("Abdu��o do quadril, em p�, com polia baixa",GrupoMuscular.GL�TEOS,null,null,null,null);
		Exercicio exercicio91 = new Exercicio("Abdu��o do quadril, com aparelho espec�fico",GrupoMuscular.GL�TEOS,null,null,null,null);
		Exercicio exercicio92 = new Exercicio("Abdu��o do quadril, deitado",GrupoMuscular.GL�TEOS,null,null,null,null);
		Exercicio exercicio93 = new Exercicio("Abdu��o, sentado, com aparelho espec�fico",GrupoMuscular.GL�TEOS,null,null,null,null);
		Exercicio exercicio94 = new Exercicio("Abdominal",GrupoMuscular.ABDOMINAIS,null,null,null,null);
		Exercicio exercicio95 = new Exercicio("Abdominal no solo",GrupoMuscular.ABDOMINAIS,null,null,null,null);
		Exercicio exercicio96 = new Exercicio("Abdominal com os p�s fixos",GrupoMuscular.ABDOMINAIS,null,null,null,null);
		Exercicio exercicio97 = new Exercicio("Abdominal (pernas apoiadas sobre um banco)",GrupoMuscular.ABDOMINAIS,null,null,null,null);
		Exercicio exercicio98 = new Exercicio("Abdominal no banco inclinado",GrupoMuscular.ABDOMINAIS,null,null,null,null);
		Exercicio exercicio99 = new Exercicio("Abdominal suspenso no banco espec�fico",GrupoMuscular.ABDOMINAIS,null,null,null,null);
		Exercicio exercicio100 = new Exercicio("Abdominal com polia alta",GrupoMuscular.ABDOMINAIS,null,null,null,null);
		Exercicio exercicio101 = new Exercicio("Abdominais ou crunch com aparelho espec�fico",GrupoMuscular.ABDOMINAIS,null,null,null,null);
		Exercicio exercicio102 = new Exercicio("Eleva��es das pernas na prancha inclinada com crunch e eleva��o da pelve",GrupoMuscular.ABDOMINAIS,null,null,null,null);
		Exercicio exercicio103 = new Exercicio("Eleva��o dos joelhos na cadeira abdominal",GrupoMuscular.ABDOMINAIS,null,null,null,null);
		Exercicio exercicio104 = new Exercicio("Eleva��o dos joelhos, suspenso na barra fixa",GrupoMuscular.ABDOMINAIS,null,null,null,null);
		Exercicio exercicio105 = new Exercicio("Rota��o do tronco com bast�o",GrupoMuscular.ABDOMINAIS,null,null,null,null);
		Exercicio exercicio106 = new Exercicio("Flex�o lateral do tronco com haltere",GrupoMuscular.ABDOMINAIS,null,null,null,null);
		Exercicio exercicio107 = new Exercicio("Flex�o lateral do tronco no banco",GrupoMuscular.ABDOMINAIS,null,null,null,null);
		Exercicio exercicio108 = new Exercicio("O twist",GrupoMuscular.ABDOMINAIS,null,null,null,null);
		
		
		
		
		em.getTransaction().begin();
		
		em.persist(exercicio1);
		em.persist(exercicio2);
		em.persist(exercicio3);
		em.persist(exercicio4);
		em.persist(exercicio5);
		em.persist(exercicio6);
		em.persist(exercicio7);
		em.persist(exercicio8);
		em.persist(exercicio9);
		em.persist(exercicio10);
		em.persist(exercicio11);
		em.persist(exercicio12);
		em.persist(exercicio13);
		em.persist(exercicio14);
		em.persist(exercicio15);
		em.persist(exercicio16);
		em.persist(exercicio17);
		em.persist(exercicio18);
		em.persist(exercicio19);
		em.persist(exercicio20);
		em.persist(exercicio21);
		em.persist(exercicio22);
		em.persist(exercicio23);
		em.persist(exercicio24);
		em.persist(exercicio25);
		em.persist(exercicio26);
		em.persist(exercicio27);
		em.persist(exercicio28);
		em.persist(exercicio29);
		em.persist(exercicio30);
		em.persist(exercicio31);
		em.persist(exercicio32);
		em.persist(exercicio33);
		em.persist(exercicio34);
		em.persist(exercicio35);
		em.persist(exercicio36);
		em.persist(exercicio37);
		em.persist(exercicio38);
		em.persist(exercicio39);
		em.persist(exercicio40);
		em.persist(exercicio41);
		em.persist(exercicio42);
		em.persist(exercicio43);
		em.persist(exercicio44);
		em.persist(exercicio45);
		em.persist(exercicio46);
		em.persist(exercicio47);
		em.persist(exercicio48);
		em.persist(exercicio49);
		em.persist(exercicio50);
		em.persist(exercicio51);
		em.persist(exercicio52);
		em.persist(exercicio53);
		em.persist(exercicio54);
		em.persist(exercicio55);
		em.persist(exercicio56);
		em.persist(exercicio57);
		em.persist(exercicio58);
		em.persist(exercicio59);
		em.persist(exercicio60);
		em.persist(exercicio61);
		em.persist(exercicio62);
		em.persist(exercicio63);
		em.persist(exercicio64);
		em.persist(exercicio65);
		em.persist(exercicio66);
		em.persist(exercicio67);
		em.persist(exercicio68);
		em.persist(exercicio69);
		em.persist(exercicio70);
		em.persist(exercicio71);
		em.persist(exercicio72);
		em.persist(exercicio73);
		em.persist(exercicio74);
		em.persist(exercicio75);
		em.persist(exercicio76);
		em.persist(exercicio77);
		em.persist(exercicio78);
		em.persist(exercicio79);
		em.persist(exercicio80);
		em.persist(exercicio81);
		em.persist(exercicio82);
		em.persist(exercicio83);
		em.persist(exercicio84);
		em.persist(exercicio85);
		em.persist(exercicio86);
		em.persist(exercicio87);
		em.persist(exercicio88);
		em.persist(exercicio89);
		em.persist(exercicio90);
		em.persist(exercicio91);
		em.persist(exercicio92);
		em.persist(exercicio93);
		em.persist(exercicio94);
		em.persist(exercicio95);
		em.persist(exercicio96);
		em.persist(exercicio97);
		em.persist(exercicio98);
		em.persist(exercicio99);
		em.persist(exercicio100);
		em.persist(exercicio101);
		em.persist(exercicio102);
		em.persist(exercicio103);
		em.persist(exercicio104);
		em.persist(exercicio105);
		em.persist(exercicio106);
		em.persist(exercicio107);
		em.persist(exercicio108);

		
		em.getTransaction().commit();
		
		
	}
	
	public static void insereRestricoes(EntityManager em) {
		RestricaoFisica restricao01 = new RestricaoFisica(Articulacao.COLUNA, null);
		RestricaoFisica restricao02 = new RestricaoFisica(Articulacao.JOELHO, null);
		RestricaoFisica restricao03 = new RestricaoFisica(Articulacao.COTOVELO, null);
		RestricaoFisica restricao04 = new RestricaoFisica(Articulacao.LOMBAR, null);
		RestricaoFisica restricao05 = new RestricaoFisica(Articulacao.OMBRO, null);
		
		em.getTransaction().begin();
		
		em.persist(restricao01);
		em.persist(restricao02);
		em.persist(restricao03);
		em.persist(restricao04);
		em.persist(restricao05);
		
		em.getTransaction().commit();
		
		
	}
	
	
	
}
