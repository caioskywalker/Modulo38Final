package br.com.cfarias.domain;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "tb_produto_quantidade")
public class ProdutoQuantidade {

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prod_qtd_seq")
	private Long idProdutoQuantidade;
	
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private Produto produto;
	
	@Column(name = "quantidade", nullable = false)
	private Integer quantidade;
	
	@Column(name = "valor_total", nullable = false)
	private BigDecimal valorTotal;
	
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "id_venda_fk", foreignKey = @ForeignKey(name = "fk_prod_qtd_venda"),
	referencedColumnName = "idVenda", nullable = false )
	private Venda venda;
	
	public ProdutoQuantidade() {
		this.quantidade = 0;
		this.valorTotal = BigDecimal.ZERO;
	}
	
	public void adicionar(Integer quantidade) {
		this.quantidade += quantidade;
		//BigDecimal novoTotal =this.valorTotal.add(this.produto.getValor().multiply(BigDecimal.valueOf(quantidade)));
		this.valorTotal = this.valorTotal.add(this.produto.getValor().multiply(BigDecimal.valueOf(quantidade)));
	}
	
	public void remover(Integer quantidade) {
		this.quantidade += quantidade;
		this.valorTotal = this.valorTotal.subtract(this.produto.getValor().multiply(BigDecimal.valueOf(quantidade)));
	}

	public Long getIdProdutoQuantidade() {
		return idProdutoQuantidade;
	}

	public void setIdProdutoQuantidade(Long idProdutoQuantidade) {
		this.idProdutoQuantidade = idProdutoQuantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	
	
	
	
}
