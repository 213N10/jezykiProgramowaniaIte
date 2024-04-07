public class Produkt {
    //nie ma co zmieniać :))
    private double cena;
    private String nazwa;
    private String kod;
    Produkt(String kod, String nazwa, double cena){
        this.cena=cena;
        this.nazwa = nazwa;
        this.kod=kod;

    }
    public double get_cena(){
        return this.cena;
    }
    public String get_nazwa(){
        return this.nazwa;
    }
    public String get_kod(){
        return this.kod;
    }
    public void show(){
        String pomocnik = String.format("%s, %s, %.2f", kod, nazwa, cena);
        System.out.println(pomocnik);
    }
}
