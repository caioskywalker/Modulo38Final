package br.com.cfarias.dao;

import java.util.List;

import br.com.cfarias.dao.generic.IGenericDAO;
import br.com.cfarias.domain.Cliente;


public interface IClienteDAO extends IGenericDAO<Cliente, Long>{

	List<Cliente> filtrarClientes(String query);

}