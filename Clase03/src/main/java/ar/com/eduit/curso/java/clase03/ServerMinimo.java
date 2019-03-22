package ar.com.eduit.curso.java.clase03;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class ServerMinimo {
    public static void main(String[] args) {
        //String mensaje="<h1>Servidor de Carlos</h1>";
        String mensaje=System.getProperties()+"\n"+System.getenv();
        //String mensaje=System.getProperty("user.name");
        mensaje="HTTP/1.1 200 OK\n"
                + "Content-Length: "+mensaje.length()+"\n\n"
                + mensaje;
        try (ServerSocket ss=new ServerSocket(8000)) { //Try with resources jdk7
            while(true){
                System.out.println("Esperando conexión de cliente.");
                try(
                        Socket so=ss.accept();
                        OutputStream out=so.getOutputStream();
                ){
                    System.out.println("Se conecto "+so.getInetAddress());
                    out.write(mensaje.getBytes());
                }catch(Exception ee){ ee.printStackTrace(); }
            } 
        } catch (Exception e) { 
            e.printStackTrace(); 
        }
        
    }
}