import java.util.LinkedList;
//Klasa do przetestowania ale powinno być git
public class Koszyk {
    private LinkedList<Produkt> koszyk = new LinkedList<>();
    public void add(Produkt item){koszyk.add(item);}
    //public void remove
    public void show(){
        for (Produkt item: koszyk) {
            String wynik=String.format(" Nazwa produktu: %s,\n Kod produktu: %s,\n Cena produktu: %.2f\n", item.get_nazwa(), item.get_kod(),item.get_cena());
            System.out.println(wynik);
        }
    }
    public double cart_price(){
        double help=0;
        for(Produkt item: koszyk){
            help = help + item.get_cena();
        }
        return help;
    }
    public void remove(String nazwa){
        for (Produkt item: koszyk){
            if (item.get_nazwa().equals(nazwa)){
                koszyk.remove(item);
                break;
            }
        }
    }
}
