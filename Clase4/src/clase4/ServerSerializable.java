package clase4;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class ServerSerializable implements Runnable{
    public static void main(String[] args) {
        new Thread(new ServerSerializable()).start();
    }
    @Override public void run() {
        try (ServerSocket ss=new ServerSocket(8000);) {
            while(true){
                System.out.println("Esperando conexión de cliente.");
                try (
                    Socket so=ss.accept();
                    ObjectInputStream in=new ObjectInputStream(so.getInputStream());
                    ObjectOutputStream out=new ObjectOutputStream(so.getOutputStream());
                ){
                    System.out.println("Se conecto "+so.getInetAddress());
                    Persona p=(Persona)in.readObject();
                    System.out.println(p);
                    out.writeUTF("Se recibio el objeto.");
                } catch (Exception ee) { ee.printStackTrace(); }
            }
        } catch (Exception e) { e.printStackTrace(); }
    }  
}