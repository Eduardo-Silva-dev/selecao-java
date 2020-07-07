package com.indra.apirest.repository;

import java.util.List;

import javax.persistence.Tuple;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.indra.apirest.domain.Coleta;

public interface ColetaRepository extends JpaRepository< Coleta,Long>{
	
	@Query(value = "select r.cnpj,p.bandeira,\r\n" + 
			"p.nome_revenda,p.tipo,p.und_medida,\r\n" + 
			"Round(Avg(pr.valor_compra), 4) AS Media_Valor_Compra ,Round(Avg(pr.valor_venda), 4) AS Media_Valor_Venda ,\r\n" + 
			"e.estado,e.municipio,e.regiao,\r\n" + 
			"c.data_coleta\r\n" + 
			"from Revendedor r \r\n" + 
			"join Produto p on p.revendedo_id = r.id\r\n" + 
			"join Preco pr on pr.produto_id = p.id\r\n" + 
			"join Endereco e on e.revendedor_id = r.id\r\n" + 
			"join Coleta c on c.produto_id = p.id\r\n" + 
			"group by c.data_coleta\r\n" + 
			"order by c.data_coleta",nativeQuery = true)
	List<Tuple> DadosAgrupadosPorDataColeta();

}
