package GeneratorZadan;

import java.util.ArrayList;
import java.util.Random;

public class Generator {

    public int liczba1=0,liczba2=0;
    public int X=0;

    public int generuj_dzialanie(){
        Random random = new Random();
        return random.nextInt(4);
    }

    private void generujLiczby(int granica) {
        Random random = new Random();
        int[] liczby = {random.nextInt(granica-1)+1, random.nextInt(granica-1)+1};
        if(liczby[0] > liczby[1]) {
            liczba1 = liczby[0];
            liczba2 = liczby[1];
        }

        else {
            liczba1 = liczby[1];
            liczba2 = liczby[0];
        }
    }

    public ArrayList<String> generuj_zadanie(int dzialanie) {
        ArrayList<String> trescZadania = new ArrayList<>();
        /*
        0 - dodawanie
        1 - odejmowanie
        2 - mnozenie
        3 - dzielenie
        */

        //format odpowiedzi to {liczba1, operacja, X, =, liczba2}

        switch (dzialanie) {
            case 0:
                generujLiczby(100);
                X = liczba1 - liczba2;
                trescZadania.add(Integer.toString(liczba2));
                trescZadania.add("+");
                trescZadania.add(Integer.toString(X));
                trescZadania.add("=");
                trescZadania.add(Integer.toString(liczba1));
                break;
            case 1:
                generujLiczby(100);
                X = liczba1 - liczba2;
                trescZadania.add(Integer.toString(liczba1));
                trescZadania.add("-");
                trescZadania.add(Integer.toString(X));
                trescZadania.add("=");
                trescZadania.add(Integer.toString(liczba2));
                break;
            case 2:
                generujLiczby(10);
                liczba1 = liczba1 * liczba2;
                X = liczba1 / liczba2;
                liczba1 = liczba2 * X;
                trescZadania.add(Integer.toString(liczba2));
                trescZadania.add("*");
                trescZadania.add(Integer.toString(X));
                trescZadania.add("=");
                trescZadania.add(Integer.toString(liczba1));
                break;
            case 3:
                generujLiczby(10);
                liczba1 = liczba1 * liczba2;
                X = liczba1 / liczba2;
                liczba1 = liczba2 * X;
                trescZadania.add(Integer.toString(liczba1));
                trescZadania.add(":");
                trescZadania.add(Integer.toString(X));
                trescZadania.add("=");
                trescZadania.add(Integer.toString(liczba2));
                break;
        }
        return trescZadania;
    }


    public static void main(String[] args) {
        Generator generator=new Generator();
        generator.generuj_zadanie(generator.generuj_dzialanie());
    }
}