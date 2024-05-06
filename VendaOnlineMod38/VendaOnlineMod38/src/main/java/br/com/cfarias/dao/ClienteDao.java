package br.com.cfarias.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.cfarias.dao.interfaces.IClienteDao;
import br.com.cfarias.domain.Cliente;

public class ClienteDao extends GenericDao<Cliente, Long> implements IClienteDao {

	public ClienteDao() {
		super(Cliente.class);
	}

	
	public List<Cliente> filtrarClientes(String query) {
		TypedQuery<Cliente> tpQuery = 
				this.em.createNamedQuery("Cliente.findByNome", this.persistenteClass);
		tpQuery.setParameter("nome", "%" + query + "%");
        return tpQuery.getResultList();
	}
	/**
	 * TypedQuery<Cliente> tpQuery = this.entityManager.createNamedQuery("Cliente.findByNome", 
	 * this.persistenteClass);:
	 *  Nesta linha, uma consulta é criada utilizando o EntityManager (entityManager).
	 * 
	 *  A consulta é baseada em uma named query (consulta nomeada) chamada 
	 *  "Cliente.findByNome". Named queries são consultas definidas na entidade
	 *  Cliente ou em arquivos de metadados de persistência (como um arquivo 
	 *  XML ou de anotações), que podem ser referenciadas por seu nome em vez
	 *  de serem definidas diretamente no código. this.persistenteClass é 
	 *  utilizado para indicar o tipo de resultado esperado.
	 **/
	
}
