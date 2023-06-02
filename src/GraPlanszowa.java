import java.util.Objects;

public class GraPlanszowa {
    private final Gracz gracz1;
    private final Gracz gracz2;
    private final Plansza plansza;
    private Gracz aktualnyGracz;


    public GraPlanszowa(String nazwaGracz1, String nazwaGracz2) {
        gracz1 = new GraczCzlowiek(nazwaGracz1, 'X', 1);
        if(Objects.equals(nazwaGracz2, "Komputer")){
            gracz2 = new GraczKomputer(nazwaGracz2, 'O', 1);
        }
        else{
            gracz2 = new GraczCzlowiek(nazwaGracz2, 'O', 1);
        }

        plansza = new Plansza();
        aktualnyGracz = gracz1;
    }

    public void rozpocznijGre() {
        System.out.println("Gra planszowa rozpoczęta.");
        plansza.wyswietlPlansze();

        while (true) {

            int rzut = aktualnyGracz.wykonajRuch();
            int x, y;

            if (aktualnyGracz.numerpola+ rzut <=81) {
                aktualnyGracz.numerpola += rzut;
                x = (aktualnyGracz.numerpola - 1) / 9;
                y = (aktualnyGracz.numerpola - 1) % 9;
                System.out.println("Gracz " + aktualnyGracz.getNazwa() + " wyrzucił: " + rzut);
                if (plansza.czyPoleWolne(x, y)) {
                    plansza.ustawZnak(x, y, aktualnyGracz.znak);
                    plansza.wyswietlPlansze();

                    if (plansza.czyWygrana(aktualnyGracz.getZnak())) {
                        System.out.println("Gracz " + aktualnyGracz.getNazwa() + " wygrał!");
                        break;
                    }

                    // Zmiana gracza
                }
                else {
                    plansza.ustawZnak(x, y, '⊗');
                    plansza.wyswietlPlansze();
                    // Zmiana gracza
                }
            }
            else {
                System.out.println("Gracz " + aktualnyGracz.getNazwa() + " wyrzucił: " + rzut + " która jest za duza by przejsc dalej");
                x = (aktualnyGracz.numerpola - 1) / 9;
                y = (aktualnyGracz.numerpola - 1) % 9;
                plansza.ustawZnak(x, y, aktualnyGracz.znak);
                plansza.wyswietlPlansze();
                // Zmiana gracza
            }
            if (aktualnyGracz == gracz1) {
                plansza.kolejnaTura(aktualnyGracz, x, y);
                aktualnyGracz = gracz2;
            } else {
                plansza.kolejnaTura(aktualnyGracz, x, y);
                aktualnyGracz = gracz1;
            }
        }
    }
}

