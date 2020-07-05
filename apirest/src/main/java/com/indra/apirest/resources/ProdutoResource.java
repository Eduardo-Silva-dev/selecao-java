package com.indra.apirest.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indra.apirest.service.ProdutoService;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoResource {

	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping("/mediaMunicipio/{municipio}")
	public ResponseEntity<?> MediaDePrecoDeVendaPorMunicipio(@PathVariable String municipio) {
					
			return new ResponseEntity<>(produtoService.MediaPrecoMunicipio(municipio), HttpStatus.OK);
		
	}
	
}
