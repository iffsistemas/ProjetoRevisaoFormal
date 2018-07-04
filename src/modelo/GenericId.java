package modelo;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


@MappedSuperclass //para n�o gerar uma tabela, apenas compartilhar a chave prim�ria
public class GenericId {

	@Id @GeneratedValue
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
}
