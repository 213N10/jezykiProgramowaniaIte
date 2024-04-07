import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.util.ArrayList;

public class Gui2 extends JFrame {
    ArrayList<Integer>lista=new ArrayList<>();
     WykresKolowy wykres = new WykresKolowy();


    public static void main(String[] args) {
        Gui2 ramka = new Gui2();
        ramka.wykres.dodajKol(Color.WHITE, 0);

        ramka.add(ramka.wykres);

    }


    public void check(String value, Color color){
        try{
            Integer pomoc = Integer.valueOf(value);
            lista.add(pomoc);
            wykres.dodajKol(color,pomoc);
        }catch (Exception e1){
            System.out.println("Podano złe dane");
        }
    }
    public void delete(String value, Color color){
        try{
            lista.remove(Integer.valueOf(value));
            wykres.usunKol(color);
            wykres.revalidate();
            wykres.repaint();
        }catch(Exception e11){
            System.out.println("Podano złe dane");
        }
    }

    public void printlist(){
        System.out.println(lista);

    }
    Gui2(){
        //config okna
        super("Jan Zieniewicz Zadanie 2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200,200,600,600);
        setMinimumSize(new Dimension(700,500));

        setLayout(new GridLayout(1,3));
        //panele robocze
        JPanel panel1 = new JPanel(new GridLayout(10,1));
        JPanel panel2 = new JPanel(new GridLayout(10,1));
        add(panel1);
        add(panel2);

        //dodanie elementów
        JTextField tekst1 =new JTextField();
        JTextField tekst2 =new JTextField();
        JTextField tekst3 =new JTextField();
        JTextField tekst4 =new JTextField();
        JTextField tekst5 =new JTextField();
        JTextField tekst6 =new JTextField();
        JTextField tekst7 =new JTextField();
        JTextField tekst8 =new JTextField();
        JTextField tekst9 =new JTextField();
        JTextField tekst10 =new JTextField();
        panel1.add(tekst1);
        panel1.add(tekst2);
        panel1.add(tekst3);
        panel1.add(tekst4);
        panel1.add(tekst5);
        panel1.add(tekst6);
        panel1.add(tekst7);
        panel1.add(tekst8);
        panel1.add(tekst9);
        panel1.add(tekst10);
        JCheckBox box1 = new JCheckBox();
        box1.addItemListener(e -> {

            if (e.getStateChange()== ItemEvent.SELECTED) {
                check(tekst1.getText(), Color.darkGray);


            }
            else if (e.getStateChange()== ItemEvent.DESELECTED) {
                delete(tekst1.getText(),Color.darkGray);

            }
            printlist();
        });

        JCheckBox box2 = new JCheckBox();
        box2.addItemListener(e -> {
            if (e.getStateChange()== ItemEvent.SELECTED) check(tekst2.getText(), Color.BLUE);
            else if (e.getStateChange()== ItemEvent.DESELECTED) delete(tekst2.getText(), Color.BLUE);
            printlist();
        });
        JCheckBox box3 = new JCheckBox();
        box3.addItemListener(e -> {
            if (e.getStateChange()== ItemEvent.SELECTED) check(tekst3.getText(), Color.BLACK);
            else if (e.getStateChange()== ItemEvent.DESELECTED) delete(tekst3.getText(), Color.BLACK);
            printlist();
        });
        JCheckBox box4 = new JCheckBox();
        box4.addItemListener(e -> {
            if (e.getStateChange()== ItemEvent.SELECTED) check(tekst4.getText(), Color.GREEN);
            else if (e.getStateChange()== ItemEvent.DESELECTED) delete(tekst4.getText(), Color.GREEN);
            printlist();
        });
        JCheckBox box5 = new JCheckBox();
        box5.addItemListener(e -> {
            if (e.getStateChange()== ItemEvent.SELECTED) check(tekst5.getText(), Color.PINK);
            else if (e.getStateChange()== ItemEvent.DESELECTED) delete(tekst5.getText(), Color.PINK);
            printlist();
        });
        JCheckBox box6 = new JCheckBox();
        box6.addItemListener(e -> {
            if (e.getStateChange()== ItemEvent.SELECTED) check(tekst6.getText(), Color.RED);
            else if (e.getStateChange()== ItemEvent.DESELECTED) delete(tekst6.getText(), Color.RED);
            printlist();
        });
        JCheckBox box7 = new JCheckBox();
        box7.addItemListener(e -> {
            if (e.getStateChange()== ItemEvent.SELECTED) check(tekst7.getText(), Color.MAGENTA);
            else if (e.getStateChange()== ItemEvent.DESELECTED) delete(tekst7.getText(), Color.MAGENTA);
            printlist();
        });
        JCheckBox box8 = new JCheckBox();
        box8.addItemListener(e -> {
            if (e.getStateChange()== ItemEvent.SELECTED) check(tekst8.getText(),Color.YELLOW);
            else if (e.getStateChange()== ItemEvent.DESELECTED) delete(tekst8.getText(), Color.YELLOW);
            printlist();
        });
        JCheckBox box9 = new JCheckBox();
        box9.addItemListener(e -> {
            if (e.getStateChange()== ItemEvent.SELECTED) check(tekst9.getText(), Color.CYAN);
            else if (e.getStateChange()== ItemEvent.DESELECTED) delete(tekst9.getText(),Color.CYAN);
            printlist();
        });
        JCheckBox box10 = new JCheckBox();
        box10.addItemListener(e -> {
            if (e.getStateChange()== ItemEvent.SELECTED) check(tekst10.getText(), Color.ORANGE);
            else if (e.getStateChange()== ItemEvent.DESELECTED) delete(tekst10.getText(), Color.ORANGE);
            printlist();
        });
        panel2.add(box1);
        panel2.add(box2);
        panel2.add(box3);
        panel2.add(box4);
        panel2.add(box5);
        panel2.add(box6);
        panel2.add(box7);
        panel2.add(box8);
        panel2.add(box9);
        panel2.add(box10);
        setVisible(true);
        System.out.println(lista);
    }


}
