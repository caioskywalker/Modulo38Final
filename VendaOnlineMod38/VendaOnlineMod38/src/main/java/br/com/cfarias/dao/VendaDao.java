package br.com.cfarias.dao;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.cfarias.dao.interfaces.IVendaDao;
import br.com.cfarias.domain.Cliente;
import br.com.cfarias.domain.Produto;
import br.com.cfarias.domain.Venda;
import br.com.cfarias.exceptions.DAOException;
import br.com.cfarias.exceptions.TipoChaveNaoEncontradaException;

public class VendaDao extends GenericDao<Venda, Long> implements IVendaDao {

	public VendaDao() {
		super(Venda.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException {
		super.alterar(venda);
		
	}

	@Override
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException {
		super.alterar(venda);
		
	}
	
	public Venda cadastrar (Venda entity) throws DAOException{
		try {
			entity.getProdutos().forEach(p -> {
				Produto prodJpa = em.merge(p.getProduto());
				p.setProduto(prodJpa);
			});
			
			Cliente cliente = em.merge(entity.getCliente());
			entity.setCliente(cliente);
			em.persist(entity);
			//em.getTransaction().commit();
			return entity;
			
		}catch(Exception e) {
			throw new DAOException("Erro ao salvar venda", e);
		}
	}
	
	
	@Override
	public Venda consultarComCollection(Long id) {
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Venda> query = builder.createQuery(Venda.class);
		Root<Venda> root = query.from(Venda.class);
		root.fetch("cliente");
		root.fetch("produtos");
		query.select(root).where(builder.equal(root.get("id"), id));
		TypedQuery<Venda> tpQuery =
				em.createQuery(query);
		Venda venda = tpQuery.getSingleResult();
		
		
		return venda;
	}

	
	public void excluir(Venda entity) throws DAOException {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
	}
	
//	@Override
//	public Collection<Venda> buscarTodos() throws DAOException {
//		StringBuilder sb = new StringBuilder();
//		sb.append("SELECT obj FROM ");
//		sb.append(this.persistenteClass.getSimpleName());
//		sb.append(" obj");
//		sb.append(" WHERE obj.status = :status");
//		TypedQuery<Venda> query = this.entityManager.createQuery(sb.toString(), Venda.class);
//		query.setParameter("status", Venda.Status.);
//		
//		List<T> list = 
//				entityManager.createQuery(getSelectSql(), this.persistenteClass).getResultList();
//		return list;
//	}

}
