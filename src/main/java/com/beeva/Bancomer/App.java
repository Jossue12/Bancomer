package com.beeva.Bancomer;

import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.beeva.Bancomer.dao.BancoDao;
import com.beeva.Bancomer.dao.BancosClientesDao;
import com.beeva.Bancomer.dao.ClienteDao;
import com.beeva.Bancomer.dao.CuentaDao;
import com.beeva.Bancomer.dao.TipoCuentaDao;
import com.beeva.Bancomer.implementacion.BancoImp;
import com.beeva.Bancomer.implementacion.BancosClientesImp;
import com.beeva.Bancomer.implementacion.ClienteImp;
import com.beeva.Bancomer.implementacion.CuentaImp;
import com.beeva.Bancomer.implementacion.TipoCuentaImp;
import com.beeva.Bancomer.modelo.Banco;
import com.beeva.Bancomer.modelo.BancosClientes;
import com.beeva.Bancomer.modelo.Cliente;
import com.beeva.Bancomer.modelo.Cuenta;
import com.beeva.Bancomer.modelo.TipoCuenta;

public class App {
    public static void main( String[] args ){
      
       	String nombre;
    	String apellido;
    	int tipo, totalClientes;
    	int tipoCuenta = 1;
    	int tipoBanco = 1;
    	String tipoDeCuenta;
    	String tipoDeBanco;
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("core-context.xml");
    	ClienteDao clienteDao = (ClienteDao)context.getBean(ClienteImp.class);
    	TipoCuentaDao tipoCuentaDao = (TipoCuentaDao)context.getBean(TipoCuentaImp.class);
    	BancoDao bancoDao = (BancoDao)context.getBean(BancoImp.class);
    	CuentaDao cuentaDao = (CuentaDao)context.getBean(CuentaImp.class);
    	BancosClientesDao bancosClientesDao= (BancosClientesDao)context.getBean(BancosClientesImp.class);
    	Scanner in = new Scanner(System.in);
    	
    	TipoCuenta tipoCuenta1 = new TipoCuenta();  	//implementacion de cuentas y bancos
    	TipoCuenta tipoCuenta2 = new TipoCuenta();
    	
    	Banco banco1 = new Banco();
    	Banco banco2 = new Banco();
    	Banco banco3 = new Banco();
    	Banco banco4 = new Banco();
    	Banco banco5 = new Banco();
    	
        tipoCuenta1.setNombre("Cheques");   
        tipoCuenta2.setNombre("Ahorros");   
        banco1.setNombre("Banorte");       
        banco2.setNombre("Inbursa");       
        banco3.setNombre("Bancomer");
        banco4.setNombre("Banamex");
    	banco5.setNombre("Santander");
    	
        tipoCuentaDao.agregarTipoCuenta(tipoCuenta1); //selccion de cuentas
        tipoCuentaDao.agregarTipoCuenta(tipoCuenta2);
      
        bancoDao.agregarBanco(banco1);                  //seleccion de bancos
        bancoDao.agregarBanco(banco2);
        bancoDao.agregarBanco(banco3);
        bancoDao.agregarBanco(banco4);
        bancoDao.agregarBanco(banco5);
        
        System.out.println("Cuantos Clientes Quieres Ingresar??");
          totalClientes = in.nextInt();
            Cliente cliente[] = new Cliente[totalClientes];
          Cuenta cuenta[] = new Cuenta[totalClientes];
        BancosClientes bancosClientes[] = new BancosClientes[totalClientes];
          
             for(int i = 0; i < totalClientes; i++){
   
        	cliente[i] = new Cliente();
        	cuenta[i] = new Cuenta();
        	bancosClientes[i] = new BancosClientes();
        	System.out.println("Agregar al cliente num: " + (i+1));
            System.out.println("Nombre: ");
        	nombre = in.next();
        	cliente[i].setNombre(nombre);
        	
        	System.out.println("Apellido: ");
        	apellido = in.next();
        	cliente[i].setApellido(apellido);
        	
        	System.out.println("Que tipo de banco necesita (-Banorte-  -Inbursa-  -Bancomer-  -Banamex-  -Santander-): ");
        	tipoDeBanco = in.next();
        	
        	if(tipoDeBanco.equals("Banorte") || tipoDeBanco.equals("banorte")){
        	tipoBanco = 1;
        	} 
        	    else if(tipoDeBanco.equals("Inbursa") || tipoDeBanco.equals("inbursa")) {
        		tipoBanco = 2;
        		
        	}  
        	    else if(tipoDeBanco.equals("Bancomer") || tipoDeBanco.equals("bancomer")){
        		tipoBanco = 3;
        		
        	}   else if(tipoDeBanco.equals("Banamex") || tipoDeBanco.equals("banamex")){
            	tipoBanco = 4;
        	}
        	    else if(tipoDeBanco.equals("Santander") || tipoDeBanco.equals("sanatander")){
        		tipoBanco = 5;		
        	} 
        	    else {
        		System.out.println("Banco Inexistente, intantalo otra vez");
        		i--;
        		continue;
        	}
        	
        	System.out.println("Eliga una Cuenta (Cheques o Ahorros):\n ");
        	tipoDeCuenta = in.next();
        	        	
        	if(tipoDeCuenta.equals("Cheques") || tipoDeCuenta.equals("cheques"))
        	{
        		tipoCuenta = 1;
        	} 
        	    else if(tipoDeCuenta.equals("Ahorros") || tipoDeCuenta.equals("ahorros")){
        		tipoCuenta = 2;
        	} 
        	    else {
                      System.out.println(" Cuenta no Valida :( , Intentar de nuevo");
        		      i--;
        		      continue;}
        	
        	try{
        	clienteDao.agregarCliente(cliente[i]);
        	
        	cuenta[i].setBalance(0.0);
        	cuenta[i].setIdTipoCuenta(tipoCuenta);
        	cuenta[i].setIdCliente(cliente[i].getIdcliente());
        	
        	cuentaDao.agregarCuenta(cuenta[i]);
        	
        	bancosClientes[i].setIdBanco(tipoBanco);
        	bancosClientes[i].setIdCliente(cliente[i].getIdcliente());
        	
        	bancosClientesDao.agregarBancosClientes(bancosClientes[i]);
        	}
        	    catch (Exception e)
        	{
        		e.printStackTrace();
        	}
        	    boolean salir = false;
                int opcion; //Guardaremos la opcion del usuario
             
            while(!salir){
            	
           	    System.out.println("Selecciona una Opcion ");
                System.out.println("1. Depositar");
                System.out.println("2. Retirar");
                System.out.println("3. Salir");
                                
                opcion = in.nextInt();
                
                switch(opcion){
                case 1:
               	    System.out.println("Cuanto va a depositar?\n");
            		bancoDao.deposito(in.nextDouble(),cliente[i],cuenta[i]);
            		System.out.println(" || Deposito Realizado Exitosamente ||\n\n");
                    break;
                    
                case 2:
               	     System.out.println("Cuanto va a retirar?");
               	     bancoDao.retiro(in.nextDouble(), cuenta[i]);
               	     System.out.println("!! Retiro exitoso ¡¡");
                    break;
                    
                 case 3:
                	// System.out.println("Seguro que desea Salir ?");
                	 System.exit(0);
                    salir=true;
                    break;
                    default:
                    }}}}
            
                private static boolean isNumeric(String next) {
		        try{
			
	               int num = Integer.parseInt( next );
	               return true;}
	    
	            catch( NumberFormatException err ){
	            return false;
	            }}}




