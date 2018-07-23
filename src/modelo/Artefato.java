package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Artefato extends GenericId{
	
	private String titulo;
	private String descricao;
	
	@Enumerated(EnumType.ORDINAL)
	private Situacao situacao ;
	
	@OneToOne
	private Categoria categoria ;
	
	@OneToMany(mappedBy="artefato")
	private List<AtaReuniao> ataReuniao;
	
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="artefato")
	private List<ArtefatoParticipante> artefatoParticipantes = new ArrayList<ArtefatoParticipante>();
	
	
	@ManyToOne(optional=false)
	private Projeto projeto;
	
	//@OneToMany
	//private List<Anexo> anexos;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Anexo anexo;
	
	@Transient
	private String caminho;
	
	
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

		
	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	public List<AtaReuniao> getAtaReuniao() {
		return ataReuniao;
	}


	public void setAtaReuniao(List<AtaReuniao> ataReuniao) {
		this.ataReuniao = ataReuniao;
	}
	
	public List<ArtefatoParticipante> getArtefatoParticipantes() {
		return artefatoParticipantes;
	}


	public void setArtefatoParticipantes(List<ArtefatoParticipante> artefatoParticipantes) {
		this.artefatoParticipantes = artefatoParticipantes;
	}


	public Projeto getProjeto() {
		return projeto;
	}


	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
	
	
	public Anexo getAnexo() {
		return anexo;
	}


	public void setAnexo(Anexo anexo) {
		this.anexo = anexo;
	}


	public String getCaminho() {
		return caminho;
	}


	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}






	public enum Situacao {
		NAO_REVISADO("Não Revisado"),
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
	
	
	
	
	/*
	
	public enum Categoria {
		ESCOPO_DO_PROJETO("Escopo do Projeto"),
		DOCUMENTOS_REQUISITOS("Documentos de Requisitos"),
		CODIGO_FONTE("Código Fonte"),
		CASO_DE_TESTE("Caso de Teste"),
		CASO_DE_USO("Caso de Uso");
		

		final String descricao;
	    
		private Categoria(String valor) {
	        this.descricao = valor;
	    }

		public String getDescricao() {
			return descricao;
		}	
		
		public int getOrdinal() {
			return this.ordinal();
		}
	}
	
	*/
	
	
}
