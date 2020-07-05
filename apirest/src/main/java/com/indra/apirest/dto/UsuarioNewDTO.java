package com.indra.apirest.dto;

import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

public class UsuarioNewDTO {

	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=3, max=20, message="O tamanho deve ser entre 3 e 20 caracteres")

    private String nome;

	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=3, max=20, message="O tamanho deve ser entre 3 e 20 caracteres")
    private String sobrenome;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=11, max=11, message="O tamanho deve ter 11 caracteres")
    private String cpf;
	
	public UsuarioNewDTO() {
	}

	public UsuarioNewDTO(String nome,String sobrenome,String cpf) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
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
}
