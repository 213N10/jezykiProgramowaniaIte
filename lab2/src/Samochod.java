import java.util.Random;

public class Samochod {
    private int cena;
    private int rok;
    private int marka;
    private String maarka[]= {"POLONEZ", "FIAT", "SYRENA"};

    Samochod (){
        Random losowanie = new Random();
        this.rok= losowanie.nextInt(2023-1950)+1950;
        this.cena = losowanie.nextInt(100, 5000000);
        this.marka = losowanie.nextInt(3);
    }
    public int get_rok(){return this.rok;}
    public void show(){
        String podsumowanie = String.format("Marka samochodu: %s; Rocznik: %d; Cena (w pln): %d", Marka.valueOf(this.maarka[this.marka]), this.rok, this.cena);
        System.out.println(podsumowanie);
    }
}
