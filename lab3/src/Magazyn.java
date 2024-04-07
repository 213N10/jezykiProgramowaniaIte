import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.*;

public class Magazyn {

    File plik = new File("src/magazyn.txt");
    private List<Produkt> magaz = new LinkedList<>();
    public void dodaj_artykuly(){
        try{
            Scanner skaner = new Scanner(plik);
            while (skaner.hasNextLine()){
                String line = skaner.nextLine();
                String[] pomoc=line.split(";");
                Produkt pomocniczy = new Produkt(pomoc[0], pomoc[1], Double.parseDouble(pomoc[2]));
                magaz.add(pomocniczy);
            }
            skaner.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
    public void dodaj_artykul(){
        System.out.println("Podaj kod artykułu, nazwę oraz cenę (oddzielone spacją): ");
        try {
            Scanner skan = new Scanner(System.in);
            String pomoc = skan.nextLine();
            String[] pomocnicza=pomoc.split(" ");
            boolean istnieje = false;
            for(Produkt prod:magaz){
                if (prod.get_nazwa().equals(pomocnicza[0])) istnieje=true;
            }
            if (!istnieje){
                Produkt pomocniczy = new Produkt(pomocnicza[0], pomocnicza[1], Double.parseDouble(pomocnicza[2]));
                magaz.add(pomocniczy);
            }
            else{
                System.out.println("istnieje produkt o podanym id");
            }

        }
        catch(Exception e){
            System.out.println("operacja dodania produktu się nie powiodła");
        }
    }

    public void save_state(){
        try{
            FileWriter plik = new FileWriter("src/magazyn.txt");
            BufferedWriter zapis = new BufferedWriter(plik);
            for(Produkt el:magaz){
                String pomocnik = String.format(Locale.US,"%s;%s;%.2f\n", el.get_kod(), el.get_nazwa(), el.get_cena());
                zapis.write(pomocnik);
            }
            zapis.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public void show_mag(){
        for (Produkt el: magaz){
            el.show();
        }
    }

    public boolean check_product(String nazwa){
        boolean pomoc = false;
        for(Produkt el:magaz){
            if (nazwa.toLowerCase().equals(el.get_nazwa())){
                el.show();
                pomoc = true;
            }
        }
        return pomoc;
    }

    public int countChar(String str, char c)
    {
        int count = 0;

        for(int i=0; i < str.length(); i++)
        {    if(str.charAt(i) == c)
            count++;
        }

        return count;
    }
    public void szukaj(String nazwa){   
        int counter=0;

        if (nazwa.contains("*")) { 
            nazwa = nazwa.replace("*", "(.*)").toLowerCase();
            for (Produkt el:magaz){
                if (el.get_nazwa().matches(nazwa)){
                    el.show();
                    counter++;
                }
            }


        } else if (nazwa.contains("?")) {
            nazwa = nazwa.replace("?", "(.?)").toLowerCase();
            for(Produkt el:magaz){
                if (el.get_nazwa().matches(nazwa)){
                    el.show();
                    counter++;
                }
            }

        } else{
            for(Produkt el:magaz){
                if (nazwa.toLowerCase().equals(el.get_nazwa())){
                    el.show();
                    counter++;
                }
            }
        }
        if (counter==0){
            System.out.println("nie ma takiego produktu");
        }
    }
    public Produkt pobierz_artykul(String nazwa){
        for(Produkt el:magaz){
            if (nazwa.toLowerCase().equals(el.get_nazwa())){
                el.show();
                magaz.remove(el);
                return el;
            }
        }
        return new Produkt("0", "0", 0.0);

    }

}
