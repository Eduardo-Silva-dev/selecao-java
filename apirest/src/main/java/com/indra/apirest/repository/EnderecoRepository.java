package com.indra.apirest.repository;

import java.util.List;

import javax.persistence.Tuple;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.indra.apirest.domain.Endereco;

public interface EnderecoRepository  extends JpaRepository<Endereco, Long> {
	

}
