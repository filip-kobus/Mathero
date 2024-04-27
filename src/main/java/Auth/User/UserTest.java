package Auth.User;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void testUserConstructorWithEmail() {
        User user = new User("testuser", "test@example.com", "password");
        assertEquals("testuser", user.getLogin());
        assertEquals("test@example.com", user.getEmail());
        assertEquals(0, user.getSpentTime());
        assertNotNull(user.getPassword());
    }

    @Test
    public void testUserConstructorWithSpentTime() {
        User user = new User("testuser", "test@example.com", 100, "password");
        assertEquals("testuser", user.getLogin());
        assertEquals("test@example.com", user.getEmail());
        assertEquals(100, user.getSpentTime());
        assertNotNull(user.getPassword());
    }

    @Test
    public void testSetLogin() {
        User user = new User();
        user.setLogin("testuser");
        assertEquals("testuser", user.getLogin());
    }

    @Test
    public void testSetEmail() {
        User user = new User();
        user.setEmail("test@example.com");
        assertEquals("test@example.com", user.getEmail());
    }

    @Test
    public void testSetSpentTime() {
        User user = new User();
        user.setSpentTime(100);
        assertEquals(100, user.getSpentTime());
    }

    @Test
    public void testSetPassword() {
        User user = new User();
        user.setPassword("password");
        assertNotNull(user.getPassword());
    }
}
