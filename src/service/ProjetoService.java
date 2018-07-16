package service;

import javax.ejb.Stateless;

import modelo.Projeto;

@Stateless
public class ProjetoService extends GenericService<Projeto> {

	public ProjetoService(){
		super(Projeto.class);
	} 

	
	
}
