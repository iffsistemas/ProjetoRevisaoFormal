package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import modelo.Artefato;
import modelo.AtaReuniao;

@Stateless
public class ArtefatoService extends GenericService<Artefato> {

	public ArtefatoService(){
		super(Artefato.class);
	} 

	
		
	public List<AtaReuniao> obtemAtaPorArtefato(Artefato artefato) {
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<AtaReuniao> cquery = cb.createQuery(AtaReuniao.class);
		Root<AtaReuniao> root = cquery.from(AtaReuniao.class);
		
			
		cquery.select(root).where(cb.equal(root.get("artefato"), artefato));
		
		//cquery.orderBy(cb.desc(Artefato.<Long>get("id")));
		
		List<AtaReuniao> atas = getEntityManager().createQuery(cquery).getResultList();
		
		return atas;
				
	}
	
	
	
}
