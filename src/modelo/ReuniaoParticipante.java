package modelo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Entity
public class ReuniaoParticipante extends GenericId {
	
	private Boolean assinatura = Boolean.FALSE;
	
	@Enumerated(EnumType.ORDINAL)
	private Funcao funcao;
	
	@ManyToOne
	private Participante participante;
	
	public Boolean getAssinatura() {
		return assinatura;
	}

	public void setAssinatura(Boolean assinatura) {
		this.assinatura = assinatura;
	}

	public Funcao getFuncao() {
		return funcao;
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

	public enum Funcao {
		LIDER_PROJETO("Lider do Projeto"),
		LIDER_REVISAO("Lider da Revisão"),
		PRODUTOR("Produtor"),
		REGISTRADOR("Registrador"),
		REVISOR("Revisor");

		final String descricao;
	    
		private Funcao(String valor) {
	        this.descricao = valor;
	    }

		public String getDescricao() {
			return descricao;
		}
		
		public int getOrdinal() {
			return this.ordinal();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((participante == null) ? 0 : participante.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReuniaoParticipante other = (ReuniaoParticipante) obj;
		if (participante == null) {
			if (other.participante != null)
				return false;
		} else if (!participante.equals(other.participante))
			return false;
		return true;
	}
	
	
}
