package fr.unantes.software.construction.Security;
import fr.unantes.software.construction.people.Person;
import fr.unantes.software.construction.security.UserManager;
import org.junit.jupiter.api.*;
import java.io.InvalidClassException;
import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class UserManagerTest {

    UserManager Test1 = new UserManager();

    public UserManagerTest() throws InvalidClassException {
    }

    @Test
    public void testinsertion() throws InvalidClassException, NoSuchAlgorithmException {
        Person personne1 = new Person("YM1", "agent");
        Test1.addUser(personne1, "motdepasse");
        assertTrue(Test1.hasUser(personne1));
    }

    @Test
    public void testremove() throws InvalidClassException, NoSuchAlgorithmException {
        Person personne2 = new Person("YM2","agent");
        Test1.addUser(personne2, "motdepasse");
        Test1.removeUser(personne2);
        assertFalse(Test1.hasUser(personne2));
    }

}
