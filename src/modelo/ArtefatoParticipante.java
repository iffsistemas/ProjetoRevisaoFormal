package modelo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import modelo.ReuniaoParticipante.Funcao;

@Entity
public class ArtefatoParticipante extends GenericId {
	
	
	@Enumerated(EnumType.ORDINAL)
	private Funcao funcao;
	
	@ManyToOne
	private Participante participante;
	
	@ManyToOne
	private Artefato artefato;

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
	
	public Artefato getArtefato() {
		return artefato;
	}

	public void setArtefato(Artefato artefato) {
		this.artefato = artefato;
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
		ArtefatoParticipante other = (ArtefatoParticipante) obj;
		if (participante == null) {
			if (other.participante != null)
				return false;
		} else if (!participante.equals(other.participante))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ArtefatoParticipante [funcao=" + funcao + ", participante=" + participante + "]";
	}
	
	
	
}
