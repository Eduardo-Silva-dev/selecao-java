package com.indra.apirest.repository;

import java.util.List;

import javax.persistence.Tuple;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.indra.apirest.domain.Preco;

public interface PrecoRepository  extends JpaRepository<Preco, Long> {
	
	@Query(value = "select e.municipio, Round(Avg(pr.valor_venda), 4) AS VALOR_VENDA " +
			"from preco pr\r\n" + 
			"join Produto p on p.id = pr.produto_id\r\n" + 
			"join Revendedor r on r.id = p.revendedo_id\r\n" + 
			"join Endereco e on e.revendedor_id = r.id\r\n" + 
			"group by e.municipio",nativeQuery = true)
	List<Tuple> MediaPrecoMunicipio();
	
	@Query(value = "select e.municipio,\r\n" + 
			"Round(Avg(pr.valor_compra), 4) AS Media_Valor_Compra,\r\n" + 
			"Round(Avg(pr.valor_venda), 4) AS Media_Valor_Venda\r\n" + 
			"from preco pr\r\n" + 
			"join Produto p on p.id = pr.produto_id\r\n" + 
			"join Revendedor r on r.id = p.revendedo_id\r\n" + 
			"join Endereco e on e.revendedor_id = r.id\r\n" + 
			"group by e.municipio\r\n" + 
			"order by e.municipio ASC",nativeQuery = true)
	List<Tuple>  ValorMedioValorCompraValorVendaMunicipio();
	
	@Query(value = "select p.bandeira,\r\n" + 
			"Round(Avg(pr.valor_compra), 4) AS Media_Valor_Compra,\r\n" + 
			"Round(Avg(pr.valor_venda), 4) AS Media_Valor_Venda\r\n" + 
			"from preco pr\r\n" + 
			"join Produto p on p.id = pr.produto_id\r\n" + 
			"join Revendedor r on r.id = p.revendedo_id\r\n" + 
			"group by p.bandeira\r\n" + 
			"order by p.bandeira ASC",nativeQuery = true)
	List<Tuple>  ValorMedioValorCompraValorVendaBandeira();
}
