package zadanie2;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Map extends JPanel{
    private int width;
    private int height;
    public static Leaf [][] mapa;
    public static Snail[] listaSnail;
    public static JPanel[][] mapaGui;
    public static JLabel[][] mapaText;
    private int snailNumber;

    Map(int h, int w, int agent_number){
        this.width=h;
        this.height=w;
        this.snailNumber=agent_number;

        mapa = new Leaf[width][height];
        listaSnail = new Snail[snailNumber];
        mapaGui=new JPanel[this.width][height];
        mapaText = new JLabel[width][height];
        setLayout(new GridLayout(width,height));
        map_init();
        setVisible(true);

    }
    private void map_init(){
        Random rand = new Random();
        int addedSnails=0;
        for (int i=0; i<width; i++){
            for (int j=0; j<height;j++){
                if (addedSnails<snailNumber){
                    boolean pomocb= rand.nextBoolean();
                    mapa[i][j]=(new Leaf(rand.nextInt(10),pomocb));
                    if (pomocb) {
                        listaSnail[addedSnails] = new Snail(i,j,1,5000);
                        try{
                            Thread.sleep(rand.nextInt(66,875));
                        }catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                        addedSnails++;
                    }
                }
                else mapa[i][j]=(new Leaf(rand.nextInt(10),false));


                JPanel pomoc = new JPanel();
                JLabel pomocniczy = new JLabel(String.valueOf(mapa[i][j].getFood()));
                pomocniczy.setForeground(Color.WHITE);
                mapaText[i][j]=pomocniczy;
                pomoc.add(pomocniczy);
                pomoc.setBackground(mapa[i][j].kolor);
                pomoc.setVisible(true);
                mapaGui[i][j]=pomoc;
                this.add(mapaGui[i][j]);
            }
        }
        //tutaj dodać check czy zgadza się ilośc dodanych ślimaków

    }
    public static void map_refresh(){
        for (int i =0; i<mapa.length; i++){
            for (int j=0; j<mapa[i].length; j++){
                mapaGui[i][j].setBackground(mapa[i][j].kolor);
                mapaText[i][j].setText(String.valueOf(mapa[i][j].getFood()));
            }
        }
    }
    public void showMapa(){
        for (int i=0; i<mapa.length; i++){
            for (int j=0; j<mapa[i].length;j++){
                System.out.printf("%d", mapa[i][j].getFood());
            }
            System.out.println();
        }
    }


}
