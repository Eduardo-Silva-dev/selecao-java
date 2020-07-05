package com.indra.apirest.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.indra.apirest.domain.Usuario;
import com.indra.apirest.service.ArquivoService;
import com.indra.apirest.service.UsuarioService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value="/arquivo")
public class ArquivoResource {
	
	@Autowired 
	private ArquivoService arquivoService;
	
	@Autowired 
	private UsuarioService usuarioService;
	
	@PostMapping("/{id}/{nome}")
	public ResponseEntity<Void> insertFile(@RequestParam("file") MultipartFile file, @PathVariable long id, @PathVariable String nome ) {
		try {
			Usuario user = usuarioService.find(id);
			arquivoService.insertFile(user,file,nome);
		} catch (ObjectNotFoundException e) {
			e.printStackTrace();
		}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand().toUri();
		return ResponseEntity.created(uri).build();
	}
}
