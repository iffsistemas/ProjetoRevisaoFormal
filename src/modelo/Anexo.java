package modelo;

import javax.persistence.Entity;
import javax.persistence.Lob;

@Entity
public class Anexo extends GenericId{

	private String descricao;
	@Lob
	private String caminho;
	
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getCaminho() {
		return caminho;
	}
	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
	
	
	
}
