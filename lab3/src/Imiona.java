public enum Imiona {
    ABAGAIL("Abagail"),
    SOFIA("Sofia"),
    JANUSZ("Janusz"),
    DAMIAN("Damian");

    private final String imie;


    Imiona(String imie){
        this.imie = imie;
    }
    public String getImie(){
        return imie;
    }

}
