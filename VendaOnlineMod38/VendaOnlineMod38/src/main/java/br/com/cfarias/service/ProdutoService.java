package br.com.cfarias.service;
import java.util.List;


import br.com.cfarias.dao.interfaces.IProdutoDao;
import br.com.cfarias.domain.Produto;
import br.com.cfarias.service.generic.GenericService;
import br.com.cfarias.service.interfaces.IProdutoService;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

	private IProdutoDao produtoDao;
	
	public ProdutoService(IProdutoDao produtoDaoRecebido) {
		super(produtoDaoRecebido);
		this.produtoDao = produtoDaoRecebido;
	}

	
	
	@Override
	public List<Produto> filtrarProdutos(String query) {
		// TODO Auto-generated method stub
		return produtoDao.filtrarProdutos(query);
	}

}
