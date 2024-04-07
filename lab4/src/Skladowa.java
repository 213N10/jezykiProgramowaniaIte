import java.awt.*;
import java.util.Random;

public class Skladowa {

    String name;
    int value;
    Color kolor;


    Skladowa(Integer name){
        Random r = new Random();
        this.name=String.valueOf(name);
        this.kolor = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256), r.nextInt(256));
        this.value=name;
    }
    public void show(){
        String tekst=String.format("%s, %d", name, value);
        System.out.println(tekst);
    }
}
