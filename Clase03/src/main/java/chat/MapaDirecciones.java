package chat;
import java.util.Map;
import java.util.TreeMap;
public class MapaDirecciones {
    public static Map<String,String> getMapa(){
        Map<String,String>mapa=new TreeMap();
        mapa.put("Carlos", "10.12.1.24");
        mapa.put("Edson", "10.12.0.135");
        mapa.put("Rodo", "10.12.0.4");
        mapa.put("Christian", "10.12.1.54");
        mapa.put("Enzo", "10.10.10.10");
        return mapa;
    }
}