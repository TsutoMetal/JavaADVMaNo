package clase03;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringBufferInputStream;
import java.net.Socket;
public class ClienteMinimo {
    public static void main(String[] args) throws Exception{
        new BufferedReader(
            new InputStreamReader(
                new Socket("10.12.1.107",8000).getInputStream())
        )
                .lines()
                .forEach(System.out::println);
        
        //Socket so=new Socket("10.12.1.107",8000);
        //InputStream in=so.getInputStream();
        //BufferedReader in = new BufferedReader(
        //        new InputStreamReader(so.getInputStream()));
        //in.lines().forEach(item -> System.out.println(item));      
        //in.lines().forEach(System.out::println);
        /*
        int car;
        while((car=in.read())!=-1){
            System.out.print((char)car);
        }
        System.out.println();
        */
        //in.close();
        //so.close();
    }
}