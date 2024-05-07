package br.com.cfarias.service;

import java.util.List;

import br.com.cfarias.domain.Produto;
import br.com.cfarias.services.generic.IGenericService;



public interface IProdutoService extends IGenericService<Produto, String> {

	List<Produto> filtrarProdutos(String query);

}
