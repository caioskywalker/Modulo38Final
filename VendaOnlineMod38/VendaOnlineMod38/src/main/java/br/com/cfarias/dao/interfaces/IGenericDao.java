package br.com.cfarias.dao.interfaces;

import java.io.Serializable;
import java.util.Collection;

import br.com.cfarias.domain.Persistente;
import br.com.cfarias.exceptions.DAOException;
import br.com.cfarias.exceptions.MaisDeUmRegistroException;
import br.com.cfarias.exceptions.TableException;
import br.com.cfarias.exceptions.TipoChaveNaoEncontradaException;

public interface IGenericDao<T extends Persistente, E extends Serializable> {
	
	public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException;
	public void excluir(T entity) throws DAOException;
	public T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException;
	public T consultar (E id) throws MaisDeUmRegistroException,TableException,DAOException;
	public Collection<T> buscarTodos() throws DAOException;

}
