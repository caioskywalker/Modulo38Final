package br.com.cfarias.service;

import java.util.List;

import br.com.cfarias.dao.interfaces.IClienteDao;
import br.com.cfarias.domain.Cliente;
import br.com.cfarias.exceptions.DAOException;
import br.com.cfarias.exceptions.MaisDeUmRegistroException;
import br.com.cfarias.exceptions.TableException;
import br.com.cfarias.service.generic.GenericService;
import br.com.cfarias.service.interfaces.IClienteService;

public class ClienteService extends GenericService<Cliente, Long>
	implements IClienteService {

	private IClienteDao clienteDao;
	
	public ClienteService(IClienteDao clienteDaoRecebido) {
		super(clienteDaoRecebido);
		this.clienteDao = clienteDaoRecebido;
	}

	@Override
	public Cliente buscarPorCPF(Long cpf) throws DAOException {
		try {
			return this.dao.consultar(cpf);
		}catch(MaisDeUmRegistroException| TableException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Cliente> filtrarClientes(String query) {
		return clienteDao.filtrarClientes(query);
	}

}
