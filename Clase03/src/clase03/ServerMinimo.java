package clase03;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class ServerMinimo {
    public static void main(String[] args) {
        // http://10.12.1.107:8000/
        //String mensaje="<h1>Servidor de Carlos.</h1>";
        String mensaje=System.getProperties()+"\n"+System.getenv();
        mensaje="HTTP/1.1 200 OK\n"
                + "Content-Type: text/html\n"
                + "Content-Length: "+mensaje.length()+"\n\n"
                + mensaje;
        try(ServerSocket ss=new ServerSocket(8000)){
           while(true){
               System.out.println("Esperando una conexión de cliente ...");
               try(
                       Socket so=ss.accept();
                       OutputStream out=so.getOutputStream();
                ){
                   System.out.println("Se conecto "+so.getInetAddress());
                   out.write(mensaje.getBytes());
               } catch (Exception ex) { ex.printStackTrace(); }
           }
        }catch(Exception e){e.printStackTrace();}       
    }
}