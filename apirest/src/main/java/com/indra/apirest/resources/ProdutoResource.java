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
	
	@GetMapping("/mediaMunicipio")
	public ResponseEntity<?> MediaDePrecoDeVendaPorMunicipio() {	
		return new ResponseEntity<>(produtoService.MediaPrecoMunicipio(), HttpStatus.OK);
	}
	
	@GetMapping("/ValorMedioValorCompraValorVendaMunicipio")
	public ResponseEntity<?> ValorMedioValorCompraValorVendaMunicipio() {	
		return new ResponseEntity<>(produtoService.ValorMedioValorCompraValorVendaMunicipio(), HttpStatus.OK);
	}
	
	@GetMapping("/ValorMedioValorCompraValorVendaBandeira")
	public ResponseEntity<?> ValorMedioValorCompraValorVendaBandeira() {	
		return new ResponseEntity<>(produtoService.ValorMedioValorCompraValorVendaBandeira(), HttpStatus.OK);
	}
}
