package com.beeva.Bancomer.dao;

import com.beeva.Bancomer.modelo.Cliente;

public abstract class ClienteDao {
	public abstract void agregarCliente(Cliente cliente);
	public abstract String obtenerCliente(int numero);
	public abstract int obtenerNCliente(Cliente cliente);
	}
