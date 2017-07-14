package com.beeva.Bancomer.implementacion;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beeva.Bancomer.dao.BancoDao;
import com.beeva.Bancomer.modelo.Banco;
import com.beeva.Bancomer.modelo.Cliente;
import com.beeva.Bancomer.modelo.Cuenta;

@Repository
public class BancoImp extends BancoDao{
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	@Transactional
	public void agregarBanco(Banco banco) {
		em.persist(banco);		
	}

	@Override
	@Transactional
	public void deposito(double cantidad, Cliente cliente, Cuenta cuenta) {
		if(cliente.getIdcliente() == cuenta.getIdCliente()){
			double balanceCuenta = cuenta.getBalance();
			double newBalance = cantidad+balanceCuenta;
				cuenta.setBalance(newBalance);
				em.merge(cuenta);
				System.out.println("Su Operacion Se Ha Realizado");
			}else{
				System.out.println("Lo Sentimos la Operacion no pudo ser atendida");				
			}}		

	      @Override
	      @Transactional
	      public void retiro(double op, Cuenta cuenta) {
		  if(cuenta.getIdTipoCuenta() == 1){
		  if(cuenta.getBalance()<5000){
				System.out.println("Tienes una Cantidad por debajo de tu saldo  -YOU CANT NOT REMOVE");
			}
		    else
		    {
			double retiro=cuenta.getBalance()- op;			
			cuenta.setBalance(retiro);
			           System.out.println("Tu Saldo Actual es de ==  "+retiro+ " == \n");
			           em.merge(cuenta);
			}}
		       else if(cuenta.getIdTipoCuenta()==2){
			
			   Calendar now = Calendar.getInstance();
			   String[] strDays = new String[]{"Domingo","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado"};
			   String hoy = strDays[now.get(Calendar.DAY_OF_WEEK) - 1] ;
					
		        if(hoy == "Domingo" || hoy == "Sabado"){
				System.out.println("Dias Inhabiles para Retirar "+ hoy );}
			
			    else{
				double ori=cuenta.getBalance() - op;
				cuenta.setBalance(ori);
				em.merge(cuenta);
				System.out.println("Tu Saldo Actual es == "+ori);
			    }}}}
