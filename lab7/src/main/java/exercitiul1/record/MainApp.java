package exercitiul1.record;

import java.io.File;
import java.io.IOException;
import java.util.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
public class MainApp {
    public static void scriere(Map<Integer, Carte> lista) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File("src/main/resources/carti.json");
            mapper.writeValue(file, lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<Integer, Carte> citire() {
        try {
            File file = new File("src/main/resources/carti.json");
            ObjectMapper mapper = new ObjectMapper();
            Map<Integer, Carte> carti = mapper.readValue(file, new TypeReference<Map<Integer, Carte>>() {});
            return carti;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Map<Integer, Carte> carti = citire();
        carti.forEach((id, carte) -> {
            System.out.println("id:" +id);
            System.out.print(carte.toString());
            System.out.println();
        });

        System.out.println("2----------------");
        Scanner scanner =new Scanner(System.in);
        int nr;
        System.out.println("Introduceti id-ul pe care doriti sa il stergeti: ");
         nr= scanner.nextInt();
        int idCarteSters = nr;
        carti.remove(idCarteSters);


        System.out.println("3----------------");
        carti.putIfAbsent(7,new Carte(7,"Titlu","Autorul7", 2018));
        carti.forEach((id,carte)->System.out.println("id: " + id + " " + carte));


        System.out.println("4----------------");
        scriere(carti);

        System.out.println("5----------------");
        //Set<Carte> cartes = Collections.newSetFromMap(Map<Integer,Carte>);
    }
}

