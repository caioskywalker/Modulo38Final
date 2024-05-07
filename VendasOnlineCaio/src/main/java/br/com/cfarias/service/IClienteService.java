package br.com.cfarias.service;

import java.util.List;

import br.com.cfarias.domain.Cliente;
import br.com.cfarias.exceptions.DAOException;
import br.com.cfarias.services.generic.IGenericService;


public interface IClienteService extends IGenericService<Cliente, Long> {

	Cliente buscarPorCPF(Long cpf) throws DAOException;

	List<Cliente> filtrarClientes(String query);

}
