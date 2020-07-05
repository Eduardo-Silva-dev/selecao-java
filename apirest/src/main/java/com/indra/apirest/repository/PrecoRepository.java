package com.indra.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.indra.apirest.domain.Preco;

public interface PrecoRepository  extends JpaRepository<Preco, Long> {

}
