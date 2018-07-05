package service;

import javax.ejb.Stateless;

import modelo.Ata;

@Stateless
public class AtaService extends GenericService<Ata> {

	public AtaService(){
		super(Ata.class);
	} 

}
