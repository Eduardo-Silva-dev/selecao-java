package com.indra.apirest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.apirest.repository.PrecoRepository;

@Service
public class ProdutoService {

	@Autowired
	private PrecoRepository precoRepository;
	
	public String MediaPrecoMunicipio(String municipio){
		String media = precoRepository.MediaPrecoMunicipio(municipio);
		System.out.println(municipio);
		System.out.println(media);
		return media;
	}
}
