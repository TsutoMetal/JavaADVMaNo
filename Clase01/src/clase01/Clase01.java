package clase01;
public class Clase01 {
    public static void main(String[] args) {
        /*
        Curso: Java advanced  15 horas
        Días: Martes 19:00 a 22:00 hs
        Profe: Carlos Ríos  carlos.rios@educacionit.com
        
        software:   jdk 8.X     netbeans 8.X
        
                    jdk 11      netbeans 10
        
        LTS Long Term Support   (soporte por 8 años)
        
        Version         Fecha Liberado          Fecha Fin Soporte
        8 LTS           Marzo 2014              Marzo 2022
        9               Septiembre 2017         Marzo 2018
        10              Marzo 2018              Septiembre 2018
        11 LTS          Septiembre 2018         Septiembre 2026
        12              Marzo 2019              Septiembre 2019
        13              Septiembre 2019         Marzo 2020
        14 LTS          Marzo 2020              Marzo 2028
        
        JDK Alternativo         OpenJDK
        
        */
        
        /*
        Programación de Hilos
        
        Tarea 1:        Leer archivo 1 del medio 1      10 s
        Tarea 2:        Leer archivo 2 del medio 2      10 s
        Tarea 3:        Abrir form y mostrar contenido   1 s
        
           Tarea 1    Tarea 2  Tarea 3
        |----------|----------|-|
            10 s        10 s   1 s
        
        Tiempo Total 21 s
        
           Tarea 1
        |----------|
            10 s 
        
           Tarea 2
        |----------|
            10 s 
        
                     Tarea 3
                    |-|
                     1 s
        
        Tiempo Total 11 s 
        
           Tarea 1
        |----------|
            10 s 
        
           Tarea 2
        |----------|
            10 s 
        
         Tarea 3
        |-|
         1 s
        
        Tiempo Total 10 s
        
        */
        
        System.out.println("Cantidad de nucleos cpu: "+
                Runtime.getRuntime().availableProcessors());
        
        //declaración de clase interna
        class HiloT extends Thread{
            String nombre;

            public HiloT(String nombre) {
                this.nombre = nombre;
            }
            
            @Override
           public void run(){
               //Este método se ejecuta en un hilo nuevo
               for(int a=1;a<=10;a++){
                   System.out.println(nombre+" "+a);
                   try { Thread.sleep(1000); } catch(Exception e) {}
               }
           }
            
        }// end class HiloT
        
        
        HiloT hiloT1=new HiloT("Hilo 1");
        HiloT hiloT2=new HiloT("Hilo 2");
        HiloT hiloT3=new HiloT("Hilo 3");
        HiloT hiloT4=new HiloT("Hilo 4");
        
        //El método run no ejecuta la tarea en un hilo nuevo
        //hiloT1.run();
        //hiloT2.run();
        //hiloT3.run();
        //hiloT4.run();
        
        //El método start() invoca al método run() en nuevo hilo
        //hiloT1.start();
        //hiloT2.start();
        //hiloT3.start();
        //hiloT4.start();
        
        // Interfaz Runnable
        class HiloR implements Runnable{
            String nombre;
            public HiloR(String nombre) {
                this.nombre = nombre;
            }
            @Override
            public void run() {
                for(int a=1;a<=10;a++){
                    System.out.println(nombre+" "+a);
                    try { Thread.sleep(1000); } catch(Exception e) {}
                }
            }
        }// end class HiloR
        
        HiloR hiloR1=new HiloR("Hilo 1");
        HiloR hiloR2=new HiloR("Hilo 2");
        HiloR hiloR3=new HiloR("Hilo 3");
        HiloR hiloR4=new HiloR("Hilo 4");
        
        Thread tHilo1=new Thread(hiloR1);
        Thread tHilo2=new Thread(hiloR2);
        Thread tHilo3=new Thread(hiloR3);
        Thread tHilo4=new Thread(hiloR4);
        
        tHilo1.start();
        tHilo2.start();
        tHilo3.start();
        tHilo4.start();
        new Thread(new HiloR("Hilo 5")).start();
        Thread tHilo6=new Thread(new HiloR("Hilo 6"));
        tHilo6.start();
        
    }// end main
}// end class Clase01