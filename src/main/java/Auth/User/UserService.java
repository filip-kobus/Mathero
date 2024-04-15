package Auth.User;


import Auth.PasswordEncrypter;
import jakarta.persistence.EntityManager;

public class UserService {

    private final EntityManager entityManager;

    private final UserRepository userRepository;

    public UserService(EntityManager entityManager) {
        this.entityManager = entityManager;
        userRepository = new UserRepository(entityManager);
    }


    public void saveUser(User user) {
        try {
            entityManager.getTransaction().begin();
            if (userRepository.isUserWithLoginPresent(user.getLogin())) {
                System.out.println("User with login " + user.getLogin() + " already exists.");
            } else if (userRepository.isUserWithEmailPresent(user.getEmail())) {
                System.out.println("User with email " + user.getEmail() + " already exists.");
            } else {
                userRepository.saveUser(user);
                System.out.println("User saved");
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
        }


    }


    public User getUserByLogin(String login, String password){
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
        if(new PasswordEncrypter().verifyPassword(password, temp.getPassword())) {
            System.out.println("User with login " + login + " found and loaded.");
        } else {
            System.out.println("Wrong password");
            temp = null;
        }
        return temp;
    }
}

