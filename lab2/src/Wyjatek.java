import java.util.ArrayList;

public class Wyjatek extends Exception{
    public Wyjatek(/*String errorMesage, Throwable error,*/ ArrayList<Samochod> lista){
        //super(errorMesage, error);
        for (Samochod el:
             lista) {
            el.show();
        }
    }
}
