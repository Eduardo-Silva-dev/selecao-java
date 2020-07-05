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
@Table(name = "Preco")
public class Preco  implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="valor_compra")
	private String valorCompra;
	
	@Column(name="valor_venda")
	private String valorVenda;
	
	@Column(name = "data_cadastro")
	private Date dataCadastro;

	@JoinColumn(name="produto_id")
    @OneToOne
	@MapsId
	private Produto produto; 
	
	public Preco() {
		this.dataCadastro = new Date();
	}

	public Preco(String valorCompra, String valorVenda) {
		this.valorCompra = valorCompra;
		this.valorVenda = valorVenda;
		this.dataCadastro = new Date();
	}
	
	public String getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(String valorCompra) {
		this.valorCompra = valorCompra;
	}

	public String getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(String valorVenda) {
		this.valorVenda = valorVenda;
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
