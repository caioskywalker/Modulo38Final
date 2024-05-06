package br.com.cfarias.dao.interfaces;

import java.util.List;

import br.com.cfarias.domain.Produto;

public interface IProdutoDao extends IGenericDao<Produto, String> {

	List<Produto> filtrarProdutos(String query);
	
}
