package Auth.User;


import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;

import java.util.Optional;

public class UserRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    public UserRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public void saveUser(User user) {
        entityManager.persist(user);
    }

    public boolean isUserWithLoginPresent(String login) {
        return  !entityManager.createQuery("SELECT u FROM User u WHERE u.Login = :login", User.class)
                .setParameter("login", login)
                .getResultList().isEmpty();
    }

    boolean isUserWithEmailPresent(String email){
        return !entityManager.createQuery("SELECT u FROM User u WHERE u.Email = :email", User.class)
                .setParameter("email", email)
                .getResultList().isEmpty();
    }

    public Optional<User> getUserByLogin(String login) {
        try {
            return Optional.ofNullable(entityManager.createQuery("SELECT u FROM User u WHERE u.Login = :login", User.class)
                    .setParameter("login", login)
                    .getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

}
