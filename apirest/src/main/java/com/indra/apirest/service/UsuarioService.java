package com.indra.apirest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.io.IOException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.apirest.domain.Usuario;
import com.indra.apirest.dto.UsuarioDTO;
import com.indra.apirest.dto.UsuarioNewDTO;
import com.indra.apirest.repository.UsuarioRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario find(long id) throws ObjectNotFoundException{
		
		Usuario obj =  usuarioRepository.findById(id);
		
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName(), null);
		}
		
		return obj;
	}
	
	public UsuarioDTO findParcial(Integer id) throws IOException {
		
		try {
			Usuario obj = find(id);
			
			UsuarioDTO obgDTO = new UsuarioDTO(obj);
			
			return obgDTO;
		} catch (ObjectNotFoundException e) {
			
			e.printStackTrace();
			
			return null;
		}
	}

	public Page<UsuarioDTO> findAll(Pageable pageable) throws IOException {
		
		Page<Usuario> analista = usuarioRepository.findAll(pageable);
		
		Page<UsuarioDTO> listDto = analista.map(obj -> new UsuarioDTO(obj));  
		
		return listDto;
	}
	
	public Usuario fromDTO(UsuarioNewDTO objDto) {
		
		Usuario usuario = new Usuario.UsuarioBuilder()
				.Cpf(objDto.getCpf())
				.Nome(objDto.getNome())
				.Sobrenome(objDto.getSobrenome())
				.build();
		
		return usuario;
	}

	@Transactional
	public Usuario insert(Usuario obj) {
		
		obj = usuarioRepository.save(obj);
		
		return obj;
	}

	public Usuario update(Usuario obj,long id) {
		
		obj.setId(id);
		
		return usuarioRepository.save(obj);
	}
	
	
	public void delete(long id){
		usuarioRepository.deleteById(id);	
	}
}
