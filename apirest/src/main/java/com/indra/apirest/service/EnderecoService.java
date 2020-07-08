package com.indra.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.apirest.domain.Endereco;
import com.indra.apirest.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public void saveAllEnderecos(List<Endereco> enderecos) {
		enderecoRepository.saveAll(enderecos);
	}
	
	public void saveEnderecos(Endereco endereco) {
		enderecoRepository.save(endereco);
	}
	
}
