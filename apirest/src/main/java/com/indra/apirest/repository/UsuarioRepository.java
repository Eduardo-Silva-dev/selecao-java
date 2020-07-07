package com.indra.apirest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.indra.apirest.domain.Usuario;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long> {

	@Query("Select u From Usuario u where u.id = ?1")
	Usuario findById(long id);

	Page<Usuario> findAll(Pageable pageable); 
	
}
