import java.util.Scanner;
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

class GraczCzlowiek extends Gracz {
    private final Scanner scanner;

    public GraczCzlowiek(String nazwa, char znak, int numerpola) {
        super(nazwa, znak, numerpola);
        scanner = new Scanner(System.in);
    }

    @Override
    public int wykonajRuch() {
        System.out.println("Gracz " + nazwa + ", Odpowiedz poprawnie na pytanie by wykonać rzut kostką: ");
        Pytania pytania = new Pytania();
        Pytanie pytanie = pytania.wylosujPytanie(pytania.listaPytan);
        System.out.println(pytanie.pytanie);
        System.out.println("a)"+pytanie.a+"        "+"c)"+pytanie.c);
        System.out.println("b)"+pytanie.b+"        "+"d)"+pytanie.d);
        String odpowiedz = scanner.next();
        if(odpowiedz.equals(pytanie.poprawna)){
            System.out.println("Gracz " + nazwa + ", Odpowiedział poprawnie ");
            return (int) (Math.random() * 6) + 1;
        }
        else{
            System.out.println("Gracz " + nazwa + ", Odpowiedział błędnie ");
            return 0;
        }
    }
}

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

