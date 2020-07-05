package com.indra.apirest.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Endereco implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "regiao")
	private String regiao;
	
	@Column(name = "municipio")
	private String municipio;
	
	@Column(name = "estado")
	private String estado;
	
	@Column(name = "data_cadastro")
	private Date dataCadastro;
	
	@JoinColumn(name="revendedor_id")
	@OneToOne
	@MapsId
	private Revendedor revendedor;

	public Endereco() {
		this.dataCadastro = new Date();
	}

	public Endereco(String regiao, String municipio, String estado) {
		super();
		this.regiao = regiao;
		this.municipio = municipio;
		this.estado = estado;
		this.dataCadastro  = new Date();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Revendedor getRevendedor() {
		return revendedor;
	}

	public void setRevendedor(Revendedor revendedor) {
		this.revendedor = revendedor;
	}

	
}
