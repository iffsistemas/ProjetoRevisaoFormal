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

import org.primefaces.event.FileUploadEvent;

import modelo.Artefato;
import modelo.Artefato.Situacao;
import modelo.ArtefatoParticipante;
import modelo.AtaReuniao;
import modelo.Categoria;
import modelo.Participante;
import modelo.Projeto;
import modelo.ReuniaoParticipante.Funcao;
import service.ArtefatoService;
import service.CategoriaService;
import service.ParticipanteService;
import service.ProjetoService;



@ViewScoped
@ManagedBean
public class ArtefatoBean {
	
	@EJB
	ArtefatoService artefatoService;
	@EJB
	ParticipanteService participanteService;
	@EJB
	ProjetoService projetoService;
	@EJB
	CategoriaService categoriaService;
	
	
	private Artefato artefato = new Artefato();
	private Artefato artefatoSelecionado = new Artefato();
	private AtaReuniao ataReuniaoSelecionada = new AtaReuniao();
	private ArtefatoParticipante artefatoParticipante = new ArtefatoParticipante();
	
	private List<Participante> participantes = new ArrayList<Participante>();
	private List<Projeto> projetos = new ArrayList<Projeto>();
	private List<Categoria> categorias = new ArrayList<Categoria>();
	private List<Artefato> artefatos = new ArrayList<Artefato>();
	private List<AtaReuniao> atas = new ArrayList<AtaReuniao>();
	
	
	Long idParticipanteAtual = 0L;	
	Long idProjetoAtual = 0L;
	Long idCategoriaAtual= 0L;
	Integer idSituacaoAtual = 0;
	Integer idFuncaoAtual = 0;
	
	

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
	
	/*
	public List<Categoria> getCategorias(){
		List<Categoria> categorias = Arrays.asList(Categoria.values());
		return categorias;
	}	
*/
	
	public List<Funcao> getFuncoes(){
		List<Funcao> lista = Arrays.asList(Funcao.values());
		return lista;
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
	
	
	public Long getIdProjetoAtual() {
		return idProjetoAtual;
	}

	public void setIdProjetoAtual(Long idProjetoAtual) {
		this.idProjetoAtual = idProjetoAtual;
	}
	
	
	public List<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}
	
	
	public Long getIdCategoriaAtual() {
		return idCategoriaAtual;
	}

	public void setIdCategoriaAtual(Long idCategoriaAtual) {
		this.idCategoriaAtual = idCategoriaAtual;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
		
	public Integer getIdFuncaoAtual() {
		return idFuncaoAtual;
	}

	public void setIdFuncaoAtual(Integer idFuncaoAtual) {
		this.idFuncaoAtual = idFuncaoAtual;
	}
	
	
	public ArtefatoParticipante getArtefatoParticipante() {
		return artefatoParticipante;
	}

	public void setArtefatoParticipante(ArtefatoParticipante artefatoParticipante) {
		this.artefatoParticipante = artefatoParticipante;
	}

	@PostConstruct
	public void init(){
		setParticipantes(participanteService.listAll());
		setProjetos(projetoService.listAll());
		setCategorias(categoriaService.listAll());
		//atualizarArtefatos();
		
		
	
		
	}
	
	protected void atualizarArtefatos(){
		getArtefatos().clear();
		getArtefatos().addAll(artefatoService.listAll());
	}
		
	public void salvarArtefato() throws IOException {
		String msg;
	
		if(getArtefato().getId()==null){ 
			//Participante partAtual = participanteService.obtemPorId(idParticipanteAtual);
			Projeto projAtual = projetoService.obtemPorId(idProjetoAtual);
			Categoria catAtual = categoriaService.obtemPorId(idCategoriaAtual);
			artefato.setProjeto(projAtual);
			artefato.setCategoria(catAtual);
			//artefato.setCategoria(Categoria.values()[idCategoriaAtual]);
			//artefato.setProdutor(partAtual);
			artefato.setSituacao(Situacao.values()[idSituacaoAtual]);
			artefatoService.create(artefato);
			msg="Artefato cadastrado com sucesso";
			setArtefato(new Artefato());
			FacesContext.getCurrentInstance().getExternalContext().redirect("listaArtefatos.xhtml");
				
			
		}else {
			artefatoService.merge(artefato);
			 msg="Artefato atualizado com sucesso";	
			
		}
		
		FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Parabéns!", msg));
		setArtefato(new Artefato());
		atualizarArtefatos();
		
	
}
	
	/*
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
				
	*/
	
	
	
	
	public void adicionarParticipanteEfuncao() {		
		
		if(idParticipanteAtual==0){
			FacesContext.getCurrentInstance().addMessage(
					"erro", new FacesMessage("Selecione um Participante"));
		}else{
			Participante partAtual = participanteService.obtemPorId(idParticipanteAtual);
			ArtefatoParticipante artefatoPart = new ArtefatoParticipante();
			artefatoPart.setParticipante(partAtual);
			artefatoPart.setFuncao(Funcao.values()[idFuncaoAtual]);
				if(!getArtefato().getArtefatoParticipantes().contains(artefatoPart)) {
					artefatoPart.setArtefato(getArtefato());
					getArtefato().getArtefatoParticipantes().add(artefatoPart); 
				}else {
					FacesContext.getCurrentInstance().addMessage(
							"erro", new FacesMessage("Participante já selecionado"));
			}
				}
		}	
	
	public void excluirArtefato(Artefato artefato) {
		String msg="Artefato exluído com sucesso";
 		
		try {
				artefatoService.remove(artefato);
				atualizarArtefatos();
				FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Parabéns!", msg));
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
				//atas.addAll(ataService.obtemAtaPorArtefato(artefatoSelecionado));
	}
	
	
	public void filtrarArtefatos() {
		getArtefatos().clear();
		getArtefatos().addAll(artefatoService.obtemArtefatosPorBuscas(idCategoriaAtual,idProjetoAtual));
	}
	
	
	public void handleFileUpload(FileUploadEvent event) {
		System.out.println("teste");
		System.out.println(event.getFile().getFileName());
		
	}
	

}
