package zadanie1;

import javax.swing.*;
import java.awt.*;

public class GUI1 extends JFrame {
    int ilosc_kolek;
    JButton startStop;
    private int ilosc_startow=0;
    private boolean move= false;

    GUI1(int nmbr_crcl){
        super("Jan Zieniewicz Zadanie 6.1");
        this.ilosc_kolek=nmbr_crcl;
        setLayout(null);
        setMinimumSize(new Dimension(1200,900));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BigCircle container =new BigCircle(nmbr_crcl);
        container.setBounds(0,0,800,800);

        startStop = new JButton("Start/stop");
        startStop.addActionListener(e -> {
            if (this.move){
                System.out.println("stop");
                this.move=false;
                container.pauseCircles();
            }
            else if (!this.move && ilosc_startow==0){
                System.out.println("start");
                this.move=true;
                container.startCircles();
                ilosc_startow++;
                container.resumeCircles();
            }
            else if (!this.move && ilosc_startow!=0){
                this.move=true;
                System.out.println("start");
                container.resumeCircles();
            }
        });
        startStop.setBounds(0,800,800,50);

        SpeedPanel ustawienia = new SpeedPanel(nmbr_crcl);
        ustawienia.setBounds(800,0,400,900);

        add(container);
        add(startStop);
        add(ustawienia);

        setVisible(true);
    }
}
