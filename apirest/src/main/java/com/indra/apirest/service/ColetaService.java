package com.indra.apirest.service;

import java.util.List;

import javax.persistence.Tuple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.indra.apirest.repository.ColetaRepository;
import com.indra.apirest.utils.FuncaoUtils;

@Service
public class ColetaService {

	@Autowired
	private ColetaRepository coletaRepository;
	
	public List<ObjectNode> DadosAgrupadosPorDataColeta(){
		List<Tuple> media = coletaRepository.DadosAgrupadosPorDataColeta();
		List<ObjectNode> result = FuncaoUtils.formataJson(media);
		return result;
	}
}
