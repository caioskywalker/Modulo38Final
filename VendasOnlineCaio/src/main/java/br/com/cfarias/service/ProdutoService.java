package br.com.cfarias.service;

import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.cfarias.dao.IProdutoDAO;
import br.com.cfarias.domain.Produto;

import br.com.cfarias.services.generic.GenericService;


@Stateless
public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {
	
	private IProdutoDAO produtoDao;

	@Inject
	public ProdutoService(IProdutoDAO produtoDao) {
		super(produtoDao);
		this.produtoDao = produtoDao;
	}

	@Override
	public List<Produto> filtrarProdutos(String query) {
		return produtoDao.filtrarProdutos(query);
	}

}