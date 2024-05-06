package br.com.cfarias.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.cfarias.dao.interfaces.IGenericDao;
import br.com.cfarias.domain.Persistente;
import br.com.cfarias.exceptions.DAOException;
import br.com.cfarias.exceptions.MaisDeUmRegistroException;
import br.com.cfarias.exceptions.TableException;
import br.com.cfarias.exceptions.TipoChaveNaoEncontradaException;

public class GenericDao<T extends Persistente, E extends Serializable> implements IGenericDao<T, E> {

	//protected EntityManagerFactory emf;
	//protected EntityManager em;
	
	protected Class<T> persistenteClass;
	protected EntityManager em;
	
	
	public GenericDao(Class<T> persistenteClass) {
		this.persistenteClass = persistenteClass;
	}


	public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
		em.persist(entity);
		//em.getTransaction().commit();
		return entity;
	}

	
	public void excluir(T entity) throws DAOException {
		if(em.contains(entity)) {//Se o entityManager conter a entidade
			em.remove(entity);//remova a entidade
		}
		else {//senão
			T managedCustomer = em.find(this.persistenteClass, entity.getId());
			//se for a classe persistente atual, ache o ID correspondente;
			if(managedCustomer != null) {//Se não estiver nulo
				em.remove(managedCustomer);
			}
		}
		
	}


	public T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
		entity = em.merge(entity);
		//em.getTransaction().commit();
		return entity;
	}

	
	public T consultar(E id) throws MaisDeUmRegistroException, TableException, DAOException {
		T entity = em.find(this.persistenteClass, id);
		//em.getTransaction().commit();
		return entity;
	}

	
	public Collection<T> buscarTodos() throws DAOException {
		List<T> list = 
				em.createQuery(getSelectSql(), this.persistenteClass).getResultList();
		return list;
	}
	
	private String getSelectSql() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT obj FROM ");
		sb.append(this.persistenteClass.getSimpleName());
		sb.append(" obj");
		return sb.toString();
	}
	
	

}
