package Auth.User;


import Auth.PasswordEncrypter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserService {

    private final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("unit");

    private final EntityManager entityManager = entityManagerFactory.createEntityManager();


    private final UserRepository userRepository = new UserRepository(entityManager);


    public boolean saveUser(User user) {
        try {
            entityManager.getTransaction().begin();
            if (userRepository.isUserWithLoginPresent(user.getLogin())) {
                System.out.println("User with login " + user.getLogin() + " already exists.");
                return false;
            } else if (userRepository.isUserWithEmailPresent(user.getEmail())) {
                System.out.println("User with email " + user.getEmail() + " already exists.");
                return false;
            } else {
                userRepository.saveUser(user);
                System.out.println("User with login " + user.getLogin() + " saved.");
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
        }

        return true;

    }


    public User getUserByLogin(String login, String password) {
        User temp = null;
        try {
            entityManager.getTransaction().begin();
            temp = userRepository.getUserByLogin(login).orElse(null);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
        }
        if (temp == null) {
            System.out.println("User with login " + login + " not found.");
            return temp;
        }
        if (new PasswordEncrypter().verifyPassword(password, temp.getPassword())) {
            System.out.println("User with login " + login + " found and loaded.");
        } else {
            System.out.println("Wrong password");
            temp = null;
        }
        return temp;
    }
}

