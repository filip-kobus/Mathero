public class PasswordValidator {

    private int minCapital = 1;
    private int minNumber = 2;
    private int minSpecial = 2;
    private int minLength = 8;

    /*
    tworzy validator z domyslnymi parametrami
     */
    public PasswordValidator(){
        minCapital = 1;
        minNumber = 2;
        minSpecial = 2;
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
            output += "Hasło zbyt krótkie - conajmniej " + minLength + " znaków\n";
        }

        for(char c : password.toCharArray()){
            if(Character.isDigit(c))
                numberC++;
            else if(Character.isUpperCase(c))
                capitalC++;
            else if(Character.isLowerCase(c))
                ;
            else if(Character.isSpaceChar(c))
                output += "Hasło nie może zawierać spacji\n";
            else
                specialC++;
        }

        if(numberC<minNumber)
            output += "Hasło musi zawierać conajmniej " + minNumber +" cyfry\n";

        if(specialC<minSpecial)
            output += "Hasło musi zawierać conajmniej " + minSpecial +" znaki specjalne\n";

        if(numberC<minCapital)
            output += "Hasło musi zawierać conajmniej " + minCapital +" wielkie litery\n";


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
