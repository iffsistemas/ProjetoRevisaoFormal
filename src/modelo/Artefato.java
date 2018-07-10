package modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Artefato extends GenericId{
	
	private String titulo;
	private String descricao;
	
	@Enumerated(EnumType.ORDINAL)
	private Situacao situacao ;
	
	@OneToMany(mappedBy="artefato")
	private List<AtaReuniao> ataReuniao;
	
	
	@ManyToOne(optional=false)
	private Participante produtor;
	
	//@OneToMany
	//private List<Anexo> anexos;

	
	
	
	public String getDescricao() {
		return descricao;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Situacao getSituacao() {
		
		return situacao;
	}


	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	

	
	public List<AtaReuniao> getAtaReuniao() {
		return ataReuniao;
	}


	public void setAtaReuniao(List<AtaReuniao> ataReuniao) {
		this.ataReuniao = ataReuniao;
	}


	public Participante getProdutor() {
		return produtor;
	}


	public void setProdutor(Participante produtor) {
		this.produtor = produtor;
	}

	
	



	public enum Situacao {
		PEDENTE("Pedente"),
		ACEITO("Aceito"),
		ACEITO_PROVISORIAMENTE("Aceito Provisoriamente"),
		REJEITADO("Rejeitado");

		final String descricao;
	    
		private Situacao(String valor) {
	        this.descricao = valor;
	    }

		public String getDescricao() {
			return descricao;
		}	
		
		public int getOrdinal() {
			return this.ordinal();
		}
	}
	
	
}
