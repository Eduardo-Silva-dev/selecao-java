package com.indra.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.indra.apirest.domain.Endereco;

public interface EnderecoRepository  extends JpaRepository<Endereco, Long> {
	

}
