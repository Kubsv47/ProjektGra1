import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Pytania {
   ArrayList<Pytanie>listaPytan;
public Pytania() {
    listaPytan = stworzListePytan();
}


    public ArrayList<Pytanie>stworzListePytan(){
        ArrayList<Pytanie> listaPytan = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("src/pytania.txt"))) {
            String linia;

            while ((linia = br.readLine()) != null) {
                // Dzielenie linii na części przy użyciu przecinka jako separatora
                String[] elementy = linia.split(",");

                // Tworzenie obiektu na podstawie danych w linii
                Pytanie pytanie = stworzPytaniaZElementow(elementy);

                // Dodawanie obiektu do listy
                listaPytan.add(pytanie);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaPytan;
    }

    private static Pytanie stworzPytaniaZElementow(String[] elementy) {

        return new Pytanie(elementy[0], elementy[1], elementy[2], elementy[3], elementy[4], elementy[5]);
    }

    public Pytanie wylosujPytanie(ArrayList<Pytanie>pytania){
        return pytania.get((int) (Math.random() * 39));
    }
}
