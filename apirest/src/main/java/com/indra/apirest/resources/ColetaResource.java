package com.indra.apirest.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indra.apirest.service.ColetaService;
import com.indra.apirest.service.ProdutoService;

@RestController
@RequestMapping(value = "/coleta")
public class ColetaResource {

	@Autowired
	private ColetaService coletaService;
	
	@GetMapping("/DadosAgrupadosPorDataColeta")
	public ResponseEntity<?> DadosAgrupadosPorDataColeta() {	
		return new ResponseEntity<>(coletaService.DadosAgrupadosPorDataColeta(), HttpStatus.OK);
	}
}