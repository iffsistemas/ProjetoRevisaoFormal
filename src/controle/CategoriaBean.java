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

import modelo.Categoria;
import service.CategoriaService;

 
@ViewScoped
@ManagedBean
public class CategoriaBean {

	
	@EJB
	CategoriaService categoriaService;
	
	
	private Categoria categoria = new Categoria();
	List<Categoria> categorias = new ArrayList<Categoria>();
	

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	@PostConstruct
	public void init(){
		atualizarCategorias();
	}
	
	protected void atualizarCategorias(){
		getCategorias().clear();
		getCategorias().addAll(categoriaService.listAll());
	}
	
	public void salvarCategoria() {
	String msg;	
		if(getCategoria().getId()==null){ 
			categoriaService.create(categoria);
			msg="Categoria cadastrado com sucesso";
		}else {
			categoriaService.merge(categoria);
			 msg="Categoria atualizado com sucesso";	
		}
		
		FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Parabéns!", msg));
		setCategoria(new Categoria());
		atualizarCategorias();
	}
	
	

	public void editarCategoria(Categoria categoriaAtual) {
	setCategoria(categoriaAtual);
	 
	}

	public void removerCategoria(Categoria categoriaAtual) {
	
	String msg="Categoria exluído com sucesso";
 		
	categoriaService.remove(categoriaAtual);
				atualizarCategorias();
				FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Parabéns!", msg));

	}

public void validarLoginESenha() throws IOException {
	
	FacesContext.getCurrentInstance().getExternalContext().redirect("listaArtefatos.xhtml");
	
	
}

}
