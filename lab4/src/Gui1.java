import javax.swing.*;
import java.awt.*;



public class Gui1 extends JFrame {
    JButton gDodaj = new JButton("Dodaj");
    JButton gUsun = new JButton("Usuń");
    JButton gEdytuj = new JButton("Edytuj");
    JLabel label = new JLabel("Podaj dane");
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    //JPanel panel3 = new JPanel();
    DefaultListModel<Integer> listaPomoc = new DefaultListModel<>();
    JList<Integer> lista = new JList<>(listaPomoc);
    JScrollPane listacontainer = new JScrollPane(lista);
    Wykres1 wykres = new Wykres1();
    NowyWykres1 gwykres = new NowyWykres1();
    int suma=0;


    JTextField tekst = new JTextField();
    Gui1(){
        super("Jan Zieniewicz Zadanie 1");
        panel2.setLayout(new GridLayout(4,1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200,200,600,600);
        setMinimumSize(new Dimension(700,500));
        setVisible(true);
        setLayout(new GridLayout(1,3));
        //dodanie paneli
        add(panel1);
        add(panel2);
        //add(gwykres);
        //add(panel3);
        //szybki config paneli

        panel1.setMinimumSize(new Dimension(200,500));

        listacontainer.setPreferredSize(new Dimension(150,500));

        panel2.setMinimumSize(new Dimension(200,500));
        panel2.add(label);
        tekst.setPreferredSize(new Dimension(30,30));
        panel2.add(tekst);
        panel2.add(this.gDodaj);
        panel2.add(this.gUsun);
        panel2.add(this.gEdytuj);
        gDodaj.addActionListener(e -> {
            try{
                Integer pomoc=Integer.valueOf((tekst.getText()));
                listaPomoc.addElement(pomoc);
                label.setText("Podaj dane");
                wykres.dodaj(pomoc);
                wykres.show();
                suma+=pomoc;
                gwykres.wycinki.addAll(wykres.lista);
                gwykres.repaint();
                System.out.println(suma);

            }
            catch(Exception e1){
                System.out.println("złe dane");
                label.setText("Podano złe dane");

            }
        }
        );
        gUsun.addActionListener(e -> {
            //var model = (DefaultListModel) lista.getModel();
            try{
                int wybranyIndex = lista.getSelectedIndex();
                Integer pomoc = listaPomoc.get(wybranyIndex);
                wykres.usun(pomoc);
                wykres.show();
                suma-=pomoc;
                System.out.println(suma);
                if (wybranyIndex!=-1) listaPomoc.remove(wybranyIndex);

            }catch (Exception e1){
                System.out.println("usuwanie nie powiodło się ");
            }

        });
        gEdytuj.addActionListener(e -> {
            int wybranyIndex = lista.getSelectedIndex();
            if (wybranyIndex!=-1){
                try {

                    Integer stary = listaPomoc.get(wybranyIndex);
                    Integer nowy=Integer.valueOf((tekst.getText()));
                    listaPomoc.set(wybranyIndex,nowy);
                    wykres.edycja(nowy,stary);
                    wykres.show();
                    suma=suma-stary+nowy;
                    System.out.println(suma);
                    label.setText("Podaj dane");

                }
                catch(Exception e1){
                    System.out.println("test");
                    label.setText("Podano złe dane");
                }
            }
        });
        //panel3.setMinimumSize(new Dimension(300,500));



    }

}
