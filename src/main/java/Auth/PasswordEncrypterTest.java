package Auth;

import Auth.PasswordEncrypter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordEncrypterTest {

    @Test
    public void testPasswordEncryptionAndVerification() {
        PasswordEncrypter encrypter = new PasswordEncrypter();
        String password = "password123";

        String hashedPassword = encrypter.encryptPassword(password);
        assertTrue(hashedPassword != null && !hashedPassword.isEmpty());

        assertTrue(encrypter.verifyPassword(password, hashedPassword));
    }
}
