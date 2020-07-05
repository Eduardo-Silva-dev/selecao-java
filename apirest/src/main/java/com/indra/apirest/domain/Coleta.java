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
import javax.persistence.Table;

@Entity
@Table(name = "Coleta")
public class Coleta implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "data_coleta")
	private String dataColeta;
	
	@Column(name = "data_cadastro")
	private Date dataCadastro;
	
	@JoinColumn(name="produto_id")
	@OneToOne
	@MapsId
	private Produto produto; 
	
	public Coleta() {
		this.dataCadastro = new Date();
	}

	public Coleta(String dataColeta) {
		this.dataColeta = dataColeta;
		this.dataCadastro = new Date();
	}

	public String getDataColeta() {
		return dataColeta;
	}

	public void setDataColeta(String dataColeta) {
		this.dataColeta = dataColeta;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}
