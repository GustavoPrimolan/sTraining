package br.com.straining.util;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.com.straining.modelo.Usuario;

@SuppressWarnings("serial")
public class Autorizador implements PhaseListener{

	/*FASES QUE O PHASE APLICARÁ*/
	
	
	public void afterPhase(PhaseEvent event) {
			
		FacesContext context = event.getFacesContext();
		
		String nomePagina = context.getViewRoot().getViewId();
		
		System.out.println(nomePagina);
		
		Usuario usuarioLogado = (Usuario) context.getExternalContext().getSessionMap().get("usuarioLogado");
		NavigationHandler handler = context.getApplication().getNavigationHandler();
		if("/login.xhtml".equals(nomePagina) || "/cadastro.xhtml".equals(nomePagina)){
			if(usuarioLogado != null){		
				handler.handleNavigation(context, null, "/principal.xhtml?faces-redirect=true");
				context.getRenderResponse();
				System.out.println("JOGANDO PARA A PÁGINA PRINCIPAL");
			}
			
			return;
		}
		

		if(usuarioLogado != null){
			return;
		}
		
		handler.handleNavigation(context, null, "/login.xhtml?faces-redirect=true");
		context.renderResponse();
		
	}

	
	public void beforePhase(PhaseEvent event) {
		
	}

	
	
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

	
	
}
