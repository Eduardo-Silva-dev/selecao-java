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
	
	@Column(name = "data_cadastro")
	private Date dataCadastro;
	
	@Column(name = "nome_revenda")
	private String nomeRevenda;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy="produto")
	private Coleta coleta; 
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy="produto")
	private Preco preco; 
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="revendedor_id")
	private Revendedor revendedor;

	public Produto() {
		this.dataCadastro = new Date();
	}

	public Produto(String nome,String tipo, String undMedida, String bandeira) {
		this.nomeRevenda = nome;
		this.tipo = tipo;
		this.undMedida = undMedida;
		this.bandeira = bandeira;
		this.dataCadastro = new Date();
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bandeira == null) ? 0 : bandeira.hashCode());
		result = prime * result + ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((undMedida == null) ? 0 : undMedida.hashCode());
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
		Produto other = (Produto) obj;
		if (bandeira == null) {
			if (other.bandeira != null)
				return false;
		} else if (!bandeira.equals(other.bandeira))
			return false;
		if (dataCadastro == null) {
			if (other.dataCadastro != null)
				return false;
		} else if (!dataCadastro.equals(other.dataCadastro))
			return false;
		if (id != other.id)
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (undMedida == null) {
			if (other.undMedida != null)
				return false;
		} else if (!undMedida.equals(other.undMedida))
			return false;
		return true;
	}
}
