public class Plansza {
    protected char[][] pola;

    public Plansza() {
        pola = new char[9][9];
        inicjalizujPlansze();
    }

    private void inicjalizujPlansze() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                pola[i][j] = '-';
            }
        }
    }

    public void wyswietlPlansze() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(pola[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean czyPoleWolne(int x, int y) {
        return pola[x][y] == '-';
    }

    public void ustawZnak(int x, int y, char znak) {
        pola[x][y] = znak;
    }

    public boolean czyWygrana(char znak) {
        // Sprawdzenie wygranej w poziomie
        return pola[8][8] == znak;
    }
    public void kolejnaTura(Gracz aktualnyGracz, int x, int y){
        inicjalizujPlansze();
        pola[x][y] = aktualnyGracz.znak;
        }

}

