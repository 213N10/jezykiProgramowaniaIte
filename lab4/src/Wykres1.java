
import java.util.ArrayList;


public class Wykres1 {
    ArrayList<Skladowa> lista = new ArrayList<>();
    public void dodaj(Integer value){
        boolean pomoc=false;
        String nazwa = String.valueOf(value);

        for (Skladowa el: lista){
            if (el.name.equals(nazwa)) {
                el.value += value;
                pomoc=true;
            }
        }
        if (!pomoc) {
            lista.add(new Skladowa(value));
        }

    }
    public void show(){
        if (lista.isEmpty()) System.out.println("pusta lista");
        for(Skladowa el:lista){
            el.show();
        }
    }
    public void usun(Integer value){
        String nazwa = String.valueOf(value);
        for(Skladowa el:lista){
            if(el.name.equals(nazwa)){
                el.value -= value;
                if (el.value==0) {
                    lista.remove(el);
                    break;
                }
            }
        }

    }
    public void edycja(Integer nowe, Integer stare){
        usun(stare);
        dodaj(nowe);
    }
}
