package controle;

import java.io.IOException;
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
import modelo.Artefato.Situacao;
import modelo.ReuniaoParticipante.Funcao;
import service.AtaReuniaoService;
import service.ParticipanteService;
import service.ReuniaoParticipanteService;

 
@ViewScoped
@ManagedBean
public class AtaReuniaoBean {

	
	@EJB
	AtaReuniaoService ataReuniaoService;	
	@EJB
	ParticipanteService participanteService;
	@EJB
	ReuniaoParticipanteService reuniaoparticipanteService;
	
	private Date dataCronometro = new Date();
	
	private AtaReuniao ata = new AtaReuniao();
	
	AtaReuniao ataSelecionada = new AtaReuniao();
	
	private Artefato artefato = new Artefato();
	
	Integer idSituacaoAtual = 0;
	
	Long idParticipanteAtual = 0L;	
	Integer idFuncaoAtual = 0;	
	String senhaAssinatura;
	boolean assinatura = Boolean.FALSE;
	
	List<Participante> participantes = new ArrayList<Participante>();
	
	List<Participante> assinaturas = new ArrayList<Participante>();
		
	private String tituloArtefato;
	
	ReuniaoParticipante reuniaoParticipante = new ReuniaoParticipante();
	
	
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
	
	
	
	public String getTituloArtefato() {
		return tituloArtefato;
	}

	public void setTituloArtefato(String tituloArtefato) {
		this.tituloArtefato = tituloArtefato;
	}
	
	
	public ReuniaoParticipante getReuniaoParticipante() {
		return reuniaoParticipante;
	}

	public void setReuniaoParticipante(ReuniaoParticipante reuniaoParticipante) {
		this.reuniaoParticipante = reuniaoParticipante;
	}
	
	
	

	public AtaReuniao getAtaSelecionada() {
		return ataSelecionada;
	}

	public void setAtaSelecionada(AtaReuniao ataSelecionada) {
		this.ataSelecionada = ataSelecionada;
	}
	
	
	public Artefato getArtefato() {
		return artefato;
	}

	public void setArtefato(Artefato artefato) {
		this.artefato = artefato;
	}

	public Integer getIdSituacaoAtual() {
		return idSituacaoAtual;
	}

	public void setIdSituacaoAtual(Integer idSituacaoAtual) {
		this.idSituacaoAtual = idSituacaoAtual;
	}
	
	public List<Situacao> getSituacoes(){
		List<Situacao> situacoes = Arrays.asList(Situacao.values());
		return situacoes;
	}	
	
	public String getSenhaAssinatura() {
		return senhaAssinatura;
	}

	public void setSenhaAssinatura(String senhaAssinatura) {
		this.senhaAssinatura = senhaAssinatura;
	}
	
	
	public boolean isAssinatura() {
		return assinatura;
	}

	public void setAssinatura(boolean assinatura) {
		this.assinatura = assinatura;
	}
	
	 
	public List<Participante> getAssinaturas() {
		return assinaturas;
	}

	public void setAssinaturas(List<Participante> assinaturas) {
		this.assinaturas = assinaturas;
	}

	@PostConstruct
	public void init(){
		setParticipantes(participanteService.listAll());
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.HOUR_OF_DAY, 2);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		setDataCronometro(cal.getTime());
		
		Artefato artefatoEnviado = (Artefato) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("artefatoEnviado");
		getAta().setArtefato(artefatoEnviado);
		setTituloArtefato(artefatoEnviado.getTitulo()); 
		
		getAta().setDataHoraInicio(new Date());
				
	}
	
	
	
	
	
	
	public void salvarAta() throws IOException {
		String msg="Ata gravada com sucesso";
	try {
		
		if(getAta().getId()==null){ 
			getAta().setDataHoraFim(new Date());
			getAta().setFinalizada(Boolean.TRUE);
			getAta().getArtefato().setSituacao(Situacao.values()[idSituacaoAtual]);
			//getAta().setDuracaoDaReuniao(ata.getDataHoraFim() - ata.getDataHoraInicio());
			ataReuniaoService.gravarAtaReuniaoComParticipantes(ata);
			setAta(new AtaReuniao());
			FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Parabéns!", msg));
			
			
	}
		
	} catch (RuntimeException erro) {
		FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("ERRO!", "Ocorreu um erro Inesperado"));
		erro.printStackTrace();
				
	}	}
	
	public void adicionarParticipanteEfuncao() {		
		
		if(idParticipanteAtual==0){
			FacesContext.getCurrentInstance().addMessage(
					"erro", new FacesMessage("Selecione um Participante"));
		}else{
			Participante partAtual = participanteService.obtemPorId(idParticipanteAtual);
			ReuniaoParticipante reuniaoPart = new ReuniaoParticipante();
		 	reuniaoPart.setParticipante(partAtual);
		 	reuniaoPart.setFuncao(Funcao.values()[idFuncaoAtual]);
				if(!getAta().getParticipantes().contains(reuniaoPart)) {
				 	getAta().getParticipantes().add(reuniaoPart); 
				}else {
					FacesContext.getCurrentInstance().addMessage(
							"erro", new FacesMessage("Participante já selecionado"));
			}
				}
		}	


	
	public void removerParticipanteEfuncao(Participante partAtual) {
		
		
		//getParticipantes().remove(partAtual);
		
		
		
		 
		
		
		FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Parabéns!", "Participante Excluído com Sucesso"));
		
		
	}

	public void incrementar() {
		Calendar cal = new GregorianCalendar();
		cal.setTime(getDataCronometro());
		cal.set(Calendar.SECOND,cal.get(Calendar.SECOND)-1);
		setDataCronometro(cal.getTime());
	}
	

	public void carregarProdutorAtefato(Artefato artefato) {
		Participante partAtual = participanteService.obtemPorId(artefato.getProdutor().getId());
		reuniaoParticipante.setParticipante(partAtual);
	 	reuniaoParticipante.setFuncao(Funcao.PRODUTOR);
	 	getAta().getParticipantes().add(reuniaoParticipante);
	}
	
	
	
	public void validarAssinatura() {
				
		Participante participanteAssinante = participanteService.obtemPorId(idParticipanteAtual);
		
		for (Participante p: participantes) {
			
			if(p.getNome().equals(participanteAssinante.getNome()) && senhaAssinatura.equals(participanteAssinante.getSenha())) {
				
				setAssinatura(Boolean.TRUE);
			}
		
		}
		
			if(assinatura) {
				
				assinaturas.add(participanteAssinante);
				FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Parabéns!", "Assinado!"));	
				setAssinatura(Boolean.FALSE);
				
			}else {
				FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Não assinado!", "Senha Incorreta! Tente novamente."));
				
			}
				
			
			setSenhaAssinatura("");
			
			
				
	}
	
	
	
	
	
	
	
	
	
	

}
	
	 
	

