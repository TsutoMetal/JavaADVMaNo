package ar.com.eduit.curso.java.clase03;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
public class ClienteMinimo {
    public static void main(String[] args) throws Exception {
        /*
        Socket so=new Socket("10.12.1.24",8000);
        InputStream in=so.getInputStream();
        //int car;
        //while((car=in.read())!=-1){
        //    System.out.print((char)car);
        //}
        //System.out.println();
        
        BufferedReader in2=new BufferedReader(new InputStreamReader(in));
        //in2.lines().forEach(item -> System.out.println(item));
        in2.lines().forEach(System.out::println);
        */
        
        new BufferedReader(
                new InputStreamReader(
                        new Socket("10.12.1.24",8000).getInputStream()))
                .lines().forEach(System.out::println);
        
        
    }
}