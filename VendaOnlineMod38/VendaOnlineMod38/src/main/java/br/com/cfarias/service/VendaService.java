package br.com.cfarias.service;

import javax.inject.Inject;

import br.com.cfarias.dao.interfaces.IVendaDao;
import br.com.cfarias.domain.Status;
import br.com.cfarias.domain.Venda;
import br.com.cfarias.exceptions.DAOException;
import br.com.cfarias.exceptions.TipoChaveNaoEncontradaException;
import br.com.cfarias.service.generic.GenericService;
import br.com.cfarias.service.interfaces.IVendaService;

public class VendaService extends GenericService<Venda, Long> implements IVendaService {

	IVendaDao dao;

	@Inject
	public VendaService(IVendaDao dao) {
		super(dao);
		this.dao = dao;
	}

	@Override
	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException {
		venda.setStatus(Status.CONCLUIDA);
		dao.finalizarVenda(venda);
	}

	@Override
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException {
		venda.setStatus(Status.CANCELADA);
		dao.cancelarVenda(venda);
	}

	@Override
	public Venda consultarComCollection(Long id) {
		return dao.consultarComCollection(id);
	}

	@Override
	public Venda cadastrar(Venda entity) throws TipoChaveNaoEncontradaException, DAOException {
		entity.setStatus(Status.INICIADA);
		return super.cadastrar(entity);
	}

}
