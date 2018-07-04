package controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import modelo.Funcao;
import service.FuncaoService;

 
@ViewScoped
@ManagedBean
public class FuncaoBean {

	
	@EJB
	FuncaoService funcaoService;
	
	
	private Funcao funcao = new Funcao();
	List<Funcao> funcoes = new ArrayList<Funcao>();
	
		
	public FuncaoService getFuncaoService() {
		return funcaoService;
	}

	public void setFuncaoService(FuncaoService funcaoService) {
		this.funcaoService = funcaoService;
	}

	public Funcao getFuncao() {
		return funcao;
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}

	public List<Funcao> getFuncoes() {
		return funcoes;
	}

	public void setFuncoes(List<Funcao> funcoes) {
		this.funcoes = funcoes;
	}

	
	
	@PostConstruct
	public void init(){
		atualizarFuncoes();
	}
	
	protected void atualizarFuncoes(){
		getFuncoes().clear();
		getFuncoes().addAll(funcaoService.listAll());
	}
	
	
public void salvarFuncao() {
			String msg;
		
			if(getFuncao().getId()==null){ 
				
				funcaoService.create(funcao);
				msg="Funcão cadastrada com sucesso";
					
				
			}else {
				funcaoService.merge(funcao);
				 msg="Funcão atualizada com sucesso";	
				
			}
			
			FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Parabéns!", msg));
			setFuncao(new Funcao());
			atualizarFuncoes();
			
		
}
		
		

	public void editarFuncao(Funcao funcaoAtual) {
		setFuncao(funcaoAtual);
		 
	}


	
	public void removerFuncao(Funcao funcaoAtual) {
		
		String msg="Função exluída com sucesso";
	 		
					funcaoService.remove(funcaoAtual);
					atualizarFuncoes();
					FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Parabéns!", msg));
			
		
		
		
	}
	
}
