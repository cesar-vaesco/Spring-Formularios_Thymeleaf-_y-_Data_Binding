package com.vaescode.springboot.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vaescode.springboot.app.models.entity.Cliente;

@Repository()
public class ClienteDaoImpl implements IClienteDao {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Cliente> findAll() {
		return em.createQuery("from Cliente").getResultList();
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		if (cliente.getId() != null && cliente.getId() > 0) {
			/*
			 * el método merge une/actualiza los datos actualizados
			 */
			em.merge(cliente);
		} else {
			/*
			 * MAntiene los datos del cliente
			 */
			em.persist(cliente);
		}

	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findOne(Long id) {
		return em.find(Cliente.class, id);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		/*
		 * Cliente cliente = findOne(id); em.remove(cliente);
		 */
		em.remove(findOne(id));

	}

}
