package com.beeva.Bancomer.implementacion;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beeva.Bancomer.dao.TipoCuentaDao;
import com.beeva.Bancomer.modelo.TipoCuenta;


@Repository
public class TipoCuentaImp extends TipoCuentaDao{
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	@Transactional
	public void agregarTipoCuenta(TipoCuenta tipoCuenta) {
		em.persist(tipoCuenta);
	}}