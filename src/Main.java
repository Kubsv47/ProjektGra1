import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Wybierz drugiego gracza? (Komputer/Gracz2)");
        Scanner scanner;
        scanner = new Scanner(System.in);
        String wybor = scanner.next();
        if(wybor.equals("Komputer")) {
            GraPlanszowa gra = new GraPlanszowa("Gracz1", "Komputer");
            gra.rozpocznijGre();
        }
        else if (wybor.equals("Gracz2")) {
            GraPlanszowa gra = new GraPlanszowa("Gracz1", "Gracz2");
            gra.rozpocznijGre();
        }
        else {
            System.out.print("Wybierz poprawnego drugiego gracza !!!");
        }

    }
}