package chat;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JTextArea;
public class ChatServer implements Runnable {
    private JTextArea txaChat;
    public ChatServer(JTextArea txaChat) { this.txaChat = txaChat; }
    @Override public void run(){
        try (ServerSocket ss=new ServerSocket(7000)){
            while(true){
                try (Socket so=ss.accept();
                    BufferedReader in=new BufferedReader(
                            new InputStreamReader(so.getInputStream())) 
                    ){
                    String ip=so.getInetAddress().getHostAddress();
                    for(String k:ListaDirecciones.getMapa().keySet()){
                        if(ip.equals(ListaDirecciones.getMapa().get(k))){
                            ip=k;
                            break;
                        }
                    }
                    String mensaje=in.readLine();
                    txaChat.append(ip+" : "+mensaje+"\n");
                } catch (Exception ee) { ee.printStackTrace(); }
            }
        } catch (Exception e) { e.printStackTrace(); }
    }
}