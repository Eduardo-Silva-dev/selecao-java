package com.indra.apirest.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indra.apirest.service.RevendedorService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/revendedor")
public class RevendedorResource {

	@Autowired
	private RevendedorService revendedorService;

	@ApiOperation(value="retorna todas as informações importadas por sigla da região")
	@GetMapping("/informacoesImportadasSiglaRegiao")
	public ResponseEntity<?> informacoesImportadasSiglaRegiao() {	
			return new ResponseEntity<>(revendedorService.informacoesImportadasSiglaRegiao(), HttpStatus.OK);
	}
	
	@ApiOperation(value="retorna os dados agrupados por distribuidora")
	@GetMapping("/DadosAgrupadosDataDistribuidora")
	public ResponseEntity<?> DadosAgrupadosDataDistribuidora() {	
			return new ResponseEntity<>(revendedorService.DadosAgrupadosDataDistribuidora(), HttpStatus.OK);
	}
}
