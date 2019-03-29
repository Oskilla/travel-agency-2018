package fr.unantes.software.construction.people;
import fr.unantes.software.construction.calendar.Calendar;
import fr.unantes.software.construction.calendar.Travel;
import org.junit.jupiter.api.*;
import java.io.InvalidClassException;

import static org.junit.jupiter.api.Assertions.*;


public class AgentTest {
    private Calendar cal1;
    Agent p1 = new Agent("Paul");


    public AgentTest() throws InvalidClassException {
    }


    @Test
    public void testaddTravel() throws InvalidClassException {
        Calendar c = new Calendar(p1);
        Travel t = new Travel(c);
        p1.addTravel(t);
        assertTrue(p1.getCalendar().get().getTravels().contains(t));
    }

    @Test
    public void testremoveTravel() throws InvalidClassException {
        Calendar c = new Calendar(p1);
        Travel t = new Travel(c);
        p1.addTravel(t);
        p1.removeTravel(t);
        assertFalse(p1.getCalendar().get().getTravels().contains(t));
    }
    @Test
    public void testSetCalendar(){
        Calendar cal = new Calendar(p1);
        p1.setCalendar(cal);
        assertTrue(p1.getCalendar().isSet());
        assertEquals(p1.getCalendar().get(), cal);
    }
    @Test
    public void testBidirectionnalSet(){
        Calendar cal = new Calendar(p1);
        p1.setCalendar(cal);
        assertTrue(p1.getCalendar().isSet());
        assertTrue(cal.getOwner().isSet());
        assertEquals(p1.getCalendar().get(), cal);
        assertEquals(cal.getOwner().get(), p1);
    }

}
