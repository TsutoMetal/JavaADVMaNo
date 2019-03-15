package clase02;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class Clase02 {
    public static void main(String[] args) {
        class Cuenta{
            private float saldo=0;
            public void depositar(float monto){
                System.out.println("Iniciando transacción de deposito.");
                synchronized(this){ //sincronizado de método parcial
                    try{ Thread.sleep(2000); } catch(Exception e) {}
                    saldo+=monto;
                }
                System.out.println("Deposito terminado");
            }
            public void debitar(float monto){
                System.out.println("Iniciando transacción de debito.");
                synchronized(this){
                    if(monto<=saldo && monto>=0){
                        try{ Thread.sleep(2000); } catch(Exception e) {}
                        saldo-=monto;
                    }else{
                        System.out.println("Saldo insuficiente!!!!");
                    }
                }
            }
            public synchronized float getSaldo() {
                return saldo;
            }           
        }//end class cuenta
        class Cliente implements Runnable{
            private Cuenta cuenta;
            public Cliente(Cuenta cuenta) {
                this.cuenta = cuenta;
            }
            @Override public void run(){
                cuenta.debitar(10000);
                System.out.println(cuenta.saldo);
            }
        }//end class Cliente
        class Empleador implements Runnable{
            private Cuenta cuenta;
            public Empleador(Cuenta cuenta) {
                this.cuenta = cuenta;
            }
            @Override public void run(){
                cuenta.depositar(50000);
                System.out.println("Sueldo depositado.");
            }
        }//End class Empleador
        /*
        Cuenta cuenta=new Cuenta();
        Empleador empleador=new Empleador(cuenta);
        Cliente cliente=new Cliente(cuenta);
        new Thread(empleador).start();
        try{ Thread.sleep(100); } catch(Exception e) {}
        new Thread(cliente).start();
        */
        
        Hashtable<String,String> table=new Hashtable();
        table.put("lu", "lunes");
        
        HashMap<String,String> mapa=new HashMap();
        mapa.put("lu", "lunes");
        
        Map<String,String> mapaSinc=Collections.synchronizedMap(new HashMap<String,String>());
        class Saludo{
            public synchronized void saludar(String nombre, boolean esJefe){
                if(esJefe){
                    System.out.println("Jefe: Hola a todos!");
                    notify();
                    notify();
                    notifyAll();
                }else{
                    try { wait(); } catch(Exception e) {}
                    System.out.println("llego "+nombre+": hola Jefe");
                }
            }
        }
        class Empleado implements Runnable{
            private String nombre;
            private boolean esJefe;
            private Saludo saludo;
            public Empleado(String nombre, boolean esJefe, Saludo saludo) {
                this.nombre = nombre;
                this.esJefe = esJefe;
                this.saludo = saludo;
            }
            @Override public void run(){
                System.out.println("Llego -> "+nombre);
                saludo.saludar(nombre, esJefe);
            }
        }//end class Empleado
        
        System.out.println("**************************************************");
        Saludo saludo=new Saludo();
        
        Empleado ana=new Empleado("Ana",false,saludo);
        Empleado luis=new Empleado("Luis",false,saludo);
        Empleado jose=new Empleado("Jose",false,saludo);
        Empleado laura=new Empleado("Laura",false,saludo);
        Empleado jefe=new Empleado("Jefe",true,saludo);
        
        new Thread(ana).start();
        new Thread(luis).start();
        new Thread(jose).start();
        new Thread(laura).start();
        try{Thread.sleep(20);} catch(Exception e){}
        new Thread(jefe).start();
        
        
        
      
        
        
        
        
        
    }
}
