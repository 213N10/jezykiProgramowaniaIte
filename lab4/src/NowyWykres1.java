import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

class NowyWykres1 extends JPanel {
    ArrayList<Skladowa> wycinki = new ArrayList<>();
    double total=0D;
    NowyWykres1() {
        wycinki.add(new Skladowa(0));
    }
    public void paint(Graphics g) {
        rysujWykres((Graphics2D) g, getBounds(), wycinki);
    }


    void rysujWykres(Graphics2D g, Rectangle area, ArrayList<Skladowa> wycinki) {
        double total=0D;
        for (int i = 0; i < wycinki.size(); i++) {
            total += wycinki.get(i).value;
        }

        double curValue = 0.0D;
        int startAngle = 0;
        for (int i = 0; i < wycinki.size(); i++) {
            startAngle = (int) (curValue * 360 / total);
            int arcAngle = (int) (wycinki.get(i).value * 360 / total);

            g.setColor(wycinki.get(i).kolor);
            g.fillArc(area.x, area.y, area.width, area.height, startAngle, arcAngle);
            curValue += wycinki.get(i).value;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        NowyWykres1 wykres = new NowyWykres1();
        frame.getContentPane().add(wykres);
        frame.setSize(300, 200);
        frame.setVisible(true);
        wykres.wycinki.add(new Skladowa(5));
        wykres.wycinki.add(new Skladowa(6));
        wykres.repaint();
    }
}


