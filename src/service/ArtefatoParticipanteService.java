package service;

import javax.ejb.Stateless;

import modelo.ArtefatoParticipante;

@Stateless
public class ArtefatoParticipanteService extends GenericService<ArtefatoParticipante> {

	public ArtefatoParticipanteService(){
		super(ArtefatoParticipante.class);
	} 

}