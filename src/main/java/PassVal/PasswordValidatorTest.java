package PassVal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PasswordValidatorTest {

    PasswordValidator v1 = new PasswordValidator(1,2,2,8);
    PasswordValidator v2 = new PasswordValidator(1,1,1,8);
    String pval1 = "2Ananasahaha__11";
    String pval2 = "420Nananas__";
    String pnval1 = "ananas0";
    String pnval2 = "Ananas_";
    String pnval3 = "_Ananas_0";

    @Test
    public void testIsValidS(){
        Assertions.assertTrue(v1.isValidS(pval1).equals("Password valid"));
        Assertions.assertTrue(v1.isValidS(pval2).equals("Password valid"));
        Assertions.assertFalse(v1.isValidS(pnval1).equals("Password valid"));
        Assertions.assertFalse(v1.isValidS(pnval2).equals("Password valid"));
        Assertions.assertFalse(v1.isValidS(pnval3).equals("Password valid"));

        Assertions.assertFalse(v2.isValidS(pnval2).equals("Password valid"));
        Assertions.assertTrue(v2.isValidS(pnval3).equals("Password valid"));
    }
    @Test
    public void testIsValidB(){
        Assertions.assertTrue(v1.isValidB(pval1));
        Assertions.assertTrue(v1.isValidB(pval2));
        Assertions.assertFalse(v1.isValidB(pnval1));
        Assertions.assertFalse(v1.isValidB(pnval2));
        Assertions.assertFalse(v1.isValidB(pnval3));

        Assertions.assertFalse(v2.isValidB(pnval2));
        Assertions.assertTrue(v2.isValidB(pnval3));

    }

}
