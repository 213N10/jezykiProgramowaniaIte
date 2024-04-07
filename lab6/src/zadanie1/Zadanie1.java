package zadanie1;

public class Zadanie1 {
    public static void main(String[] args) {
        int user_input;
        try {
            user_input = Integer.parseInt(args[0]);
            if (user_input<=0){
                System.out.println("Podano błędne dane. Podana przez Ciebie wartość nie jest wartością całkowitą dodatnią");
                System.exit(7);
            }
            else if (user_input>36){
                System.out.println("Podano zbyt dużą ilość kółek (max: 36)");
                System.exit(7);
            }
            else{
                new GUI1(user_input);
            }
        }catch (Exception e){
            System.out.println("Podano błędne dane. Sprawdź czy podana przez Ciebie wartość jest wartością całkowitą dodatnią i czy nie jest większa niż 36");
        }

    }
}
