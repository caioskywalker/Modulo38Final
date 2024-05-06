package br.com.cfarias.dao.interfaces;

import java.util.List;

import br.com.cfarias.domain.Cliente;

public interface IClienteDao extends IGenericDao<Cliente, Long>{
	
	List<Cliente> filtrarClientes(String query);

}
