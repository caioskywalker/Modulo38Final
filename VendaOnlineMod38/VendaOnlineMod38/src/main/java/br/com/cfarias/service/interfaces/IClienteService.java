package br.com.cfarias.service.interfaces;

import java.util.List;

import br.com.cfarias.domain.Cliente;
import br.com.cfarias.exceptions.DAOException;

public interface IClienteService extends IGenericService<Cliente, Long> {

	Cliente buscarPorCPF(Long cpf) throws DAOException;
	
	List<Cliente> filtrarClientes(String query);
	
}
