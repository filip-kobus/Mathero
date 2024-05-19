package GeneratorZadan;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GeneratorTest {

    @Test
    public void testDodawanie() {
        Generator generator = new Generator();
        generator.generuj_zadanie(0);
        assertTrue(generator.X == (generator.liczba1 - generator.liczba2) || generator.X == (generator.liczba2 - generator.liczba1));
    }

    @Test
    public void testOdejmowanie() {
        Generator generator = new Generator();
        generator.generuj_zadanie(1);
        assertTrue(generator.X == (generator.liczba2 - generator.liczba1) || generator.X == (generator.liczba1 - generator.liczba2));
    }

    @Test
    public void testMnozenie() {
        Generator generator = new Generator();
        generator.generuj_zadanie(2);
        assertEquals(generator.X, (generator.liczba1 * generator.liczba2));
    }

    @Test
    public void testDzielenie() {
        Generator generator = new Generator();
        generator.generuj_zadanie(3);
        if(generator.liczba1 > generator.liczba2) {
            assertEquals(generator.X, (generator.liczba1 / generator.liczba2));
            assertEquals(generator.R, (generator.liczba1 % generator.liczba2));
        }
        else {
            assertEquals(generator.X, (generator.liczba2 / generator.liczba1));
            assertEquals(generator.R, (generator.liczba2 % generator.liczba1));
        }
    }
}
