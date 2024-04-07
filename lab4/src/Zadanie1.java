

public class Zadanie1 {
    /*nie robić tego jako wykres tylko rysować wycinakami.
    pokazać % sumy jaki stanowi liczba (dla 1 i 4 koło będzie w 80% czerwone i 20 zielone
    liste stworzyc z Jlist
     */
    public static void main(String[] args) {
        Gui1 ramka = new Gui1();
        ramka.panel1.add(ramka.listacontainer);
        NowyWykres1 wykres = new NowyWykres1();
        wykres.wycinki.add(new Skladowa(7));
        wykres.repaint();
        ramka.add(wykres);

        //ramka.wykres.show();


    }
}
