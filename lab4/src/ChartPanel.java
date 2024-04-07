import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


class ChartPanel extends JPanel {
    //List<Integer> wartosciWycinkow;
    ArrayList<Skladowa>listaWycinkow;
    ArrayList<Integer> dlugoscWycinkow=new ArrayList<>();
    int startAngle = 0;
    ChartPanel(ArrayList<Skladowa> listaWycinkow, Integer suma){
        this.listaWycinkow=listaWycinkow;
        for (Skladowa skladowa : listaWycinkow) {
            this.dlugoscWycinkow.add((skladowa.value/suma)*360);
        }
        this.setPreferredSize(new Dimension(300,500));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        setVisible(true);
    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        if(dlugoscWycinkow.size()!=0){
            for(int i=0;i<dlugoscWycinkow.size();i++){
                g2D.setPaint(listaWycinkow.get(i).kolor);
                g2D.fillArc(10,10,380,380,startAngle,dlugoscWycinkow.get(i));
                startAngle+=dlugoscWycinkow.get(i);
            }
        }
    }
}