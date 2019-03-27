package clase4;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClienteSerializable {
    public static void main(String[] args) {
        try (
                Socket so=new Socket("10.8.6.27",8000);
                ObjectOutputStream out=new ObjectOutputStream(so.getOutputStream());
                ObjectInputStream in=new ObjectInputStream(so.getInputStream());
        ){
            out.writeObject(new Persona("Carlos","Ríos",46));
            System.out.println(in.readUTF());
        } catch (Exception e) { e.printStackTrace(); }
    }
}