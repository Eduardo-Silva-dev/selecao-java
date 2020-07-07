package com.indra.apirest.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Produto")
public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="tipo")
	private String tipo;
	
	@Column(name="und_medida")
	private String undMedida;
	
	@Column(name="bandeira")
	private String bandeira;
	
	@Column(name = "nome_revenda")
	private String nomeRevenda;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy="produto")
	private Coleta coleta; 
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy="produto")
	private Preco preco; 
	
	@JsonIgnore
	@ManyToOne
	private Revendedor revendedor;

	public Produto() {
	}

	public Produto(String nome,String tipo, String undMedida, String bandeira) {
		this.nomeRevenda = nome;
		this.tipo = tipo;
		this.undMedida = undMedida;
		this.bandeira = bandeira;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeRevenda() {
		return nomeRevenda;
	}

	public void setNomeRevenda(String nomeRevenda) {
		this.nomeRevenda = nomeRevenda;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getUndMedida() {
		return undMedida;
	}

	public void setUndMedida(String undMedida) {
		this.undMedida = undMedida;
	}

	public String getBandeira() {
		return bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}

	public Revendedor getRevendedor() {
		return revendedor;
	}

	public void setRevendedor(Revendedor revendedor) {
		this.revendedor = revendedor;
	}

	public Coleta getColeta() {
		return coleta;
	}

	public void setColeta(Coleta coleta) {
		this.coleta = coleta;
	}

	public Preco getPreco() {
		return preco;
	}

	public void setPreco(Preco preco) {
		this.preco = preco;
	}

}
