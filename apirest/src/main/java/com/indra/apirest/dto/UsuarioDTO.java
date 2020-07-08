package com.indra.apirest.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.indra.apirest.domain.Usuario;

public class UsuarioDTO {

    protected long id;  

    private String nome;

    private String sobrenome;

    private String cpf;

    @JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataCadastro;

	public UsuarioDTO() {
		
	}
	
	public UsuarioDTO(Usuario obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.sobrenome = obj.getSobrenome();
		this.cpf = obj.getCpf();
		this.dataCadastro = obj.getDataCadastro();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
}
