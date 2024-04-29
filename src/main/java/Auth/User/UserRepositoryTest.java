package Auth.User;

import static org.junit.Assert.assertFalse;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserRepositoryTest {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private UserRepository userRepository;

    @Before
    public void setup() {
        entityManagerFactory = Persistence.createEntityManagerFactory("test-unit");
        entityManager = entityManagerFactory.createEntityManager();
        userRepository = new UserRepository(entityManager);

        entityManager.getTransaction().begin();
        User user = new User("testlogin", "test@example.com", "testpassword");
        userRepository.saveUser(user);
        entityManager.getTransaction().commit();
    }

    @After
    public void tearDown() {
        if (entityManager != null) {
            entityManager.close();
        }
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }

    @Test
    public void testIsUserWithLoginPresent() {
        Assert.assertTrue(userRepository.isUserWithLoginPresent("testlogin"));
        assertFalse(userRepository.isUserWithLoginPresent("nonexistentlogin"));
    }

    @Test
    public void testIsUserWithEmailPresent() {
        Assert.assertTrue(userRepository.isUserWithEmailPresent("test@example.com"));
        assertFalse(userRepository.isUserWithEmailPresent("nonexistent@example.com"));
    }

    @Test
    public void testGetUserByLogin() {
        Assert.assertTrue(userRepository.getUserByLogin("testlogin").isPresent());
        assertFalse(userRepository.getUserByLogin("nonexistentlogin").isPresent());
    }

}
