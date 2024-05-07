import java.util.Random;

public class Generator {

    public int liczba1=0,liczba2=0;
    public int X=0, R=0;
    public int ganaruj_dzialanie(){
        Random random = new Random();
        return random.nextInt(4);
    }

    public void generuj_zadanie(int dzialanie){
        Random random = new Random();
        /*
        0 - dodawanie
        1 - odejmowanie
        2 - mnozenie
        3 - dzielenie
        */
        
        switch (dzialanie){
            case 0:
                liczba1 = random.nextInt(100); 
                liczba2 = random.nextInt(100);
                    if(liczba1<liczba2){
                X=liczba2-liczba1;
                System.out.println("X + "+liczba1+"="+liczba2);
                    }
                    else{
                X=liczba1-liczba2;
                System.out.println("X + "+liczba2+"="+liczba1);  
                    }
                break;
            case 1:
                liczba1 = random.nextInt(100); 
                liczba2 = random.nextInt(100); 
                    if(liczba1<liczba2){
                X=liczba2-liczba1;
                System.out.println(liczba2+" - X="+liczba1);
                    }
                    else{
                X=liczba1-liczba2;
                System.out.println(liczba1+" - X ="+liczba2);
                    }
                break;
            case 2:
                liczba1 = random.nextInt(10); 
                liczba2 = random.nextInt(10);
                X=liczba1*liczba2;
                System.out.println(liczba2+" * "+liczba1+"= X");
                break;
            case 3:
                liczba1 = random.nextInt(100); 
                liczba2 = random.nextInt(100); 
                if(liczba1<liczba2){
                X=liczba2/liczba1;
                R=liczba2-(X*liczba1);
                System.out.println(liczba2+" : "+liczba1+"= X + R");
                    }
                    else{
                X=liczba1/liczba2;
                R=liczba1-(X*liczba2);
                System.out.println(liczba1+" : "+liczba2+"= X + R");    
                    }
                break;
            }
        System.out.println("X: "+X);
        if(dzialanie==3)
            System.out.println("R: "+R);
    }
}