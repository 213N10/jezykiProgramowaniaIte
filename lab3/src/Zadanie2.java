import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Zadanie2 {
    //static ArrayList<ArrayList<ArrayList<ImionaNaLitere>>> wynik = new ArrayList<>();
    static ArrayList<String> szukaneImiona = new ArrayList<>();
    static ArrayList<ImionaNaLitere> wynik = new ArrayList<>(26);
    static ArrayList<String> imionaPlik1 = new ArrayList<>();
    static ArrayList<String> imionaPlik2 = new ArrayList<>();
    static ArrayList<String> imionaPlik3 = new ArrayList<>();
    public static void main(String[] args){
        //wczytuje szukane imiona z enuma oraz od razu sortuje je alfabetycznie
        for (Imiona el : Imiona.values()) {
            szukaneImiona.add(el.getImie().toLowerCase());
        }//od razu wczytuje dane
        szukaneImiona.sort(String.CASE_INSENSITIVE_ORDER);
        //System.out.println(szukaneImiona);
        try{
            File plik1 = new File(args[0]);
            File plik2 = new File(args[1]);
            File plik3 = new File(args[2]);
            //System.out.println(plik3.exists());
            imionaPlik1=dataCheck(plik1);
            imionaPlik2=dataCheck(plik2);
            imionaPlik3=dataCheck(plik3);
            //System.out.println(imionaPlik1);
            dodanieLiter();
            dodanieImion();
            for (ImionaNaLitere el: wynik){
                el.pokaz();
            }

        } catch (Exception e){
            System.out.println("Złe dane");
            System.exit(7);


        }


    }
    public static void dodanieLiter(){
        ArrayList<String> literki=new ArrayList<>(26);
        for (String el: szukaneImiona){
            if (!literki.contains(String.valueOf((el.charAt(0))))){
                literki.add(String.valueOf((el.charAt(0))));
            }
        }
        for(String litera: literki){
            wynik.add(new ImionaNaLitere(litera));
        }
    }
    public static void dodanieImion(){
        for (String imie: szukaneImiona){
            Imie pomoc = new Imie(imie);
            pomoc.zliczanie(imionaPlik1,imionaPlik2,imionaPlik3);
            for (ImionaNaLitere listaL: wynik){
                if(listaL.litera.equals(pomoc.litera)){
                    listaL.lista.add(pomoc);
                }
            }
        }
    }
    public static ArrayList<String> dataCheck(File plik) throws Exception {
        ArrayList<String> imiona = new ArrayList<>();

        try{
            Scanner skaner = new Scanner(plik);
            while (skaner.hasNextLine()){
                String line = skaner.nextLine();
                if (szukaneImiona.contains(line.toLowerCase())){
                    imiona.add(line);
                }
            }
            skaner.close();
            return imiona;
        }
        catch(FileNotFoundException e){
            throw new Exception(e);
        }

    }


}
