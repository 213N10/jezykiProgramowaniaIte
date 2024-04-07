public class Zadanie1 {
    public static void main(String[] args) {
        int n=0;
        if (args[0].matches("[0-9]+")){
            n=Integer.parseInt(args[0]);
            if (n>3){
                System.out.println("Podana wartość przez użytkownika n= "+n);
                System.out.println("Ilość liczb pierwszych mniejszych bądź równych n: "+ile_pierwszych(n));
            }
            else System.out.println("Błędne dane");
        }
        else System.out.println("Błędne dane");
    }
    public static long silnia(int n){    //działa
        long pomoc=1;
        if (n==0 || n==1) return pomoc;
        else{
            for (long i=1;i<=n; i++){
                pomoc*=i;
                //System.out.println(pomoc);
            }
            return pomoc;
        }
    }
    public static long ile_pierwszych(int n){ //działa
        long pomoc=-1;
        for (int j=3;j<=n;j++){
            long pomocnicza_silnia = silnia(j - 2);
            pomoc+=pomocnicza_silnia-(j*Math.floor((pomocnicza_silnia/j)));
        }
        return pomoc;
    }

}
