package br.com.straining.util;

import java.io.Serializable;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

@SuppressWarnings("serial")
public class LogPhaseListener implements PhaseListener, Serializable{

	public void afterPhase(PhaseEvent event) {
		
	}

	
	public void beforePhase(PhaseEvent event) {
		System.out.println("FASE: " + event.getPhaseId());
	}

	
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

	
	
}
