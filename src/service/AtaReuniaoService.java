package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import modelo.AtaReuniao;
import modelo.Participante;
import modelo.ReuniaoParticipante;

@Stateless
public class AtaReuniaoService extends GenericService<AtaReuniao> {

	public AtaReuniaoService(){
		super(AtaReuniao.class);
	} 
	
	public void gravarAtaReuniaoComParticipantes(AtaReuniao ata) {
		for(ReuniaoParticipante part: ata.getParticipantes()) {
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
    		ata.getParticipantes().size();
    	}
    		
    		
    	return list;
    }	
	
	
	
}
