package fr.unantes.software.construction.people;
import fr.unantes.software.construction.calendar.Calendar;
import fr.unantes.software.construction.calendar.Travel;
import fr.unantes.software.construction.people.Administrateur;
import fr.unantes.software.construction.people.Agent;
import fr.unantes.software.construction.people.Person;
import fr.unantes.software.construction.security.GestionMdp;
import fr.unantes.software.construction.security.UserManager;
import org.junit.jupiter.api.*;
import java.io.InvalidClassException;
import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class AdminTest {

    private Agent p1 = new Agent("Paul");
    private Administrateur p2 = new Administrateur("Pierre");
    private Administrateur p4 = new Administrateur("Simon");


    public AdminTest() throws InvalidClassException {
    }


    @Test
    public void testaddTravel() throws InvalidClassException {
        Calendar c = new Calendar(p1);
        Travel t = new Travel(c);
        p2.addTravelTo(t,p1);
        assertTrue(p1.getCalendar().get().getTravels().contains(t));
    }

    @Test
    public void testremoveTravel() throws NoSuchAlgorithmException, InvalidClassException {
        Calendar c = new Calendar(p1);
        Travel t = new Travel(c);
        p2.addTravelTo(t,p1);
        p2.removeTravelFrom(t,p1);
        assertFalse(p1.getCalendar().get().getTravels().contains(t));
    }


}
