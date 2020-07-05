package com.indra.apirest.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.indra.apirest.domain.Preco;

public interface PrecoRepository  extends CrudRepository<Preco, Long> {
	
	@Query(value = "SELECT * FROM Preco p \n" + 
			"JOIN Produto d ON ( d.id = p.produto_id ) \n" + 
			"JOIN Endereco e ON (e.revendedor_id = d.revendedo_id)" + 
			"GROUP  BY e.municipio ",nativeQuery = true)
	String MediaPrecoMunicipio(String muni);
}
