package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import modelo.Artefato;

@Stateless
public class ArtefatoService extends GenericService<Artefato> {

	public ArtefatoService(){
		super(Artefato.class);
	} 

	
	
	public List<Artefato> obtemArtefatosPorBuscas(Long categoria, Long projeto) {
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Artefato> cquery = cb.createQuery(Artefato.class);
		Root<Artefato> root = cquery.from(Artefato.class);
			
		cquery.where(cb.and(cb.equal(root.get("categoria").get("id"), categoria), cb.equal(root.get("projeto").get("id"), projeto)));
		
		List<Artefato> artefatos = getEntityManager().createQuery(cquery).getResultList();
		
		return artefatos;
				
	}
	
	public List<Artefato> obtemArtefatosPorSituacao(Integer situacao) {
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Artefato> cquery = cb.createQuery(Artefato.class);
		Root<Artefato> root = cquery.from(Artefato.class);
			
		cquery.select(root).where(cb.equal(root.get("situacao"), situacao));
		
		List<Artefato> artefatos = getEntityManager().createQuery(cquery).getResultList();
		
		return artefatos;
				
	}
	
	public List<Artefato> listarTodosArtefatosComParticipantes() {
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Artefato> cquery = cb.createQuery(Artefato.class);
		
		List<Artefato> artefatos = getEntityManager().createQuery(cquery).getResultList();
		
		for(Artefato art: artefatos) {
			art.getArtefatoParticipantes().size();
		}
		
		return artefatos;
		
	}
	
	
	public Artefato obtemParticipantesDeUmArtefato(Artefato artefato) {
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Artefato> cquery = cb.createQuery(Artefato.class);
		Root<Artefato> root = cquery.from(Artefato.class);
		
		
		cquery.select(root).where(cb.equal(root, artefato));
		
		Artefato artefatoComParticipantes = getEntityManager().createQuery(cquery).getSingleResult();
		
		artefatoComParticipantes.getArtefatoParticipantes().size();
		
		return artefatoComParticipantes;
	}
	
	
	
}
