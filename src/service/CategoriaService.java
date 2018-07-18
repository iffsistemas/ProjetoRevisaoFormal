package service;

import javax.ejb.Stateless;

import modelo.Categoria;

@Stateless
public class CategoriaService extends GenericService<Categoria> {

	public CategoriaService(){
		super(Categoria.class);
	} 

	
	
}
