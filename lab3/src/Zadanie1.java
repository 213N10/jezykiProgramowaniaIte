import java.io.IOError;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Zadanie1 {
    public static void main(String[] args) {
        Magazyn magazyn = new Magazyn();
        Koszyk koszyk = new Koszyk();
        magazyn.dodaj_artykuly();
        while(true){
            System.out.println("""
                
                Sklep internetowy u grażynki.
                1. Sprawdź stan sklepu
                2. Znajdź artykuł
                3. Dodaj produkt do koszyka
                4. Pokaż koszyk i sprawdź jego wartość
                5. TYLKO DLA PRACOWNIKÓW! Dodaj artykuł ręcznie
                0. Zakończ zakupy""");
            Scanner skan = new Scanner(System.in);
            skan.useDelimiter(System.lineSeparator());
            try{
                int wybor= skan.nextInt();
                switch(wybor){
                    case 1:
                        magazyn.show_mag();
                        break;
                    case 2:
                        System.out.println("podaj nazwe szukanego produktu");
                        String produkt = skan.next();
                        magazyn.szukaj(produkt);
                        break;
                    case 3:
                        System.out.println("Wpisz nazwę produktu, który chcesz dodać do koszyka");
                        String nazwa= skan.next();
                        if (magazyn.check_product(nazwa)){
                            koszyk.add(magazyn.pobierz_artykul(nazwa));
                        }
                        else{
                            System.out.println("nie ma takiego produktu");}
                        break;
                    case 4:
                        koszyk.show();
                        System.out.println("Cena twojego koszyka wynosi: "+koszyk.cart_price());
                        break;
                    case 5:
                        magazyn.dodaj_artykul();
                        break;
                    case 0:
                        magazyn.save_state();
                        System.exit(1);
                        break;
                    default:
                        System.out.println("wybrano nieistniejącą opcję");

                }
            }
            catch(InputMismatchException e){
                System.out.println(e);
            }
        }
    }
}
