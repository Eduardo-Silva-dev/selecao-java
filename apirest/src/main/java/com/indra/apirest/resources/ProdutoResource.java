package com.indra.apirest.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indra.apirest.service.ProdutoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoResource {

	@Autowired
	private ProdutoService produtoService;
	
	@ApiOperation(value="retorna a média de preço de combustível com base no nome do município")
	@GetMapping("/mediaMunicipio")
	public ResponseEntity<?> MediaDePrecoDeVendaPorMunicipio() {	
		return new ResponseEntity<>(produtoService.MediaPrecoMunicipio(), HttpStatus.OK);
	}
	
	@ApiOperation(value="retorna o valor médio do valor da compra e do valor da venda por município")
	@GetMapping("/ValorMedioValorCompraValorVendaMunicipio")
	public ResponseEntity<?> ValorMedioValorCompraValorVendaMunicipio() {	
		return new ResponseEntity<>(produtoService.ValorMedioValorCompraValorVendaMunicipio(), HttpStatus.OK);
	}
	
	@ApiOperation(value="retorna o valor médio do valor da compra e do valor da venda por bandeira")
	@GetMapping("/ValorMedioValorCompraValorVendaBandeira")
	public ResponseEntity<?> ValorMedioValorCompraValorVendaBandeira() {	
		return new ResponseEntity<>(produtoService.ValorMedioValorCompraValorVendaBandeira(), HttpStatus.OK);
	}
}
