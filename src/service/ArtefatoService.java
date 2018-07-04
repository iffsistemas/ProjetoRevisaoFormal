package service;

import javax.ejb.Stateless;

import modelo.Artefato;

@Stateless
public class ArtefatoService extends GenericService<Artefato> {

	public ArtefatoService(){
		super(Artefato.class);
	} 

}
