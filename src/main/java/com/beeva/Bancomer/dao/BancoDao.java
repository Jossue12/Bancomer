package com.beeva.Bancomer.dao;

import com.beeva.Bancomer.modelo.Banco;
import com.beeva.Bancomer.modelo.Cliente;
import com.beeva.Bancomer.modelo.Cuenta;

public abstract class BancoDao {
	public abstract void agregarBanco(Banco banco);
	public abstract void deposito(double cantidad, Cliente cliente, Cuenta cuenta);
	public abstract void retiro(double cantidad, Cuenta cuenta);

}
