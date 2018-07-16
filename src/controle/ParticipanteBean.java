package controle;

import java.io.IOException;
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
	
	private String login;
	private String senha;
	private String confirmarSenha;
	private Boolean achouParticipante = Boolean.FALSE;
	
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
	
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}
	
	
	public Boolean getAchouParticipante() {
		return achouParticipante;
	}

	public void setAchouParticipante(Boolean achouParticipante) {
		this.achouParticipante = achouParticipante;
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
		
			if(participante.getSenha().equals(confirmarSenha)) {
			
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
			
			}else {
				
				FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Atenção!", "Senhas não coincidem."));
				
			}
		
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
	
	public void validarLoginESenha() throws IOException {
		
		if (login.equals("admin") && (senha.equals("admin"))) {
				setAchouParticipante(Boolean.TRUE);
			
		}else {
			
			for (Participante p: participantes) {
			
			if(login.equals(p.getNome()) && senha.equals(p.getSenha())) {
				
				setAchouParticipante(Boolean.TRUE);
			}
			
			}
		}	
			
			if(!getAchouParticipante()) {
			
				FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("ERRO!!", "Usuario e/ou Senha incorretos"));
			 				
			}else {
				
				FacesContext.getCurrentInstance().getExternalContext().redirect("listaArtefatos.xhtml");
			
			}
			
			
	
		
		
		
		
		
		
		
	}
	
}
