package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import modelo.Artefato;
import modelo.AtaReuniao;
import modelo.ReuniaoParticipante;

@Stateless
public class AtaReuniaoService extends GenericService<AtaReuniao> {

	public AtaReuniaoService(){
		super(AtaReuniao.class);
	} 
	
	public void gravarAtaReuniaoComParticipantes(AtaReuniao ata) {
		for(ReuniaoParticipante part: ata.getReuniaoParticipantes()) {
			getEntityManager().persist(part);
		}
		merge(ata);
	}

	public List<AtaReuniao> listAtasComParticipantes(){
    	final CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();	
    	final CriteriaQuery<AtaReuniao> cQuery = cb.createQuery(AtaReuniao.class);
	
    	cQuery.select(cQuery.from(AtaReuniao.class));

    	List<AtaReuniao> list = getEntityManager().createQuery(cQuery).getResultList();
    	
    	for(AtaReuniao ata: list) {
    		ata.getReuniaoParticipantes().size();
    	}
    		
    		
    	return list;
    }	
	
	public List<AtaReuniao> obtemAtaPorArtefato(Artefato artefato) {
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<AtaReuniao> cquery = cb.createQuery(AtaReuniao.class);
		Root<AtaReuniao> root = cquery.from(AtaReuniao.class);
		
			
		cquery.select(root).where(cb.equal(root.get("artefato"), artefato));
		
		//cquery.orderBy(cb.desc(Artefato.<Long>get("id")));
		
		//cquery.orderBy(cb.desc(cquery.get("id")));
		
		List<AtaReuniao> atas = getEntityManager().createQuery(cquery).getResultList();
		
		return atas;
				
	}
	
	
	
}
