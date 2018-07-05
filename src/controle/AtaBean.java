package controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import modelo.Ata;
import modelo.Equipe;
import modelo.Funcao;
import modelo.Participante;
import service.AtaService;
import service.FuncaoService;
import service.ParticipanteService;

 
@ViewScoped
@ManagedBean
public class AtaBean {

	
	@EJB
	AtaService ataService;
	
	@EJB
	ParticipanteService participanteService;
	
	@EJB
	FuncaoService funcaoService;
	
	
	private Ata ata = new Ata();
	private Equipe equipe = new Equipe();
	
	
	Long idParticipanteAtual = 0L;	
	Long idFuncaoAtual = 0L;	
	int cronometro=0;
	
	List<Participante> participantes = new ArrayList<Participante>();
	List<Funcao> funcoes = new ArrayList<Funcao>();
	List<Equipe> equipes = new ArrayList<Equipe>();
	
	
	
	
	public AtaService getAtaService() {
		return ataService;
	}

	public void setAtaService(AtaService ataService) {
		this.ataService = ataService;
	}

	public ParticipanteService getParticipanteService() {
		return participanteService;
	}

	public void setParticipanteService(ParticipanteService participanteService) {
		this.participanteService = participanteService;
	}

	public FuncaoService getFuncaoService() {
		return funcaoService;
	}

	public void setFuncaoService(FuncaoService funcaoService) {
		this.funcaoService = funcaoService;
	}

	public Ata getAta() {
		return ata;
	}

	public void setAta(Ata ata) {
		this.ata = ata;
	}

	public Long getIdParticipanteAtual() {
		return idParticipanteAtual;
	}

	public void setIdParticipanteAtual(Long idParticipanteAtual) {
		this.idParticipanteAtual = idParticipanteAtual;
	}

	public Long getIdFuncaoAtual() {
		return idFuncaoAtual;
	}

	public void setIdFuncaoAtual(Long idFuncaoAtual) {
		this.idFuncaoAtual = idFuncaoAtual;
	}

	public List<Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<Participante> participantes) {
		this.participantes = participantes;
	}

	public List<Funcao> getFuncoes() {
		return funcoes;
	}

	public void setFuncoes(List<Funcao> funcoes) {
		this.funcoes = funcoes;
	}
	
		
	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}
	
		
	public int getCronometro() {
		return cronometro;
	}

	public void setCronometro(int cronometro) {
		this.cronometro = cronometro;
	}

	public List<Equipe> getEquipes() {
		return equipes;
	}

	public void setEquipes(List<Equipe> equipes) {
		this.equipes = equipes;
	}

	@PostConstruct
	public void init(){
		setParticipantes(participanteService.listAll());
		setFuncoes(funcaoService.listAll());
		 
	}
	
	
	
	private void adicionarParticipanteEfuncao() {
		
		
		if(idParticipanteAtual==0 || idFuncaoAtual==0){
			FacesContext.getCurrentInstance().addMessage(
					"erro", new FacesMessage("Selecione um Participante ou Função"));
		}else{
			 	
			 	 
			}
		}	



	public void cronometro() {
		cronometro++;
		
		
		
		
	}

}
	
	 
	

