package clase01;
import javax.swing.JTextField;
public class CronometroRunnable implements Runnable{
    private JTextField txt; 
    private int cont=0;
    private boolean correr=false;
    public CronometroRunnable(JTextField txt) {
        this.txt = txt;
    }
    @Override public void run(){
        while(true){
            if(correr){
                cont++;
                txt.setText(cont+"");
            }
            try{ Thread.sleep(1000); }catch(Exception e){}
        }
    }
    public void start(){
        correr=true;
    }
    public void pause(){
        correr=false;
    }
    public void stop(){
        correr=false;
        cont=0;
        txt.setText("0");
    }
    
}