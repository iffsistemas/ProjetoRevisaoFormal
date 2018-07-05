package modelo;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Artefato extends GenericId{

	private String nome;
	private String descricaoResumida;
	private String descricaoDetalhada;
	
	
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricaoResumida() {
		return descricaoResumida;
	}
	public void setDescricaoResumida(String descricaoResumida) {
		this.descricaoResumida = descricaoResumida;
	}
	public String getDescricaoDetalhada() {
		return descricaoDetalhada;
	}
	public void setDescricaoDetalhada(String descricaoDetalhada) {
		this.descricaoDetalhada = descricaoDetalhada;
	}
	

	
	
	
	
}
