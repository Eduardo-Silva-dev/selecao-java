package com.indra.apirest.repository;

import java.util.List;

import javax.persistence.Tuple;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.indra.apirest.domain.Preco;

public interface PrecoRepository  extends CrudRepository<Preco, Long> {
	
	@Query(value = "select e.municipio, Round(Avg(pr.valor_venda), 4) AS VALOR_VENDA from preco pr\r\n" + 
			"join Produto p on p.id = pr.produto_id\r\n" + 
			"join Revendedor r on r.id = p.revendedo_id\r\n" + 
			"join Endereco e on e.revendedor_id = r.id\r\n" + 
			"group by e.municipio",nativeQuery = true)
	List<Tuple> MediaPrecoMunicipio();
}
