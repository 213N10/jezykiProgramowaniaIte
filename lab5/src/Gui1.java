import javax.swing.*;
import java.awt.*;


public class Gui1 extends JFrame {
    JTextField a1tf = new JTextField("a1");
    JTextField a2tf = new JTextField("a2");
    JTextField a3tf = new JTextField("a3");
    JTextField b1tf = new JTextField("b1");
    JTextField b2tf = new JTextField("b2");
    JTextField b3tf = new JTextField("b3");
    JTextField c1tf = new JTextField("c0");
    JTextField c2tf = new JTextField("c1");
    JTextField c3tf = new JTextField("c2");
    JTextField c4tf = new JTextField("c3");
    JButton guzik = new JButton("Wynik");
    JTextField znak = new JTextField();
    private Integer a;
    private Integer b;
    private String[] lista= new String[4];
    private Integer wynik;
    JLabel wynik0 =new JLabel("c0=");

    JLabel wynik1 =new JLabel("c1=");
    JLabel wynik2 =new JLabel("c2=");
    JLabel wynik3 =new JLabel("c3=");
    Gui1(){
        setMinimumSize(new Dimension(950,500));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font czcionka=new Font("Verdana", Font.PLAIN, 20);
        setLayout(new GridLayout(1,5));
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();
        panel1.setLayout(new GridLayout(4, 1));

        wynik0.setFont(czcionka);
        wynik1.setFont(czcionka);
        wynik2.setFont(czcionka);
        wynik3.setFont(czcionka);
        a1tf.setFont(czcionka);
        a2tf.setFont(czcionka);
        a3tf.setFont(czcionka);
        b1tf.setFont(czcionka);
        b2tf.setFont(czcionka);
        b3tf.setFont(czcionka);
        c1tf.setFont(czcionka);
        c2tf.setFont(czcionka);
        c3tf.setFont(czcionka);
        c4tf.setFont(czcionka);
        znak.setFont(new Font("Verdana", Font.PLAIN, 50));
        JLabel jlabel = new JLabel("Wartości a1,a2,a3:");
        jlabel.setFont(czcionka);
        panel1.add(jlabel);
        panel1.add(a1tf);
        panel1.add(a2tf);
        panel1.add(a3tf);
        panel2.setLayout(new GridLayout(4, 1));
        JLabel jlabel2 = new JLabel("Wartości b1,b2,b3:");
        jlabel2.setFont(czcionka);
        panel2.add(jlabel2);
        panel2.add(b1tf);
        panel2.add(b2tf);
        panel2.add(b3tf);
        panel3.setLayout(new GridLayout(5, 1));
        JLabel jlabel3 = new JLabel("Wartości c1,c2,c3,c4:");
        jlabel3.setFont(czcionka);
        panel3.add(jlabel3);
        panel3.add(c1tf);
        panel3.add(c2tf);
        panel3.add(c3tf);
        panel3.add(c4tf);
        guzik.addActionListener(n-> {
            try{
                a=Integer.parseInt(a1tf.getText())*100+Integer.parseInt(a2tf.getText())*10+Integer.parseInt(a3tf.getText());
                b=Integer.parseInt(b1tf.getText())*100+Integer.parseInt(b2tf.getText())*10+Integer.parseInt(b3tf.getText());
                if (znak.getText().equals("+")) wynik=a+b;
                else if (znak.getText().equals("-")) wynik=a-b;
                else if (znak.getText().equals("*")) wynik=a*b;
                else System.out.println("wprowadzono złe dane");
                lista[0] = c1tf.getText();
                lista[1] = c2tf.getText();
                lista[2] = c3tf.getText();
                lista[3] = c4tf.getText();
                Integer[] wyniki_zmiennych=wyznaczanie_zmiennych(wynik, lista);

                if (lista[0].matches("[0-9]+")){
                    wynik0.setText(String.format("c0=%d ",wyniki_zmiennych[0]));
                }
                else {
                    wynik0.setText(String.format("%s=%d ",c1tf.getText(),wyniki_zmiennych[0]));
                }
                if (lista[1].matches("[0-9]+")){
                    wynik1.setText(String.format("c1=%d ",wyniki_zmiennych[1]));
                }else wynik1.setText(String.format("%s=%d ",c2tf.getText(),wyniki_zmiennych[1]));
                if (lista[2].matches("[0-9]+")) wynik2.setText(String.format("c2=%d ",wyniki_zmiennych[2]));
                else wynik2.setText(String.format("%s=%d ",c3tf.getText(),wyniki_zmiennych[2]));
                if (lista[3].matches("[0-9]+")) wynik3.setText(String.format("c3=%d ",wyniki_zmiennych[3]));
                else wynik3.setText(String.format("%s=%d ",c4tf.getText(),wyniki_zmiennych[3]));

                }catch(Exception e){
                System.out.println("Podano złe dane");
            }
        });
        guzik.setFont(czcionka);
        panel4.setLayout(new GridLayout(2,1));
        panel4.add(znak);
        panel4.add(guzik);
        panel5.setLayout(new GridLayout(4,1));
        panel5.add(wynik0);
        panel5.add(wynik1);
        panel5.add(wynik2);
        panel5.add(wynik3);

        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);
        add(panel5);
        setVisible(true);
    }
    public Integer[] wyznaczanie_zmiennych(Integer wynik, String[] arr) {
        Integer[] pomoc = new Integer[4];
        int[] pomoc2 = new int[4];
        for (int i = 0; i < arr.length; i++) {
            try {
                pomoc[i] = Integer.parseInt(arr[i])*(int)Math.pow(10,3-i);
                pomoc2[i]=1;
            } catch (Exception e) {
                pomoc[i] = 0;
                pomoc2[i]= 0;
            }
        }
        for (Integer integer : pomoc) {
            wynik = wynik - integer;
        }
        if (pomoc2[3]==0) {
            pomoc[3]=wynik%10;
            wynik-=pomoc[3];
        }
        if (pomoc2[2]==0) {
            pomoc[2]=wynik%100;
            wynik-=pomoc[2];

        }
        if (pomoc2[1]==0) {
            pomoc[1]=wynik%1000;
            wynik-=pomoc[1];
            System.out.println(wynik);

        }
        //if (pomoc2[0]==0) {
            pomoc[0]=wynik/1000;
            wynik-=pomoc[0];

        //}
        for (int i=1;i< pomoc.length;i++){
            pomoc[i] = pomoc[i] / (int) Math.pow(10, 3 - i);
        }
        System.out.println();
        for (Integer integer : pomoc) {
            System.out.println(integer);
        }
        return pomoc;
    }
    public static void main(String[] args) {
        new Gui1();
    }
}
