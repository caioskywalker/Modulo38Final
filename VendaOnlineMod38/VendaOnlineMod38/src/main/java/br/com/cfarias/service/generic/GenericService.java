package br.com.cfarias.service.generic;

import br.com.cfarias.service.interfaces.IGenericService;
import br.com.cfarias.dao.interfaces.IGenericDao;


import java.io.Serializable;
import java.util.Collection;

import br.com.cfarias.domain.Persistente;
import br.com.cfarias.exceptions.DAOException;
import br.com.cfarias.exceptions.MaisDeUmRegistroException;
import br.com.cfarias.exceptions.TableException;
import br.com.cfarias.exceptions.TipoChaveNaoEncontradaException;


public abstract class GenericService<T extends Persistente, E extends Serializable>
	implements IGenericService<T, E>{
	
	protected IGenericDao<T, E> dao;
	
	public GenericService(IGenericDao<T, E> daoRecebido) {
		this.dao = daoRecebido;
	}
	@Override
	public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
		return this.dao.cadastrar(entity);
	}

	@Override
	public void excluir(T entity) throws DAOException {
		this.dao.excluir(entity);
	}

	@Override
	public T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
		return this.dao.alterar(entity);
	}

	@Override
	public T consultar(E valor) throws MaisDeUmRegistroException, TableException, DAOException {
		return this.dao.consultar(valor);
	}

	@Override
	public Collection<T> buscarTodos() throws DAOException {
		return this.dao.buscarTodos();
	}
	

}
