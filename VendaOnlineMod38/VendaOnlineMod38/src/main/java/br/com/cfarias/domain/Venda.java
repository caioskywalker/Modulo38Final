package br.com.cfarias.domain;


import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_venda")
public class Venda implements Persistente {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "venda_seq")
	@SequenceGenerator(name = "venda_seq", sequenceName = "sq_venda", initialValue = 1, allocationSize = 1)
	private Long idVenda;

	@Column(name = "codigo", nullable = false, unique = true)
	private String codigo;

	@ManyToOne
	@JoinColumn(name = "id_cliente_fk", foreignKey = @ForeignKey(name = "fk_venda_cleinte"), referencedColumnName = "idCliente", nullable = false)
	private Cliente cliente;

	@OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = true /* , fetch = FetchType.EAGER */)
	private Set<ProdutoQuantidade> produtos;

	@Column(name = "valor_total", nullable = false)
	private BigDecimal valorTotal;

	@Column(name = "data_venda", nullable = false)
	private Instant dataVenda;

	@Enumerated(EnumType.STRING)
	@Column(name = "status_venda", nullable = false)
	private Status status;

	public Venda() {
		produtos = new HashSet<ProdutoQuantidade>();
	}

	
	private void validarStatus() {
		if(this.status == Status.CONCLUIDA) {
			throw new UnsupportedOperationException("Impossível alterar venda finalizada");
		}
	}
	
	public void adicionarProduto(Produto prod, Integer quantidade) {
		validarStatus();
		Optional<ProdutoQuantidade> op =
				produtos.stream().filter(f ->f.getProduto().getCodigo().equals(prod.getCodigo())).findAny();
		if(op.isPresent()) {
			ProdutoQuantidade prodQtd = op.get();
			prodQtd.adicionar(quantidade);
		}
		else {
			ProdutoQuantidade novoProd = new ProdutoQuantidade();
			novoProd.setVenda(this);
			novoProd.setProduto(prod);
			novoProd.adicionar(quantidade);
			produtos.add(novoProd);
		}
		recalcularValorTotalVenda();
		
	}
	
	public void removerProduto(Produto produto, Integer quantidade) {
		validarStatus();
		Optional<ProdutoQuantidade> op =
				produtos.stream().filter(f -> f.getProduto().getCodigo().equals(produto.getCodigo()))
				.findAny();
		if(op.isPresent()) {
			ProdutoQuantidade produtoQtd = op.get();
			if(produtoQtd.getQuantidade() > quantidade) {//Se a quantidade removida for menor que a quantidade da Collection
				produtoQtd.remover(quantidade);
				recalcularValorTotalVenda();
			}
			else {
				produtos.remove(op.get());//Se a quantidade a ser removida for igual ou maior que a quantidade disponível do produto na coleção, ele remove completamente esse produto da lista de produtos e recalcula o valor total da venda.
				recalcularValorTotalVenda();
			}
		}
	}
	
	
	
	public void recalcularValorTotalVenda() {
		BigDecimal valorTotal = this.produtos.stream()
				.map(p -> p.getValorTotal())//(ProdutoQuantidade::getValorTotal)
				.reduce(BigDecimal.ZERO, (b,c) -> b.add(c));//(BigDecimal.ZERO, BigDecimal::add)
		
		this.valorTotal = valorTotal;
	}
	
	public void removerTodosProdutos() {
		validarStatus();
		produtos.clear();
		this.valorTotal = BigDecimal.ZERO;
	}

	public Integer getQuantidadeTotalProdutos() {
		int result = produtos.stream()
				.reduce(0, (pCountResult, prod) -> pCountResult + prod.getQuantidade(), (c,b) -> c + b);
		return result;
	}
	
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Set<ProdutoQuantidade> getProdutos() {
		return produtos;
	}

	public void setProdutos(Set<ProdutoQuantidade> produtos) {
		this.produtos = produtos;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Instant getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Instant dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Long getId() {

		return idVenda;
	}

	public void setId(Long id) {
		this.idVenda = id;

	}
	
	
	

}
