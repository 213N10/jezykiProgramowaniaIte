package zadanie2;

import java.awt.*;

public class Leaf {
    final Color[] kolors = {new Color(255, 255, 255), new Color(76, 175, 80),new Color(68, 158, 72),new Color(61, 140, 64), new Color(53, 122, 56), new Color(46, 105, 48), new Color(38, 88, 40),new Color(30, 70, 32), new Color(23, 53, 24), new Color(15, 35, 16), new Color(8, 17, 8)};
    private int food;

    boolean has_worm;
    public Color kolor;
    Leaf(int food, boolean worm){
        this.has_worm=worm;
        if (food>0 || food<=10) {
            this.food=food;
        }
        else {this.food=0;}
        if (worm) this.kolor = Color.RED;
        else kolor=(kolors[this.food]);

    }
    public synchronized void consume(int eating_speed){
        this.food-=eating_speed;
        if (this.food<0) this.food=0;
        if (this.food>=10) this.food=10;
        if (!this.has_worm) kolor=(kolors[this.food]);
    }
    public int getFood(){
        return this.food;
    }

    public void give_insect(){
        has_worm=true;
        kolor=Color.red;
    }
    public void take_insect(){
        has_worm=false;
        kolor=(kolors[this.food]);

    }

}
