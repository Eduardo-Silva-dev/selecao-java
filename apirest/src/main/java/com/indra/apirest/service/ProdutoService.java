package com.indra.apirest.service;

import java.util.List;

import javax.persistence.Tuple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.indra.apirest.domain.Preco;
import com.indra.apirest.domain.Produto;
import com.indra.apirest.repository.PrecoRepository;
import com.indra.apirest.repository.ProdutoRepository;
import com.indra.apirest.utils.FuncaoUtils;

@Service
public class ProdutoService {

	@Autowired
	private PrecoRepository precoRepository;

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<ObjectNode> MediaPrecoMunicipio(){
		List<Tuple> media = precoRepository.MediaPrecoMunicipio();
		List<ObjectNode> result = FuncaoUtils.formataJson(media);
		return result;
	}
	
	public List<ObjectNode> ValorMedioValorCompraValorVendaMunicipio(){
		List<Tuple> media = precoRepository.ValorMedioValorCompraValorVendaMunicipio();
		List<ObjectNode> result = FuncaoUtils.formataJson(media);
		return result;
	}
	
	public List<ObjectNode> ValorMedioValorCompraValorVendaBandeira(){
		List<Tuple> media = precoRepository.ValorMedioValorCompraValorVendaBandeira();
		List<ObjectNode> result = FuncaoUtils.formataJson(media);
		return result;
	}
	
	public void  saveAllProdutos(List<Produto> produtos) {
		produtoRepository.saveAll(produtos);
	}
	
	public void  saveAllPrecos(List<Preco> precos) {
		precoRepository.saveAll(precos);
	}
	
	public void  saveProduto(Produto produto) {
		produtoRepository.save(produto);
	}
	
	public void  savePrecos(Preco preco) {
		precoRepository.save(preco);
	}
}
