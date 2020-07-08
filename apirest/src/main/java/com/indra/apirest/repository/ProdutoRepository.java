package com.indra.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.indra.apirest.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
