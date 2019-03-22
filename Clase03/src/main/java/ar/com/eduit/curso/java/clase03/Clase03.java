package ar.com.eduit.curso.java.clase03;
public class Clase03 {
    public static void main(String[] args) {
        /*
            Clase 03
            Arquitectura de comunicaciones (tcp/ip).
        
        Server                                  Client
        ---------------                         ---------------
        new ServerSocket(int port)              new Socket(String host, int port)
        .accept()
        ---------------                         ---------------
        OutputStream        -------------->     InputStream
        InputStream         <--------------     OutputStream
        ---------------                         ---------------
        .close()                                .close()
        
        BufferedInputStream - BufferedOutputStream:     buffers
        DataInputStream -   DataOutputStream:           tipo de datos nativos de java
        ObjetctInputStream - ObjectOutputStream:        Objetos de java
        
        */
    }
}