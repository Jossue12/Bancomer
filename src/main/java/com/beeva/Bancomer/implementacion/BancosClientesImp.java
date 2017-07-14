package com.beeva.Bancomer.implementacion;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beeva.Bancomer.dao.BancosClientesDao;
import com.beeva.Bancomer.modelo.BancosClientes;

@Repository
public class BancosClientesImp extends BancosClientesDao{

	@PersistenceContext
	EntityManager em;
	
	@Override
	@Transactional
	public void agregarBancosClientes(BancosClientes bancosClientes)
	{
		em.persist(bancosClientes);
	}

}
