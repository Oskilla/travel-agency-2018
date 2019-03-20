package fr.unantes.software.construction.Security;
import fr.unantes.software.construction.people.Person;
import fr.unantes.software.construction.security.GestionMdp;
import fr.unantes.software.construction.security.UserManager;
import org.junit.jupiter.api.*;
import java.io.InvalidClassException;
import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class GestionMdpTest {

    GestionMdp Test1 = new GestionMdp();
    Person p1 = new Person("Paul", "agent");
    Person p2 = new Person("Pierre", "admin");
    Person p3 = new Person("Eliott", "agent");
    Person p4 = new Person("Simon", "admin");



    public GestionMdpTest() throws InvalidClassException {
    }

    @Test
    public void testinsertion() throws NoSuchAlgorithmException {
        Test1.addMdp(p1, "motdepasse");
        assertTrue(Test1.hasUser(p1));
    }

    @Test
    public void testremove() throws NoSuchAlgorithmException {
        Test1.addMdp(p2, "motdepasse1");
        Test1.removeMdp(p2);
        assertFalse(Test1.hasUser(p2));
    }

    @Test
    public void testMdpEgaux() throws NoSuchAlgorithmException {
        Test1.addMdp(p3, "password");
        assertTrue(Test1.validatePassword(p3,"password"));
    }

    @Test
    public void testMdpDiff() throws NoSuchAlgorithmException {
        Test1.addMdp(p4, "motdepasse");
        assertFalse(Test1.validatePassword(p4,"password3"));
    }

}
