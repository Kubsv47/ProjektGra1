class GraczKomputer extends Gracz {
    public GraczKomputer(String nazwa, char znak, int numerpola) {
        super(nazwa, znak, numerpola);
    }

    @Override
    public int wykonajRuch() {
        // Symulacja losowego ruchu komputera
        return (int) (Math.random() * 6) + 1;
    }
}