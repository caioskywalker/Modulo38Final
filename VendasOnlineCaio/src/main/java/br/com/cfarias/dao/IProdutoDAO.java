package br.com.cfarias.dao;

import java.util.List;

import br.com.cfarias.dao.generic.IGenericDAO;
import br.com.cfarias.domain.Produto;

public interface IProdutoDAO extends IGenericDAO<Produto, String>{

	List<Produto> filtrarProdutos(String query);

}
