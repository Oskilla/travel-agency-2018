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


public class AgentTest {

    Agent p1 = new Agent("Paul");


    public AgentTest() throws InvalidClassException {
    }


    @Test
    public void testaddTravel() throws InvalidClassException {
        Calendar c = new Calendar(p1);
        Travel t = new Travel(c);
        p1.addTravel(t);
        assertTrue(p1.getCalendar().getTravels().contains(t));
    }

    @Test
    public void testremoveTravel() throws InvalidClassException {
        Calendar c = new Calendar(p1);
        Travel t = new Travel(c);
        p1.addTravel(t);
        p1.removeTravel(t);
        assertFalse(p1.getCalendar().getTravels().contains(t));
    }


}
