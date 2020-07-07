package com.indra.apirest.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Revendedor")
public class Revendedor implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="cnpj")
	private String cnpj;
	
	@Column(name = "data_cadastro")
	private Date dataCadastro;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy="revendedor")
	private Endereco endereco; 
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "Revendedor_Produto",
		joinColumns = @JoinColumn(name = "revendedor_id"),
		inverseJoinColumns = @JoinColumn(name = "produto_id")
	)
	private List<Produto> produtos = new ArrayList<>();

	public Revendedor() {
		this.dataCadastro = new Date();
	}

	public Revendedor(String cnpj) {
		this.cnpj = cnpj;
		this.dataCadastro = new Date();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Revendedor other = (Revendedor) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
