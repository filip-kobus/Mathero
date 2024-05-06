package PassVal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest2 {

    PasswordValidator testValidatorV1 = new PasswordValidator(2, 2, 2, 12);
    PasswordValidator testValidatorV2 = new PasswordValidator(1, 1, 1, 8);

    String[] testPWDPropperV1 = {"slBj-r?H41g2", "1Hdfa!!oO5fg", "u&v0Z9eH.,eC.", "f{s8CuSs3w[T"};
    String[] testPWDInpropperV1 = {"sBj fh212", "1232!hDfaoK9p", "$Dqh9gu!2f92", "lBj-r?H41g2"};

    String[] testPWDPropperV2 = {"ck=682Z4", "4(z,WIts", "k%J=u2(n", "^.m2$=Dd"};
    String[] testPWDInpropperV2 = {"sBj fh212", "dkwsH9n0", "gj@@KUg!", "y@avgH#f"};

    @Test
    void testIsValidSWithProperPasswords() {
        for (String password : testPWDPropperV1) {
            assertTrue(testValidatorV1.isValidS(password).equals("Password valid"));
        }

        for (String password : testPWDPropperV2) {
            assertTrue(testValidatorV2.isValidS(password).equals("Password valid"));
        }

    }

    @Test
    void testIsValidSWithImproperPasswords() {
        for (String password : testPWDInpropperV1) {
            assertFalse(testValidatorV1.isValidS(password).equals("Password valid"));
        }

        for (String password : testPWDInpropperV2) {
            assertFalse(testValidatorV2.isValidS(password).equals("Password valid"));
        }
    }

    @Test
    void testIsValidBWithProperPasswords() {
        for (String password : testPWDPropperV1) {
            assertTrue(testValidatorV1.isValidB(password));
        }

        for (String password : testPWDPropperV2) {
            assertTrue(testValidatorV2.isValidB(password));
        }
    }

    @Test
    void testIsValidBWithImproperPasswords() {
        for (String password : testPWDInpropperV1) {
            assertFalse(testValidatorV1.isValidB(password));
        }

        for (String password : testPWDInpropperV2) {
            assertFalse(testValidatorV2.isValidB(password));
        }
    }
}