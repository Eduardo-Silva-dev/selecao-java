package com.indra.apirest.service;

import java.util.List;

import javax.persistence.Tuple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.indra.apirest.repository.PrecoRepository;
import com.indra.apirest.utils.FuncaoUtils;

@Service
public class ProdutoService {

	@Autowired
	private PrecoRepository precoRepository;
	
	public List<ObjectNode> MediaPrecoMunicipio(){
		List<Tuple> media = precoRepository.MediaPrecoMunicipio();
		List<ObjectNode> result = FuncaoUtils.formataJson(media);
		return result;
	}
}
