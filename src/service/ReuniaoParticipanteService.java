package service;

import javax.ejb.Stateless;
import modelo.ReuniaoParticipante;

@Stateless
public class ReuniaoParticipanteService extends GenericService<ReuniaoParticipante> {

	public ReuniaoParticipanteService(){
		super(ReuniaoParticipante.class);
	} 

}