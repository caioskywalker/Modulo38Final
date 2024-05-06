package br.com.cfarias.service.interfaces;

import java.util.List;

import br.com.cfarias.domain.Produto;

public interface IProdutoService extends IGenericService<Produto, String>{
	
	List<Produto> filtrarProdutos(String query);	
	
}
