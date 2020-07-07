package com.indra.apirest.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indra.apirest.service.ProdutoService;
import com.indra.apirest.service.RevendedorService;

@RestController
@RequestMapping(value = "/revendedor")
public class RevendedorResource {

	@Autowired
	private RevendedorService revendedorService;
	
	@GetMapping("/DadosAgrupadosPorDistribuidora")
	public ResponseEntity<?> DadosAgrupadosPorDistribuidora() {	
			return new ResponseEntity<>(revendedorService.MediaPrecoMunicipio(), HttpStatus.OK);
	}

	@GetMapping("/DadosAgrupadosDataDistribuidora")
	public ResponseEntity<?> DadosAgrupadosDataDistribuidora() {	
			return new ResponseEntity<>(revendedorService.DadosAgrupadosDataDistribuidora(), HttpStatus.OK);
	}
}
