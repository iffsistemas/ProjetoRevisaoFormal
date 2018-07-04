package controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import modelo.Participante;
import service.ParticipanteService;

 
@ViewScoped
@ManagedBean
public class ParticipanteBean {

	
	@EJB
	ParticipanteService participanteService;
	
	
	private Participante participante = new Participante();
	List<Participante> participantes = new ArrayList<Participante>();
	
	
	
	
	public ParticipanteService getParticipanteService() {
		return participanteService;
	}

	public void setParticipanteService(ParticipanteService participanteService) {
		this.participanteService = participanteService;
	}

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

	public List<Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<Participante> participantes) {
		this.participantes = participantes;
	}

	@PostConstruct
	public void init(){
		atualizarParticipantes();
	}
	
	protected void atualizarParticipantes(){
		getParticipantes().clear();
		getParticipantes().addAll(participanteService.listAll());
	}
	
	
public void salvarParticipante() {
			String msg;
		
			if(getParticipante().getId()==null){ 
				
				participanteService.create(participante);
				msg="Participante cadastrado com sucesso";
					
				
			}else {
				participanteService.merge(participante);
				 msg="Participante atualizado com sucesso";	
				
			}
			
			FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Parabéns!", msg));
			setParticipante(new Participante());
			atualizarParticipantes();
			
		
}
		
		

	public void editarParticipante(Participante participanteAtual) {
		setParticipante(participanteAtual);
		 
	}


	
	public void removerParticipante(Participante participanteAtual) {
		
		String msg="Participante exluída com sucesso";
	 		
		participanteService.remove(participanteAtual);
					atualizarParticipantes();
					FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Parabéns!", msg));
			
		
		
		
	}
	
}
