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
import modelo.Projeto;
import service.ParticipanteService;
import service.ProjetoService;

 
@ViewScoped
@ManagedBean
public class ProjetoBean {

	
	@EJB
	ProjetoService projetoService;
	
	
	private Projeto projeto = new Projeto();
	List<Projeto> projetos = new ArrayList<Projeto>();
	
	
		
	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public List<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}

	@PostConstruct
	public void init(){
		atualizarProjetos();
	}
	
	protected void atualizarProjetos(){
		getProjetos().clear();
		getProjetos().addAll(projetoService.listAll());
	}
	
	
public void salvarProjeto() {
			String msg;
		
			if(getProjeto().getId()==null){ 
				
				projetoService.create(projeto);
				msg="Projeto cadastrado com sucesso";
					
				
			}else {
				projetoService.merge(projeto);
				 msg="Projeto atualizado com sucesso";	
				
			}
			
			FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Parabéns!", msg));
			setProjeto(new Projeto());
			atualizarProjetos();
			
		
}
		
		

	public void editarProjeto(Projeto projetoAtual) {
		setProjeto(projetoAtual);
		 
	}


	
	public void removerProjeto(Projeto projetoAtual) {
		
		String msg="Projeto exluído com sucesso";
	 		
		projetoService.remove(projetoAtual);
					atualizarProjetos();
					FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Parabéns!", msg));
			
		
		
	}
	
	public void validarLoginESenha() throws IOException {
		
		FacesContext.getCurrentInstance().getExternalContext().redirect("listaArtefatos.xhtml");
		
		
	}
	
}
