import Auth.User.UserService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import Auth.User.User;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager em = emf.createEntityManager();

        new MatheroWindow();
        //TEST AND PROVE THAT AUTHENTICATION WORKS
        //TO DELETE LATTER
        UserService userService = new UserService(em);
        User user = new User("user56", "u56@gmail.com" , "password");
        userService.saveUser(user);
        User user1 = userService.getUserByLogin("user56", "password");
        System.out.println(user1.getLogin() + " " + user1.getEmail() + " " + user1.getPassword() + " " + user1.getSpentTime());

        Generator generator=new Generator();
        generator.generuj_zadanie();
    }
}
