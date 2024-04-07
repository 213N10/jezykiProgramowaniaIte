package zadanie1;

import java.awt.*;

public class SmallCircle extends Thread{

    private Color kolor;
    public boolean isWaiting=true;
    public int positionX;
    public int positionY;
    private int xCenter = 800 / 2;
    private int yCenter = 800 / 2;
    private double radius = 300;
    private int degree;
    private int speedDegree;
    private SmallCircle poprzednik;

     SmallCircle(int degreePocz, int speedDegree,Color kolor ){
         this.degree=degreePocz;
         this.speedDegree=speedDegree;
         this.kolor=kolor;

         firstLocation(degree);
     }

    @Override
    public void run() {

        //double radius = 600 / 3;
        while(true){

            if (degree>360) degree-=360;
            for (; degree <= 360; degree+=speedDegree) {
                while (this.isWaiting) {
                    synchronized(this){
                        try{
                            wait();
                        }catch (InterruptedException e){}
                    }
                }
                double radians = Math.toRadians(degree);
                int pomocX =(int) ((radius * Math.cos(radians)) + xCenter);
                int pomocY =(int) ((radius * Math.sin(radians)) + yCenter);
                if (checkDistance(pomocX,pomocY)<=60){
                    this.speedDegree= poprzednik.getSpeed();
                    int index=-1;
                    for (int i = 0; i < BigCircle.allCircles.length; i++) {
                        if (BigCircle.allCircles[i]==this) index=i;
                    }
                    SpeedPanel.sliders.get(index).setValue(this.speedDegree);
                    degree= poprzednik.degree-10;
                    this.positionX=(int) ((radius * Math.cos(radians)) + xCenter);
                    this.positionY=(int) ((radius * Math.sin(radians)) + yCenter);
                }
                else{
                    this.positionX = pomocX;
                    this.positionY = pomocY;
                }


                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }


        }

    }
    private int checkDistance(int x, int y){
         int pomocx=(int)(Math.pow(x - this.poprzednik.positionX, 2));
         int pomocy=(int)(Math.pow(y - this.poprzednik.positionY, 2));
         int pomoc = pomocx + pomocy;
         int distance =(int) Math.sqrt(pomoc);
         return distance;
    }
    public void setNeighbour(SmallCircle somsiad){
         this.poprzednik=somsiad;
    }

    public void firstLocation(int degree){
        double radians = Math.toRadians(degree);
        this.positionX =(int) ((radius * Math.cos(radians)) + xCenter);
        this.positionY =(int)( (radius * Math.sin(radians)) + yCenter);
        System.out.println(positionX+ " "+ positionY);

    }
    public void paint(Graphics g){
         g.setColor(kolor);
         g.fillOval(this.positionX,this.positionY,50,50);
    }
    public void setSpeed(int n){
         this.speedDegree=n;
    }
    public int getDeegre(){return this.degree;}
    public void setDegree(int degree1){this.degree=degree1;}
    public int getSpeed(){return this.speedDegree;}
    public void setWaiting(boolean ans){this.isWaiting=ans;}
    //public boolean isWaiting(){return this.isWaiting;}

}
