package com.indra.apirest.repository;

import java.util.List;

import javax.persistence.Tuple;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.indra.apirest.domain.Revendedor;


public interface RevendedorRepository  extends JpaRepository<Revendedor, Long> {
	
	
	@Query(value = "select r.cnpj,p.bandeira,\r\n" + 
			"	p.nome_revenda,p.tipo,p.und_medida,\r\n" + 
			"	Round(Avg(pr.valor_compra), 4) AS Media_Valor_Compra ,"+
			"   Round(Avg(pr.valor_venda), 4) AS Media_Valor_Venda ,\r\n" + 
			"	e.estado,e.municipio,e.regiao,\r\n" + 
			"	c.data_coleta\r\n" + 
			"	from Revendedor r \r\n" + 
			"	join Produto p on p.revendedo_id = r.id\r\n" + 
			"	join Preco pr on pr.produto_id = p.id\r\n" + 
			"	join Endereco e on e.revendedor_id = r.id\r\n" + 
			"	join Coleta c on c.produto_id = p.id\r\n" + 
			"	group by e.regiao\r\n" + 
			"	order by r.cnpj",nativeQuery = true)
	List<Tuple>  informacoesImportadasSiglaRegiao();
	
	@Query(value = "select r.cnpj,p.bandeira,\r\n" + 
			"p.nome_revenda,p.tipo,p.und_medida,\r\n" + 
			"Round(Avg(pr.valor_compra), 4) AS Media_Valor_Compra ,"+
			"Round(Avg(pr.valor_venda), 4) AS Media_Valor_Venda ,\r\n" + 
			"e.estado,e.municipio,e.regiao,\r\n" + 
			"c.data_coleta\r\n" + 
			"from Revendedor r \r\n" + 
			"join Produto p on p.revendedo_id = r.id\r\n" + 
			"join Preco pr on pr.produto_id = p.id\r\n" + 
			"join Endereco e on e.revendedor_id = r.id\r\n" + 
			"join Coleta c on c.produto_id = p.id\r\n" + 
			"group by p.nome_revenda\r\n" + 
			"order by p.nome_revenda",nativeQuery = true)
	List<Tuple> DadosAgrupadosDataDistribuidora();
}
