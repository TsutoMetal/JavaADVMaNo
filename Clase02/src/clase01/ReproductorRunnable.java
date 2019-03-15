package clase01;
import java.io.FileInputStream;
import javazoom.jl.player.Player;
public class ReproductorRunnable implements Runnable{
    public static void main(String[] args) throws Exception {
        Player player = new Player(
                new FileInputStream( "res/condor.mp3")
        );
        player.play();
    }
    @Override public void run(){
        try {
            Player player = new Player(
                new FileInputStream( "res/condor.mp3")
            );
            player.play();
        } catch (Exception e) { System.out.println(e); }
    }
}