package chat;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import javax.swing.JTextArea;
public class ChatServer implements Runnable{
    private JTextArea txa;
    public ChatServer(JTextArea txa) { this.txa = txa; }
    @Override public void run(){
        try(ServerSocket ss=new ServerSocket(7000)){
            while(true){
                try (
                        Socket so=ss.accept();
                        BufferedReader in=new BufferedReader(
                                new InputStreamReader(so.getInputStream()));
                    ) {
                    String linea="";
                    Map<String,String> mapa=MapaDirecciones.getMapa();
                    for(String k: mapa.keySet()){
                        if(mapa.get(k).equals(so.getInetAddress().getHostAddress()))
                            linea+=k+" : ";
                    };
                    linea+= in.readLine();
                    txa.append(linea+"\n");
                } catch (Exception ee) { ee.printStackTrace(); }        
            }
        }catch(Exception e){ e.printStackTrace(); }
    }
}