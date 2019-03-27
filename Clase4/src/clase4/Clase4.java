package clase4;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
public class Clase4 {
    public static void main(String[] args) {
        // Clase 4 Serializado de Objetos
        String file="personas.dat";
        
        try (ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(file)); ){
            out.writeObject(new Persona("Juan","Perez",23));
            out.writeObject(new Persona("Laura","Mendez",33));
            out.writeObject(new Persona("Jose","Garcia",43));
            out.writeObject(new Persona("Lorena","Godoy",34));
            out.writeObject(new Persona("Rodolfo","Segovia",45));
            out.writeObject(new Persona("Mariela","Lescano",31));
            out.writeObject(new Persona("Ana","Mendez",49));
        } catch (Exception e) { e.printStackTrace(); }
        
        List<Persona>lista=new ArrayList();
        
        try (ObjectInputStream in=new ObjectInputStream(new FileInputStream(file));) {
            while(true){
                Persona p=(Persona)in.readObject();
                System.out.println(p);
                lista.add(p);
            }
        } catch (EOFException e) { System.out.println("Fin del archivo.");
        } catch (Exception e) { e.printStackTrace(); }
        
        
        
        System.out.println("**************************************************");
        // select * from personas;
        lista.forEach(System.out::println);
        
        System.out.println("**************************************************");
        // select nombre from personas;
        lista.stream().map(Persona::getNombre).forEach(System.out::println);
        
        System.out.println("**************************************************");
        // select nombre from personas where edad < 30;
        lista.stream().filter(p-> p.getEdad()<30).map(Persona::getNombre).forEach(System.out::println);
        
        System.out.println("**************************************************");
        // select * from personas where edad>30
        lista.stream().filter(p-> p.getEdad()>30).forEach(System.out::println);

        System.out.println("**************************************************");
        // select * from personas order by edad
        lista.stream().sorted(Comparator.comparingInt(Persona::getEdad)).forEach(System.out::println);
        
        System.out.println("**************************************************");
        // select * from personas order by edad desc
        lista
                .stream()
                .sorted(Comparator.comparingInt(Persona::getEdad).reversed())
                .forEach(System.out::println);
        
        System.out.println("**************************************************");
        // select * from personas where edad>30 order by edad desc
        lista
                .stream()
                .filter(p->p.getEdad()>30)
                .sorted(Comparator.comparingInt(Persona::getEdad).reversed())
                .forEach(System.out::println);
        
        System.out.println("**************************************************");
        // select nombre from personas where edad>30 order by edad desc
                lista
                .stream()
                .filter(p->p.getEdad()>30)
                .sorted(Comparator.comparingInt(Persona::getEdad).reversed())
                .map(Persona::getNombre)
                .forEach(System.out::println);
                
                lista.forEach(item->System.out.println(item.getNombre()+" "+item.getApellido()));
        System.out.println("**************************************************");
        // select nombre, apellido from personas where edad>30 order by edad desc
            lista
                .stream()
                .filter(p->p.getEdad()>30)
                .sorted(Comparator.comparingInt(Persona::getEdad).reversed())
                .forEach(item->System.out.println(item.getNombre()+" "+item.getApellido()));
        
        // comparable
            lista.stream().sorted().forEach(System.out::println);
          
        System.out.println("**************************************************");
        // select apellido, count(*) from personas group by apellido
        
        lista.stream().collect(
                //especificamos las funciones de agrupación
                Collectors.groupingBy(Persona::getApellido, Collectors.counting())
        ).forEach((k,v)->System.out.println("apellido: "+k+" cantidad: "+v));
            
        
    }
}