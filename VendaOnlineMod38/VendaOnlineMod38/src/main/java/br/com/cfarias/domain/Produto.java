package br.com.cfarias.domain;

import java.math.BigDecimal;

import javax.persistence.*;

@Entity
@Table(name = "tb_produto")
@NamedQuery(name = "prod_seq", query = "SELECT p FROM Produto WHERE p.nome LIKE :nome")
public class Produto implements Persistente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prod_seq")
	private Long idProduto;
	
	@Column(name = "codigo", nullable = false, length = 10, unique = true)
	private String codigo;
	
	@Column(name = "nome", nullable = false, length = 60)
	private String nome;
	
	@Column(name = "descricao", nullable = false, length = 50)
	private String descricao;
	
	@Column(name = "valor", nullable = false)
	private BigDecimal valor;
	
	
	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public BigDecimal getValor() {
		return valor;
	}


	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}


	public Long getId() {
	
		return idProduto;
	}


	public void setId(Long idProduto) {
	this.idProduto = idProduto;
		
	}

}
