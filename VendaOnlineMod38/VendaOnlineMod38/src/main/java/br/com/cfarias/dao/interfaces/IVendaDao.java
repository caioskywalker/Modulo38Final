package br.com.cfarias.dao.interfaces;

import br.com.cfarias.domain.Venda;
import br.com.cfarias.exceptions.DAOException;
import br.com.cfarias.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaDao extends IGenericDao<Venda, Long> {

	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;

	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
	
	public Venda consultarComCollection(Long id);
}
