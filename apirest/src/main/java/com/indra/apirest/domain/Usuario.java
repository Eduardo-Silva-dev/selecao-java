package com.indra.apirest.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id;  
	
	@Column(name = "caminho")
    private String caminho; 

    @Column(name = "nome")
    private String nome;

    @Column(name = "sobrenome")
    private String sobrenome;

    @Column(name = "cpf")
    private String cpf;

	@Column(name = "data_cadastro")
	private Date dataCadastro;
	
	public Usuario() {
	}
	
	private Usuario(String nome, String sobrenome, String cpf) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.dataCadastro = new Date();
	}

	public static class UsuarioBuilder{

	    private String nome;

	    private String sobrenome;

	    private String cpf;
		
		public UsuarioBuilder(){
			
		}
		
		public Usuario build() {
			return new Usuario(nome, sobrenome, cpf);
		}

		public UsuarioBuilder Nome(String nome) {
			this.nome = nome;
			return this;
		}

		public UsuarioBuilder Sobrenome(String sobrenome) {
			this.sobrenome = sobrenome;
			return this;
		}

		public UsuarioBuilder Cpf(String cpf) {
			this.cpf = cpf;
			return this;
		}

	}
	
	public Usuario(Date dataCadastro) {
		super();
		this.dataCadastro = dataCadastro;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
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