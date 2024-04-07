public class Zadanie2 {
    public static void main(String[] args) { //napis parzysta/nieparzysta dotyczy liczby ni, a przekroczenie sprawi że wartość będzie wartością ujemną więc warunek musi być że liczba większa od 0 :)))
        long n=0;
        if (args[0].matches("[0-9]+")) {
            n = Integer.parseInt(args[0]);
            for (int i=1;i<=1000;i++){
                if (n>0){
                    if(n==1) break;
                    if(i==1000) break;

                    print(n, kolejna(n));
                    n=kolejna(n);

                }
                else{
                    break;
                }
            }
        }
        else System.out.println("Błędne dane");

    }
    public static void print(long n, long n2){
        String czyParzysta;
        if (n%2==0) czyParzysta="parzysta";
        else czyParzysta="nieparzysta";
        String wyn=String.format("%d, %s, %d",n,czyParzysta,n2);
        System.out.println(wyn);

    }

    public static long kolejna(long n){
        long next=0;
        if (n%2==0) next=n/2;
        else if (n%2==1) next=n*3+1;
        return next;
    }
}
