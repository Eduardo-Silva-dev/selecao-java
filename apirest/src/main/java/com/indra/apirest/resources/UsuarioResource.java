package com.indra.apirest.resources;
import java.io.IOException;
import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.indra.apirest.domain.Usuario;
import com.indra.apirest.dto.UsuarioDTO;
import com.indra.apirest.dto.UsuarioNewDTO;
import com.indra.apirest.service.UsuarioService;

import javax.validation.Valid;

public class UsuarioResource {

	@Autowired
	private UsuarioService usurioService;
	
	@GetMapping("/id}")
	public ResponseEntity<UsuarioDTO> find(@PathVariable Integer id) throws IOException {
		UsuarioDTO obj = usurioService.findParcial(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody UsuarioNewDTO objDto){
		Usuario obj = usurioService.fromDTO(objDto);
		obj = usurioService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable long id, @RequestBody UsuarioNewDTO objDto){
		Usuario obj = usurioService.fromDTO(objDto);
		obj = usurioService.update(obj,id);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable long id){
		usurioService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
