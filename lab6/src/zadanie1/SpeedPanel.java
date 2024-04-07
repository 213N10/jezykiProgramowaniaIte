package zadanie1;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.ArrayList;

public class SpeedPanel extends JPanel implements ChangeListener {
    private int width=400;
    private int height=800;
    private int panelsNmbr;
    static ArrayList<JSlider> sliders = new ArrayList<>();
    SpeedPanel(int numberOfPanels){
        this.panelsNmbr=numberOfPanels;
        setLayout(new GridLayout(numberOfPanels,1));
        panelsInit();
        //setBackground(Color.RED);
        setVisible(true);
    }
    private void panelsInit(){
        for (int i=0;i<this.panelsNmbr;i++){
            costumPanels(BigCircle.allCircles[i].getSpeed());
        }

    }
    private void costumPanels(int initSpeed){
        JSlider pomoc = new JSlider(JSlider.HORIZONTAL, 0,15,initSpeed);
        pomoc.setMinorTickSpacing(1);
        pomoc.setMajorTickSpacing(5);
        pomoc.setPaintLabels(true);
        pomoc.setPaintTicks(true);
        pomoc.addChangeListener(this);
        sliders.add(pomoc);
        this.add(pomoc);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider) e.getSource();
        int index=sliders.indexOf(source);
        int value= source.getValue();
        BigCircle.allCircles[index].setSpeed(value);

    }
}
