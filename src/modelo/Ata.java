package modelo;

import javax.persistence.Entity;

@Entity
public class Ata extends GenericId {
	
	private String cronometro;

	public String getCronometro() {
		return cronometro;
	}

	public void setCronometro(String cronometro) {
		this.cronometro = cronometro;
	}

	
	
	

}
