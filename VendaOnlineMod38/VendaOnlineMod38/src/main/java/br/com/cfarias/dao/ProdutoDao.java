package br.com.cfarias.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.cfarias.dao.interfaces.IProdutoDao;
import br.com.cfarias.domain.Produto;

public class ProdutoDao extends GenericDao<Produto, String> implements IProdutoDao {

	public ProdutoDao() {
		super(Produto.class);
		
	}

	@Override
	public List<Produto> filtrarProdutos(String query) {
		TypedQuery<Produto> tpQuery = 
				this.em.createNamedQuery("Produto.findByNome", this.persistenteClass);
		tpQuery.setParameter("nome", "%" + query + "%");
        return tpQuery.getResultList();
	}

}
