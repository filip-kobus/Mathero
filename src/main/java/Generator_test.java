import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GeneratorTest {

    @Test
    public void testDodawanie() {
        Generator generator = new Generator();
        generator.generuj_zadanie();
        assertTrue(generator.X == (generator.liczba1 + generator.liczba2) || generator.X == (generator.liczba2 + generator.liczba1));
    }

    @Test
    public void testOdejmowanie() {
        Generator generator = new Generator();
        generator.generuj_zadanie();
        assertTrue(generator.X == (generator.liczba2 - generator.liczba1) || generator.X == (generator.liczba1 - generator.liczba2));
    }

    @Test
    public void testMnozenie() {
        Generator generator = new Generator();
        generator.generuj_zadanie();
        assertEquals(generator.X, (generator.liczba1 * generator.liczba2));
    }

    @Test
    public void testDzielenie() {
        Generator generator = new Generator();
        generator.generuj_zadanie();
        if (generator.dzialanie == 3) {
            assertEquals(generator.X, (generator.liczba2 / generator.liczba1));
            assertEquals(generator.R, (generator.liczba2 % generator.liczba1));
        }
    }
}
