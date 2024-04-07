package zadanie1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;


public class BigCircle extends JPanel {
    private int agentNumber;
    public static SmallCircle[] allCircles;
    int size=400;
    Timer czas;

    private int delay=50;
    BigCircle(int agentNumber){
        setMinimumSize(new Dimension(size,size));
        this.agentNumber=agentNumber;
        allCircles = new SmallCircle[agentNumber];
        circlesInit();
        czas = new Timer(delay,taskperformer);
        czas.setRepeats(true);
        czas.start();


    }
    ActionListener taskperformer  = e -> repaint();

    private void circlesInit() {

        Random rand = new Random();
        ArrayList<Integer> occupied = new ArrayList<>();
        for (int i=0;i<agentNumber;i++){
            int lokalizacja=rand.nextInt(0,36);

            while(occupied.contains(lokalizacja)){
                lokalizacja = rand.nextInt(0, 36);
            }
            SmallCircle pomoc = new SmallCircle(lokalizacja*10,rand.nextInt(0,15),randomColor());
            allCircles[i]=pomoc;
            occupied.add(lokalizacja);

        }
        for (int i =0; i<allCircles.length-1;i++){
            for (int j = 0; j < allCircles.length-1; j++) {
                if (allCircles[j].getDeegre()<allCircles[j+1].getDeegre()){
                    SmallCircle tymczas = allCircles[j];
                    allCircles[j]=allCircles[j+1];
                    allCircles[j + 1] = tymczas;
                }
            }
        }
        for (SmallCircle elem:allCircles) System.out.println(elem.getDeegre());
        for (int i=0;i<agentNumber;i++){
            if (i==0) allCircles[i].setNeighbour(allCircles[allCircles.length-1]);
            else if (i>=1) {
                allCircles[i].setNeighbour(allCircles[i - 1]);
            }
        }
    }


    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawOval(125,125,600,600);
        for (SmallCircle element: allCircles) {
            element.paint(g);
        }
    }

    public void startCircles()  {
        for (SmallCircle element: allCircles) {
            element.start();
        }
    }
    public void pauseCircles(){
        for (SmallCircle element: allCircles) {
            element.setWaiting(true);
        }
    }
    public void resumeCircles(){
        for (SmallCircle element: allCircles) {
            element.setWaiting(false);
            while(element.getState()== Thread.State.WAITING){
                synchronized (element) {
                    element.notify();
                }
            }
        }
    }
    private Color randomColor(){
        Random rand = new Random();
        return new Color(rand.nextInt(50,255),rand.nextInt(50,255),rand.nextInt(50,255));
    }

}
