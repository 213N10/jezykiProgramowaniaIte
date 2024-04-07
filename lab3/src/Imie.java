import java.util.ArrayList;

public class Imie {
    public final String imie;
    public final String litera;
    public int powtorzenia1=0;
    public int powtorzenia2=0;
    public int powtorzenia3=0;
    Imie(String imie){
        this.imie=imie;
        this.litera = String.valueOf(imie.charAt(0));
    }
    public void zliczanie(ArrayList<String>lista1,ArrayList<String>lista2,ArrayList<String>lista3){
        for (String el:lista1){
            if (el.toLowerCase().equals(this.imie)){
                this.powtorzenia1++;
            }
        }
        for (String el:lista2){
            if (el.toLowerCase().equals(this.imie)){
                this.powtorzenia2++;
            }
        }
        for (String el:lista3){
            if (el.toLowerCase().equals(this.imie)){
                this.powtorzenia3++;
            }
        }
    }
    public void pokaz(){
        String pods= String.format("%s: plik1: %d; plik2: %d; plik3: %d", imie, powtorzenia1,powtorzenia2, powtorzenia3);
        System.out.println(pods);
    }

}
