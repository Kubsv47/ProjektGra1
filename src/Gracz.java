public abstract class Gracz {
    protected String nazwa;
    protected char znak;
    int numerpola;

    public Gracz(String nazwa, char znak, int numerpola) {
        this.nazwa = nazwa;
        this.znak = znak;
        this.numerpola = numerpola;
    }

    public String getNazwa() {
        return nazwa;
    }

    public char getZnak() {
        return znak;
    }


    public abstract int wykonajRuch();
}