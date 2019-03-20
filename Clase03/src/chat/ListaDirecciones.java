package chat;
import java.util.Map;
import java.util.TreeMap;
public class ListaDirecciones {
    public static Map<String,String>getMapa(){
        Map<String,String> mapa=new TreeMap();
        mapa.put("Carlos", "10.12.1.107");
        mapa.put("Nahuel", "10.12.1.223");
        mapa.put("Tomas", "10.12.1.12");
        mapa.put("Guido", "10.12.0.157");
        mapa.put("Hernan", "10.12.0.58");
        mapa.put("Luis", "10.12.1.14");
        mapa.put("Adrian", "10.12.0.32");
        mapa.put("Joseph", "10.12.0.51");
        mapa.put("Gonzalo", "10.12.0.26");
        mapa.put("Lucio", "10.12.0.52");
        mapa.put("Nahuel2", "10.12.0.148");
        return mapa;
    }
}
