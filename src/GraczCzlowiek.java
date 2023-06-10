import java.util.Scanner;

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
