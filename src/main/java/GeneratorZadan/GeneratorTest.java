package GeneratorZadan;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class GeneratorTest {

    private int X, l1, l2;

    private void zapiszLiczby(int dzialanie, Generator generator) {
        ArrayList<String> wynik = generator.generuj_zadanie(dzialanie);

        l1 = Integer.parseInt(wynik.get(0));
        X = Integer.parseInt(wynik.get(2));
        l2 = Integer.parseInt(wynik.get(4));
    }

    @Test
    public void testDodawanie() {
        Generator generator = new Generator();
        zapiszLiczby(0, generator);
        assertEquals(X, l2 - l1);
    }

    @Test
    public void testOdejmowanie() {
        Generator generator = new Generator();
        zapiszLiczby(1, generator);
        assertEquals(X, l1 - l2);
    }

    @Test
    public void testMnozenie() {
        Generator generator = new Generator();
        zapiszLiczby(2, generator);
        assertEquals(l2, l1 * X);
    }

    @Test
    public void testDzielenie() {
        Generator generator = new Generator();
        zapiszLiczby(3, generator);
        assertEquals(l2, l1 / X);
    }
}
