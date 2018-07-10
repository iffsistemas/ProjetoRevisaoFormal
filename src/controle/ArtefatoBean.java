package controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import modelo.Artefato;
import modelo.Artefato.Situacao;
import modelo.AtaReuniao;
import modelo.Participante;
import service.ArtefatoService;
import service.ParticipanteService;



@ViewScoped
@ManagedBean
public class ArtefatoBean {
	
	@EJB
	ArtefatoService artefatoService;

	@EJB
	ParticipanteService participanteService;
	
	List<Participante> participantes = new ArrayList<Participante>();
	
	private Artefato artefato = new Artefato();
	
	private List<Artefato> artefatos = new ArrayList<Artefato>();
	
	Long idParticipanteAtual = 0L;	
	
	Integer idSituacaoAtual = 0;
	
	Artefato artefatoSelecionado = new Artefato();
	
	AtaReuniao ataReuniaoSelecionada = new AtaReuniao();
	
	private List<AtaReuniao> atas = new ArrayList<AtaReuniao>();
	

	public Artefato getArtefato() {
		return artefato;
	}

	public void setArtefato(Artefato artefato) {
		this.artefato = artefato;
	}

	public List<Artefato> getArtefatos() {
		return artefatos;
	}

	public void setArtefatos(List<Artefato> artefatos) {
		this.artefatos = artefatos;
	}
	
	
	
	public ArtefatoService getArtefatoService() {
		return artefatoService;
	}

	public void setArtefatoService(ArtefatoService artefatoService) {
		this.artefatoService = artefatoService;
	}

	public ParticipanteService getParticipanteService() {
		return participanteService;
	}

	public void setParticipanteService(ParticipanteService participanteService) {
		this.participanteService = participanteService;
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
	

	public List<Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<Participante> participantes) {
		this.participantes = participantes;
	}

	public Long getIdParticipanteAtual() {
		return idParticipanteAtual;
	}

	public void setIdParticipanteAtual(Long idParticipanteAtual) {
		this.idParticipanteAtual = idParticipanteAtual;

	}
	
	
	public Artefato getArtefatoSelecionado() {
		return artefatoSelecionado;
	}

	public void setArtefatoSelecionado(Artefato artefatoSelecionado) {
		this.artefatoSelecionado = artefatoSelecionado;
	}
	
	
	public List<AtaReuniao> getAtas() {
		return atas;
	}

	public void setAtas(List<AtaReuniao> atas) {
		this.atas = atas;
	}
	
	
	public AtaReuniao getAtaReuniaoSelecionada() {
		return ataReuniaoSelecionada;
	}

	public void setAtaReuniaoSelecionada(AtaReuniao ataReuniaoSelecionada) {
		this.ataReuniaoSelecionada = ataReuniaoSelecionada;
	}

	@PostConstruct
	public void init(){
		setParticipantes(participanteService.listAll());
		setArtefatos(artefatoService.listAll());
		atualizarArtefatos();
		
		
	
		
	}
	
	protected void atualizarArtefatos(){
		getArtefatos().clear();
		getArtefatos().addAll(artefatoService.listAll());
	}
	
	
	
	
	
	
	public void salvarArtefato() throws IOException {
		String msg;
	
		if(getArtefato().getId()==null){ 
			Participante partAtual = participanteService.obtemPorId(idParticipanteAtual);
			artefato.setProdutor(partAtual);
			artefato.setSituacao(Situacao.values()[idSituacaoAtual]);
			artefatoService.create(artefato);
			msg="Artefato cadastrado com sucesso";
			setArtefato(new Artefato());
			FacesContext.getCurrentInstance().getExternalContext().redirect("listaArtefatos.xhtml");
				
			
		}else {
			artefatoService.merge(artefato);
			 msg="Artefato atualizado com sucesso";	
			
		}
		
		FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Parab�ns!", msg));
		setArtefato(new Artefato());
		atualizarArtefatos();
		
	
}
	
	public void adicionarProdutor() {		
		
		if(idParticipanteAtual==0){
			FacesContext.getCurrentInstance().addMessage(
					"erro", new FacesMessage("Selecione um Participante"));
		}else{
			Participante partAtual = participanteService.obtemPorId(idParticipanteAtual);
			artefato.setProdutor(partAtual);
				FacesContext.getCurrentInstance().addMessage(
					"erro", new FacesMessage("Produtor escolhido com sucesso"));
		 		} 
					
			}
				
	
	public void excluirArtefato(Artefato artefato) {
		String msg="Artefato exlu�do com sucesso";
 		
		try {
				artefatoService.remove(artefato);
				atualizarArtefatos();
				FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Parab�ns!", msg));
		} catch (RuntimeException erro) {
				FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("ERRO!", "Ocorreu um erro Inesperado"));
				erro.printStackTrace();
					
		}	
	
	}
	
	
	public void chamarNovaAta() throws IOException {
	    FacesContext.getCurrentInstance().getExternalContext().getFlash().put("artefatoEnviado", artefatoSelecionado);
		FacesContext.getCurrentInstance().getExternalContext().redirect("ata.xhtml");

	}
	
	public void carregarAtas() {
				
				atas.clear();
				atas.addAll(artefatoService.obtemAtaPorArtefato(artefatoSelecionado));
	}
	

}
