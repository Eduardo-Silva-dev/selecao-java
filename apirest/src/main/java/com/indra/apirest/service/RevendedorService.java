package com.indra.apirest.service;

import java.util.List;

import javax.persistence.Tuple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.indra.apirest.domain.Revendedor;
import com.indra.apirest.repository.RevendedorRepository;
import com.indra.apirest.utils.FuncaoUtils;

@Service
public class RevendedorService {
	
	@Autowired
	private RevendedorRepository revendedorRepository;
	
	public List<ObjectNode> informacoesImportadasSiglaRegiao(){
		List<Tuple> media = revendedorRepository.informacoesImportadasSiglaRegiao();
		List<ObjectNode> result = FuncaoUtils.formataJson(media);
		return result;
	}

	public List<ObjectNode> DadosAgrupadosDataDistribuidora(){
		List<Tuple> media = revendedorRepository.DadosAgrupadosDataDistribuidora();
		List<ObjectNode> result = FuncaoUtils.formataJson(media);
		return result;
	}
	
	public void saveAllRevendedores(List<Revendedor> revendedores) {
		revendedorRepository.saveAll(revendedores);
	}
	
	public void saveRevendedores(Revendedor revendedore) {
		revendedorRepository.save(revendedore);
	}
}
