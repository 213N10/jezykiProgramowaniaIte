package zadanie2;

import javax.swing.*;
import java.awt.*;


public class Zadanie2 {
    public static void main(String[] args) {
        int height=0;
        int width=0;
        int agent_number=0;
        try{
            height = Integer.parseInt(args[0]);
            width = Integer.parseInt(args[1]);
            agent_number = Integer.parseInt(args[2]);
        }catch(Exception e){
            System.out.print("""
                    Podano nieprawidłowe dane. Sprawdź:\s
                    1. Czy podane liczby są całkowitymi...
                    """);
            System.exit(99);
        }
        if (width<=0 && height<=0){
            System.out.print("""
                    Podano nieprawidłowe dane. Sprawdź:\s
                    1. Czy podane liczby są całkowitymi dodatnimi...
                    """);
            System.exit(99);
        }
        if ((width*height*0.4)+1<agent_number){
            System.out.print("""
                    Podano nieprawidłowe dane. Sprawdź:\s
                    1. czy liczba agentów (ślimaków) nie jest zbyt duża...
                    """);
            System.exit(99);
        }


        Map my_map = new Map(height, width,agent_number);
        JFrame ramka =new JFrame("Zadanie 6.2 Jan Zieniewicz");
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ramka.setMinimumSize(new Dimension(500,500));
        ramka.add(my_map);
        ramka.setVisible(true);
        //my_map.showMapa();
        for(Snail slimak : Map.listaSnail){
            slimak.start();
        }
        LeafThread watek = new LeafThread(30000);
        watek.start();
    }
}
