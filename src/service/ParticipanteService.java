package service;

import javax.ejb.Stateless;

import modelo.Participante;

@Stateless
public class ParticipanteService extends GenericService<Participante> {

	public ParticipanteService(){
		super(Participante.class);
	} 

}
