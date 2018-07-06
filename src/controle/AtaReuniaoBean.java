package controle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import modelo.Artefato;
import modelo.AtaReuniao;
import modelo.Participante;
import modelo.ReuniaoParticipante;
import modelo.ReuniaoParticipante.Funcao;
import service.AtaReuniaoService;
import service.ParticipanteService;
import service.ReuniaoParticipanteService;

 
@ViewScoped
@ManagedBean
public class AtaReuniaoBean {

	
	@EJB
	AtaReuniaoService ataService;	
	@EJB
	ParticipanteService participanteService;
	@EJB
	ReuniaoParticipanteService reuniaoparticipanteService;
	
	private Date dataCronometro = new Date();
	
	private AtaReuniao ata = new AtaReuniao();
	Long idParticipanteAtual = 0L;	
	Integer idFuncaoAtual = 0;	
	
	List<Participante> participantes = new ArrayList<Participante>();
	
	public AtaReuniao getAta() {
		return ata;
	}

	public void setAta(AtaReuniao ata) {
		this.ata = ata;
	}

	public Long getIdParticipanteAtual() {
		return idParticipanteAtual;
	}

	public void setIdParticipanteAtual(Long idParticipanteAtual) {
		this.idParticipanteAtual = idParticipanteAtual;
	}

	public Integer getIdFuncaoAtual() {
		return idFuncaoAtual;
	}

	public void setIdFuncaoAtual(Integer idFuncaoAtual) {
		this.idFuncaoAtual = idFuncaoAtual;
	}

	public List<Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<Participante> participantes) {
		this.participantes = participantes;
	}
	
	

	public Date getDataCronometro() {
		return dataCronometro;
	}

	public void setDataCronometro(Date dataCronometro) {
		this.dataCronometro = dataCronometro;
	}

	public List<Funcao> getFuncoes(){
		List<Funcao> lista = Arrays.asList(Funcao.values());
		return lista;
	}	
	
	@PostConstruct
	public void init(){
		setParticipantes(participanteService.listAll());
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.HOUR_OF_DAY, 2);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		setDataCronometro(cal.getTime());
		
		
	}
	
	
	
	public void adicionarParticipanteEfuncao() {		
		
		if(idParticipanteAtual==0){
			FacesContext.getCurrentInstance().addMessage(
					"erro", new FacesMessage("Selecione um Participante ou Função"));
		}else{
			Participante partAtual = participanteService.obtemPorId(idParticipanteAtual);
			ReuniaoParticipante reuniaoPart = new ReuniaoParticipante();
		 	reuniaoPart.setParticipante(partAtual);
		 	reuniaoPart.setFuncao(Funcao.values()[idFuncaoAtual]);
				if(getAta().getParticipantes().contains(reuniaoPart)) {
				 	getAta().getParticipantes().add(reuniaoPart); 
				}else {
					FacesContext.getCurrentInstance().addMessage(
							"erro", new FacesMessage("Participante já selecionado"));
				}
			}
		}	



	public void incrementar() {
		Calendar cal = new GregorianCalendar();
		cal.setTime(getDataCronometro());
		cal.set(Calendar.SECOND,cal.get(Calendar.SECOND)-1);
		setDataCronometro(cal.getTime());
	}
	

	public void carregarProdutorAtefato(Artefato artefato) {
		Participante partAtual = participanteService.obtemPorId(artefato.getProdutor().getId());
		ReuniaoParticipante reuniaoPart = new ReuniaoParticipante();
	 	reuniaoPart.setParticipante(partAtual);
	 	reuniaoPart.setFuncao(Funcao.PRODUTOR);
	 	getAta().getParticipantes().add(reuniaoPart);
	}

}
	
	 
	

