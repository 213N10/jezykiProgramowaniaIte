import edu.colorado.io.EasyReader;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static ArrayList<Samochod> rosnaco(ArrayList<Samochod> lista) {
        int dlugosc = lista.size();
        for (int i = 0; i < dlugosc; i++) {
            for (int j = 1; j <= dlugosc-1; j++) {
                if (lista.get(j-1).get_rok() > lista.get(j).get_rok()) {
                    Samochod pomoc = lista.get(j-1);
                    lista.set(j-1, lista.get(j));
                    lista.set(j, pomoc);
                }
            }
        }
        return lista;
    }
    public static ArrayList<Samochod> malejaco(ArrayList<Samochod> lista) {
        int dlugosc = lista.size();
        for (int i = 0; i < dlugosc; i++) {
            for (int j = 1; j <= dlugosc-1; j++) {
                if (lista.get(j-1).get_rok() < lista.get(j).get_rok()) {
                    Samochod pomoc = lista.get(j-1);
                    lista.set(j-1, lista.get(j));
                    lista.set(j, pomoc);
                }
            }
        }
        return lista;
    }



    public static void main(String[] args) {
        int liczba_samochodow=0;
        String wybor;
        String tryb_wyswietlenia="";
        int rok;
        edu.colorado.io.EasyReader input = new EasyReader(System.in);
        ArrayList<Samochod> pomoc = new ArrayList<>();
        ArrayList<Samochod> ostateczny= new ArrayList<>();

        if (args[0].matches("[0-9]+")) liczba_samochodow=Integer.parseInt(args[0]);
        else{
            System.out.println("błędne dane");
            System.exit(0);
        }
        if (args[1].equalsIgnoreCase("r") || args[1].equalsIgnoreCase("w")) tryb_wyswietlenia=args[1].toLowerCase() ;
        else {
            System.out.println("błędne dane");
            System.exit(0);
        }

        Samochod[] lista = new Samochod[liczba_samochodow];
        //generowanie listy samochodów z losowymi parametrami
        for (int i=0; i<liczba_samochodow;i++){
            lista[i]= new Samochod();
            //lista[i].show();
        }

        System.out.println("""
                wybierz tryb:
                najstarszy
                najmłodszy
                nie młodszy niż
                nie starszy niż
                """);
        wybor = input.stringInputLine();
        //System.out.println(wybor);

        switch(wybor){
            case "nie młodszy niż":    //Nie młodszy niż rok
                System.out.println("Podaj rok: ");
                rok= input.intInput();
                for (Samochod samochod : lista) {
                    if (samochod.get_rok() < rok) pomoc.add(samochod);
                }
                ostateczny = rosnaco(pomoc);
                break;

            case "najstarszy"://najstarszy
                Collections.addAll(pomoc, lista);
                ostateczny = rosnaco(pomoc);


                break;
            case "nie starszy niż"://Nie starszy niż
                System.out.println("Podaj rok: ");
                rok= input.intInput();
                for (Samochod samochod : lista) {
                    if (samochod.get_rok() > rok) pomoc.add(samochod);
                }
                ostateczny = malejaco(pomoc);
                break;

            case "najmłodszy"://najmłodszy
                Collections.addAll(pomoc, lista);
                ostateczny = malejaco(pomoc);
                break;
            default:
                System.out.println("bledne dane");
        }

        if(tryb_wyswietlenia.equals("r")){
            for (Samochod el:
                 ostateczny) {
                el.show();
            }

        } else if (tryb_wyswietlenia.equals("w")) {
            try {
                throw new Wyjatek(ostateczny);
            } catch (Wyjatek e) {
                System.out.println(e);
                //throw new RuntimeException(e);
            }
        }
    }


}

