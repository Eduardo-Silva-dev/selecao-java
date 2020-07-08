package com.indra.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.indra.apirest.domain.Arquivo;

public interface ArquivoRepository  extends JpaRepository<Arquivo,Long>{

}
