package com.beeva.Bancomer.implementacion;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beeva.Bancomer.dao.ClienteDao;
import com.beeva.Bancomer.modelo.Cliente;

@Repository
public class ClienteImp extends ClienteDao{

	@PersistenceContext
	EntityManager em;
	
	@Override
	@Transactional
	public void agregarCliente(Cliente cliente) {
			em.persist(cliente);
	}

	@Override
	@Transactional
	public String obtenerCliente(int numero) {
		   return null;
	}

	@Override
	@Transactional
	public int obtenerNCliente(Cliente cliente) {
		   return 0;
	}
}