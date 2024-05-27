package PassVal;

public class PasswordValidator {

    private int minCapital;
    private int minNumber;
    private int minSpecial;
    private int minLength;

    /*
    tworzy validator z domyslnymi parametrami
     */
    public PasswordValidator(){
        minCapital = 1;
        minNumber = 2;
        minSpecial = 1;
        minLength = 8;
    }
    /*
    tworzy validator z podanymi parametrami
     */
    public PasswordValidator(int minCapital, int minNumber, int minSpecial, int minLength) {
        this.minCapital = minCapital;
        this.minNumber = minNumber;
        this.minSpecial = minSpecial;
        this.minLength = minLength;
    }

    /*
       funkcja zwraca "Password valid" jezeli haslo jest git, jezeli nie to mowi co jest nie tak
    */
    public String isValidS(String password){

        int numberC = 0, capitalC = 0, specialC = 0;

        String output = "";

        if(password.length() < minLength){
            output += "Password too short - at least " + minLength + " characters\n";
        }

        for(char c : password.toCharArray()){
            if(Character.isDigit(c))
                numberC++;
            else if(Character.isUpperCase(c))
                capitalC++;
            else if(Character.isLowerCase(c))
                ;
            else if(Character.isSpaceChar(c))
                output += "Password cannot contain spaces\n";
            else
                specialC++;
        }

        if(numberC<minNumber)
            output += "Password should contain at least " + minNumber +" numbers\n";

        if(specialC<minSpecial)
            output += "Password should contain at least " + minSpecial +" special characters\n";

        if(capitalC<minCapital)
            output += "Password should contain at least " + minCapital +" capital characters\n";

        if(output.length() == 0)
            output += "Password valid";
        else
            output = output.substring(0, output.length()-1);

        return output;
    }

     /*
        funkcja to 0-1 sprawdzania poprawności hasła
     */
    public boolean isValidB(String password) {
        return isValidS(password).equals("Password valid");
    }
}
