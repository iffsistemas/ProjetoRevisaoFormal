package modelo;

import javax.persistence.Entity;

@Entity
public class Projeto extends GenericId {
	
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
