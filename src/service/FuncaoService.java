package service;

import javax.ejb.Stateless;

import modelo.Funcao;

@Stateless
public class FuncaoService extends GenericService<Funcao> {

	public FuncaoService(){
		super(Funcao.class);
	} 

}
