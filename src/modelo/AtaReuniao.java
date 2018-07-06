package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class AtaReuniao extends GenericId {

	
	private String titulo;
	@Lob
	private String descricao;
	private String local;
	@Lob
	private String registrosProblemas;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHoraInicio;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHoraFim;
	
	private Boolean finalizada;
	
	@ManyToOne
	private Artefato artefato;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<ReuniaoParticipante> participantes = new ArrayList<ReuniaoParticipante>();

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getRegistrosProblemas() {
		return registrosProblemas;
	}

	public void setRegistrosProblemas(String registrosProblemas) {
		this.registrosProblemas = registrosProblemas;
	}

	public Date getDataHoraInicio() {
		return dataHoraInicio;
	}

	public void setDataHoraInicio(Date dataHoraInicio) {
		this.dataHoraInicio = dataHoraInicio;
	}

	public Date getDataHoraFim() {
		return dataHoraFim;
	}

	public void setDataHoraFim(Date dataHoraFim) {
		this.dataHoraFim = dataHoraFim;
	}

	public Boolean getFinalizada() {
		return finalizada;
	}

	public void setFinalizada(Boolean finalizada) {
		this.finalizada = finalizada;
	}

	public Artefato getArtefato() {
		return artefato;
	}

	public void setArtefato(Artefato artefato) {
		this.artefato = artefato;
	}

	public List<ReuniaoParticipante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<ReuniaoParticipante> participantes) {
		this.participantes = participantes;
	}
	
	
	
	
	
	
}
