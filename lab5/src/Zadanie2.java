import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;


public class Zadanie2 implements MouseListener {
    private JButton ABCButton;
    private JButton DEFButton;
    private JButton GHIButton;
    private JButton JKLButton;
    private JButton MNOButton;
    private JButton PQRButton;
    private JButton STUVButton;
    private JButton WXYZButton;
    private JButton CEButton;
    private JButton cButton;
    private JButton dMButton;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JPanel panel;
    private JLabel text;
    private String text1="";
    ArrayList<String> wyrazyPomoc = new ArrayList<>();
    private boolean duzeLitery=false;
    Zadanie2(){

        ABCButton.addMouseListener(this);
        GHIButton.addMouseListener(this);
        DEFButton.addMouseListener(this);
        JKLButton.addMouseListener(this);
        MNOButton.addMouseListener(this);
        PQRButton.addMouseListener(this);
        STUVButton.addMouseListener(this);
        WXYZButton.addMouseListener(this);
        //poniżej do zrobienia
        CEButton.addActionListener(e -> {
            try{
                text1 = text1.substring(0, text1.length() - 1);
                text.setText(text1);
            }catch(Exception e1){
                System.out.println("nie ma czego usunąć");
            }
        });
        button1.addActionListener(e -> {
            if (!text1.isEmpty()){
                text1+="+";
                text.setText(text1);

            }
        });
        button2.addActionListener(e -> {
            text1+="-";
            text.setText(text1);

        });
        button3.addActionListener(e -> {
            text1+="/";
            text.setText(text1);

        });
        cButton.addActionListener(e -> {
            try{
                text1 = "";
                text.setText(text1);
                for (String s : wyrazyPomoc) {
                    wyrazyPomoc.clear();
                }

                System.out.println(wyrazyPomoc);
            }catch(Exception e1){
                System.out.println(wyrazyPomoc);

            }

        });
        button4.addActionListener(e -> {
            try{
                make_data_useable();
                String wynik="";
                wyrazyPomoc.add(text1);
                System.out.println(wyrazyPomoc);
                while (wyrazyPomoc.contains("+")|| wyrazyPomoc.contains("-")|| wyrazyPomoc.contains("/")){
                    for(int i=0;i<wyrazyPomoc.size();i++){
                        if (wyrazyPomoc.get(i).equals("+")) {

                            wynik = suma(wyrazyPomoc.get(i - 1), wyrazyPomoc.get(i + 1));
                            System.out.println(wynik);
                            wyrazyPomoc.remove(i + 1);
                            wyrazyPomoc.remove(i);
                            wyrazyPomoc.remove(i - 1);
                            wyrazyPomoc.add(0, wynik);
                            break;
                        }
                        else if (wyrazyPomoc.get(i).equals("-")){
                            wynik = roznica(wyrazyPomoc.get(i - 1), wyrazyPomoc.get(i + 1));
                            System.out.println(wynik);
                            wyrazyPomoc.remove(i+1);
                            wyrazyPomoc.remove(i);
                            wyrazyPomoc.remove(i-1);
                            wyrazyPomoc.add(0,wynik);
                            break;
                        }
                        else if (wyrazyPomoc.get(i).equals("/")){
                            wynik = dzielenie(wyrazyPomoc.get(i - 1), wyrazyPomoc.get(i + 1));
                            System.out.println(wynik);
                            wyrazyPomoc.remove(i+1);
                            wyrazyPomoc.remove(i);
                            wyrazyPomoc.remove(i-1);
                            wyrazyPomoc.add(0,wynik);
                            break;
                        }
                    }
                    System.out.println(wyrazyPomoc);

                }
                text.setText(wynik);
                text1=wynik;
                wyrazyPomoc.clear();
            }
            catch(Exception e3){
                System.out.println("index");
            }
        });
        dMButton.addActionListener(e -> {
            if (duzeLitery) duzeLitery=false;
            else duzeLitery=true;
            System.out.println(duzeLitery);
        });
    }
    @Override
    public void mouseClicked(MouseEvent event){
        JButton guzik= (JButton) event.getSource();
        String pomocniczy_tekst=guzik.getText();
        int kliki=event.getClickCount()-1;
        if (pomocniczy_tekst.length()==3){
            switch (kliki % 3) {
                case 0 -> {
                    try {
                        if (text1.substring(text1.length() - 1).equals(String.valueOf(pomocniczy_tekst.charAt(2)).toUpperCase())|| text1.substring(text1.length() - 1).equals(String.valueOf(pomocniczy_tekst.charAt(2)).toLowerCase())) {
                            text1 = text1.substring(0, text1.length() - 1);
                        }
                    } catch (Exception e1) {
                        System.out.println("test");
                    }
                    if (duzeLitery) text1 += String.valueOf(pomocniczy_tekst.charAt(0)).toUpperCase();
                    else text1 += String.valueOf(pomocniczy_tekst.charAt(0)).toLowerCase();
                    text.setText(text1);

                }
                case 1 -> {
                    try {
                        if (text1.substring(text1.length() - 1).equals(String.valueOf(pomocniczy_tekst.charAt(0)).toUpperCase())|| text1.substring(text1.length() - 1).equals(String.valueOf(pomocniczy_tekst.charAt(0)).toLowerCase())) {
                            text1 = text1.substring(0, text1.length() - 1);
                        }
                    } catch (Exception e1) {
                        System.out.println("test");
                    }
                    if (duzeLitery) text1 += String.valueOf(pomocniczy_tekst.charAt(1)).toUpperCase();
                    else text1 += String.valueOf(pomocniczy_tekst.charAt(1)).toLowerCase();
                    text.setText(text1);
                }
                case 2 -> {
                    try {
                        if (text1.substring(text1.length() - 1).equals(String.valueOf(pomocniczy_tekst.charAt(1)).toUpperCase())|| text1.substring(text1.length() - 1).equals(String.valueOf(pomocniczy_tekst.charAt(1)).toLowerCase())) {
                            text1 = text1.substring(0, text1.length() - 1);
                        }
                    } catch (Exception e1) {
                        System.out.println("test");
                    }
                    if (duzeLitery) text1 += String.valueOf(pomocniczy_tekst.charAt(2)).toUpperCase();
                    else text1 += String.valueOf(pomocniczy_tekst.charAt(2)).toLowerCase();
                    text.setText(text1);
                }
            }
        }
        else if (pomocniczy_tekst.length()==4){
            switch (kliki % 4) {
                case 0 -> {
                    try {
                        if (text1.substring(text1.length() - 1).equals(String.valueOf(pomocniczy_tekst.charAt(3)).toUpperCase())|| text1.substring(text1.length() - 1).equals(String.valueOf(pomocniczy_tekst.charAt(3)).toLowerCase())) {
                            text1 = text1.substring(0, text1.length() - 1);
                        }
                    } catch (Exception e1) {
                        System.out.println("test");
                    }
                    if (duzeLitery) text1 += String.valueOf(pomocniczy_tekst.charAt(0)).toUpperCase();
                    else text1 += String.valueOf(pomocniczy_tekst.charAt(0)).toLowerCase();
                    text.setText(text1);

                }
                case 1 -> {
                    try {
                        if (text1.substring(text1.length() - 1).equals(String.valueOf(pomocniczy_tekst.charAt(0)).toUpperCase())|| text1.substring(text1.length() - 1).equals(String.valueOf(pomocniczy_tekst.charAt(0)).toLowerCase())) {
                            text1 = text1.substring(0, text1.length() - 1);
                        }
                    } catch (Exception e1) {
                        System.out.println("test");
                    }
                    if (duzeLitery) text1 += String.valueOf(pomocniczy_tekst.charAt(1)).toUpperCase();
                    else text1 += String.valueOf(pomocniczy_tekst.charAt(1)).toLowerCase();
                    text.setText(text1);
                }
                case 2 -> {
                    try {
                        if (text1.substring(text1.length() - 1).equals(String.valueOf(pomocniczy_tekst.charAt(1)).toUpperCase())|| text1.substring(text1.length() - 1).equals(String.valueOf(pomocniczy_tekst.charAt(1)).toLowerCase())) {
                            text1 = text1.substring(0, text1.length() - 1);
                        }
                    } catch (Exception e1) {
                        System.out.println("test");
                    }
                    if (duzeLitery) text1 += String.valueOf(pomocniczy_tekst.charAt(2)).toUpperCase();
                    else text1 += String.valueOf(pomocniczy_tekst.charAt(2)).toLowerCase();
                    text.setText(text1);
                }
                case 3 -> {
                    try {
                        if (text1.substring(text1.length() - 1).equals(String.valueOf(pomocniczy_tekst.charAt(2)).toUpperCase())|| text1.substring(text1.length() - 1).equals(String.valueOf(pomocniczy_tekst.charAt(2)).toLowerCase())) {
                            text1 = text1.substring(0, text1.length() - 1);
                        }
                    } catch (Exception e1) {
                        System.out.println("test");
                    }
                    if (duzeLitery) text1 += String.valueOf(pomocniczy_tekst.charAt(3)).toUpperCase();
                    else text1 += String.valueOf(pomocniczy_tekst.charAt(3)).toLowerCase();
                    text.setText(text1);
                }
            }
        }
        else if (pomocniczy_tekst.length()==1){
            System.out.println("ok");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }

    public void make_data_useable() {
        while (text1.contains("+") || text1.contains("-") || text1.contains("/")) {
            for (int i = 0; i < text1.length(); i++) {
                if (text1.charAt(i) == '+') {
                    wyrazyPomoc.add(text1.substring(0, i));
                    wyrazyPomoc.add("+");
                    text1 = text1.substring(i + 1);
                    break;
                } else if (text1.charAt(i) == '-') {
                    wyrazyPomoc.add(text1.substring(0, i));
                    wyrazyPomoc.add("-");
                    text1 = text1.substring(i + 1);
                    break;
                } else if (text1.charAt(i) == '/') {
                    wyrazyPomoc.add(text1.substring(0, i));
                    wyrazyPomoc.add("/");
                    text1 = text1.substring(i + 1);
                    break;
                }
                System.out.println(wyrazyPomoc);
                System.out.println(text1);
            }
        }
    }
    private String suma(String str1, String str2){
        return str1+str2;
    }
    private String roznica(String str1, String str2){
        return str1.replace(str2, "");
    }
   private String dzielenie(String str1, String str2){
        int m = str1.length();
        int n = str2.length();
        int max = 0;
        int[][] dp = new int[m][n];
        int ostIndex=-1;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(str1.charAt(i) == str2.charAt(j)){
                    if(i==0 || j==0){
                        dp[i][j]=1;
                    }
                    else{
                        dp[i][j] = dp[i-1][j-1]+1;
                    }
                    if(max < dp[i][j]) {
                        max = dp[i][j];
                        ostIndex=i;
                    }
                }
            }
        }
        return str1.substring(ostIndex-max+1,ostIndex+1);
    }

    public static void main(String[] args) {
        JFrame ramka = new JFrame("zadanie2");
        ramka.setMinimumSize(new Dimension(500,500));
        ramka.setContentPane(new Zadanie2().panel);
        ramka.pack();
        ramka.setVisible(true);
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
