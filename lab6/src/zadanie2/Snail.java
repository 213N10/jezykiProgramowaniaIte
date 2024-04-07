package zadanie2;

import java.util.ArrayList;
import java.util.Random;

public class Snail extends Thread {
    private int eating_speed;
    private int sleeping_time;

    public int w;
    public int h;

    public Snail(int h, int w, int eating_speed, int sleeping_time) {
        this.eating_speed = eating_speed;
        this.sleeping_time = sleeping_time;
        this.w = w;
        this.h = h;

    }

    @Override
    public void run() {
        while (true) {
            while (Map.mapa[h][w].getFood() > 0) {
                try {
                    Map.mapa[h][w].consume(this.eating_speed);
                    Map.mapaGui[h][w].setBackground(Map.mapa[h][w].kolor);
                    Map.mapaText[h][w].setText(String.valueOf(Map.mapa[h][w].getFood()));
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            //tutaj wstawić ifa z wyborem czy idzie spac czy sie rusza
            int[] pomoc=chooseNextLeaf();
            if (pomoc[0]==-1){
                try{
                    Thread.sleep(this.sleeping_time);
                }catch(Exception e){
                    System.out.println("spanie");
                }
            }else{
                move(pomoc);
            }

        }

    }
// w move trzeba zrobić z voida inta i jesli sie powiedzie to zwraca zero jak nie to 1 i wtedy run zdecyduje czy czeka czy sie rusza
    private void move(int[] lokacja) {// dodac to co nizej opisane jesli chooseNL zwraca 0,0
        try {
            Map.mapa[h][w].take_insect();
            Map.mapaGui[h][w].setBackground(Map.mapa[h][w].kolor);
            this.h = lokacja[0];
            this.w=lokacja[1];
            Map.mapa[h][w].give_insect();
            Map.mapaGui[h][w].setBackground(Map.mapa[h][w].kolor);
            System.out.println("ruch");
            Thread.sleep(3000);

        } catch (Exception e) {
            System.out.println(e);
        }


    }
//choose naprawiony
    private int[] chooseNextLeaf() {
        int w=0;
        int h=0;
        int biggestValue = 0;
        ArrayList<int[]> opcje = new ArrayList<>();
        ArrayList<int[]> najlepsze = new ArrayList<>();
        ArrayList<Integer> sasiedztwo = new ArrayList<>();
        for (int i = this.h - 1; i <= this.h + 1; i++) {
            for (int j = this.w - 1; j <= this.w + 1; j++) {
                try {
                    if (Map.mapa[i][j].getFood()>=biggestValue && Map.mapa[i][j].has_worm==false) {
                        biggestValue= Map.mapa[i][j].getFood();
                        w=j;
                        h=i;
                        int[] pomoc={Map.mapa[i][j].getFood(),i,j};
                        opcje.add(pomoc);
                    }
                    sasiedztwo.add(Map.mapa[i][j].getFood());

                } catch (Exception e) {System.out.println("nextLeaf");}
            }
        }
        if (biggestValue==0) {// nie ma gdzie się ruszyć
            int[] pomoc = {-1, -1};
            return pomoc;
        }
        // losowanie ruchu
        for(int[] el:opcje){
            if (el[0]==biggestValue) najlepsze.add(el);
        }
        for (int[] el:najlepsze) System.out.println(el[0]);
        if (najlepsze.size()>1){ //losuje jak jest pare opcji
            Random srand = new Random();
            int[] pomoc = najlepsze.get(srand.nextInt(najlepsze.size()));
            int[] tymczas={pomoc[1],pomoc[2]};
            return tymczas;
        }
        else{//jak jest tylko 1 opcja
            int[] pomoc = {h, w};
            return pomoc;
        }
        //if biggest =0 to znaczy ze trzeba zaczaekac chwile i jeszcze raz odpalic funkcje
        //System.out.println(sasiedztwo);//do testów
        //System.out.println(biggestValue+" "+h+" "+w);//do testów

    }
}