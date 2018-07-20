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
	private String local;
	@Lob
	private String registrosProblemas;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHoraInicio = new Date();
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHoraFim = new Date();
	
	private Boolean finalizada = Boolean.FALSE;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Artefato artefato;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="ataReuniao")
	private List<ReuniaoParticipante> reuniaoParticipantes = new ArrayList<ReuniaoParticipante>();
	
	
	private Date duracaoDaReuniao;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
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

	

	public List<ReuniaoParticipante> getReuniaoParticipantes() {
		return reuniaoParticipantes;
	}

	public void setReuniaoParticipantes(List<ReuniaoParticipante> reuniaoParticipantes) {
		this.reuniaoParticipantes = reuniaoParticipantes;
	}

	public Date getDuracaoDaReuniao() {
		return duracaoDaReuniao;
	}

	public void setDuracaoDaReuniao(Date duracaoDaReuniao) {
		this.duracaoDaReuniao = duracaoDaReuniao;
	}
	
	
	
	
	
	
}
