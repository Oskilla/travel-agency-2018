package fr.unantes.software.construction.Security;
import fr.unantes.software.construction.people.Administrateur;
import fr.unantes.software.construction.people.Agent;
import fr.unantes.software.construction.security.GestionMdp;
import org.junit.jupiter.api.*;
import java.io.InvalidClassException;
import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class GestionMdpTest {

    GestionMdp Test1 = new GestionMdp();
    Agent p1 = new Agent("Paul");
    Administrateur p2 = new Administrateur("Pierre");
    Agent p3 = new Agent("Eliott");
    Administrateur p4 = new Administrateur("Simon");



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
        assertTrue(Test1.validatePassword(p3.getName(),"password"));
    }

    @Test
    public void testMdpDiff() throws NoSuchAlgorithmException {
        Test1.addMdp(p4, "motdepasse");
        assertFalse(Test1.validatePassword(p4.getName(),"password3"));
    }

}
