package com.indra.apirest.service;

import java.util.List;

import javax.persistence.Tuple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.indra.apirest.repository.RevendedorRepository;
import com.indra.apirest.utils.FuncaoUtils;

@Service
public class RevendedorService {
	
	@Autowired
	private RevendedorRepository revendedorRepository;
	
	public List<ObjectNode> MediaPrecoMunicipio(){
		List<Tuple> media = revendedorRepository.DadosAgrupadosPorDistribuidora();
		List<ObjectNode> result = FuncaoUtils.formataJson(media);
		return result;
	}

	public List<ObjectNode> DadosAgrupadosDataDistribuidora(){
		List<Tuple> media = revendedorRepository.DadosAgrupadosDataDistribuidora();
		List<ObjectNode> result = FuncaoUtils.formataJson(media);
		return result;
	}
}
