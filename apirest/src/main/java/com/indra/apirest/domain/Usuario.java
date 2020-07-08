package com.indra.apirest.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id;  

    @Column(name = "nome")
    private String nome;

    @Column(name = "sobrenome")
    private String sobrenome;

    @Column(name = "cpf")
    @CPF
    private String cpf;

	@Column(name = "data_cadastro",length=8)
	private Date dataCadastro;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "Usuario_Arquivo",
		joinColumns = @JoinColumn(name = "usuario_id"),
		inverseJoinColumns = @JoinColumn(name = "arquivo_id")
	)
	private List<Arquivo> arquivos = new ArrayList<>();
	
	public Usuario() {
		this.dataCadastro = new Date(System.currentTimeMillis());
	}
	
	private Usuario(String nome, String sobrenome, String cpf) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.dataCadastro = new Date(System.currentTimeMillis());
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

	public List<Arquivo> getArquivos() {
		return arquivos;
	}

	public void setArquivos(List<Arquivo> arquivos) {
		this.arquivos = arquivos;
	}
	
}