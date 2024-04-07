import java.util.ArrayList;

public class ImionaNaLitere {
    public ArrayList<Imie> lista = new ArrayList<>();
    public final String litera;
    public void pokaz(){
        for (Imie el: lista){
            el.pokaz();
        }
    }


    ImionaNaLitere(String litera) {
        this.litera=litera;
    }
}
