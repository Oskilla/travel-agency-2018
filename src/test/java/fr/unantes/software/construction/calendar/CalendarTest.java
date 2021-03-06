package fr.unantes.software.construction.calendar;


import fr.unantes.software.construction.people.Agent;
import fr.unantes.software.construction.people.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.InvalidClassException;

import static org.junit.jupiter.api.Assertions.*;

public class CalendarTest {
    private Calendar cal1;
    private Agent pers1 = new Agent("nom1");

    public CalendarTest() throws InvalidClassException {
    }

    @BeforeEach
    public void setUp() throws Exception {cal1 = new Calendar(pers1);}
    @Test
    public void sizeList() throws InvalidClassException {
        Travel trav1;
        Travel trav2;
        Travel trav3;
        Travel trav4;
        Travel trav5;
        Travel trav6;
        Travel trav7;
        Travel trav8;
        Travel trav9;
        Travel trav10;
        Travel trav11;
        assertTrue(cal1.getTravels().add(trav1 = new Travel(cal1)));
        assertTrue(cal1.getTravels().add(trav2 = new Travel(cal1)));
        assertTrue(cal1.getTravels().add(trav3 = new Travel(cal1)));
        assertTrue(cal1.getTravels().add(trav4 = new Travel(cal1)));
        assertTrue(cal1.getTravels().add(trav5 = new Travel(cal1)));
        assertTrue(cal1.getTravels().add(trav6 = new Travel(cal1)));
        assertTrue(cal1.getTravels().add(trav7 = new Travel(cal1)));
        assertTrue(cal1.getTravels().add(trav8 = new Travel(cal1)));
        assertTrue(cal1.getTravels().add(trav9 = new Travel(cal1)));
        assertTrue(cal1.getTravels().add(trav10 = new Travel(cal1)));
        assertFalse(cal1.getTravels().add(trav11 = new Travel(cal1)));
    }
    @Test
    public void testBidirectionnalAdd() throws InvalidClassException {
        Travel trav1 = new Travel(cal1);
        Travel trav2 = new Travel(cal1);
        Travel trav3 = new Travel(cal1);
        Travel trav4 = new Travel(cal1);
        Travel[] listetrav = {trav1, trav2, trav3, trav4};
        for (Travel each : listetrav){
            cal1.getTravels().add(each);
        }
        for (Travel each : listetrav)
        {
            assertTrue(cal1.getTravels().contains(each));
            assertEquals(cal1, each.getParent().get());
        }
    }
    @Test
    public void testRemove() throws InvalidClassException {
        Travel trav1 = new Travel(cal1);
        Travel trav2 = new Travel(cal1);
        Travel trav3 = new Travel(cal1);
        Travel trav4 = new Travel(cal1);
        Travel[] listetrav = {trav1, trav2, trav3, trav4};
        for (Travel each : listetrav){
            cal1.getTravels().add(each);
        }
        assertEquals(listetrav.length, cal1.getTravels().size());
        for (Travel each : listetrav){
            cal1.getTravels().remove(each);
        }
        assertEquals(0,cal1.getTravels().size());
    }
    @Test
    public  void testCompleteHandShake() throws InvalidClassException {
        Calendar cal2 = new Calendar(pers1);
        Travel trav1 = new Travel(cal1);
        Travel trav2 = new Travel(cal1);
        Travel trav3 = new Travel(cal1);
        Travel trav4 = new Travel(cal1);
        Travel[] listetrav = {trav1, trav2, trav3, trav4};
        for (Travel each : listetrav){
            cal1.getTravels().add(each);
        }
        for (Travel each : listetrav){
            cal2.getTravels().add(each);
        }
        for (Travel each : listetrav)
        {
            assertFalse(cal1.getTravels().contains(each));
            assertEquals(cal2, each.getParent().get());
        }
    }
    @Test
    public void testSetOwner() throws InvalidClassException {
        Agent agent1 = new Agent("Paul");
        cal1.setOwner(agent1);
        assertTrue(cal1.getOwner().isSet());
        assertEquals(cal1.getOwner().get(), agent1);
    }
    @Test
    public void testBidirectionnalSet() throws InvalidClassException {
        Agent agent1 = new Agent("Paul");
        cal1.setOwner(agent1);
        assertTrue(cal1.getOwner().isSet());
        assertTrue(agent1.getCalendar().isSet());
        assertEquals(cal1.getOwner().get(), agent1);
        assertEquals(agent1.getCalendar().get(), cal1);
    }
    @Test
    public void testUnset() throws InvalidClassException {
        Agent agent1 = new Agent("Paul");
        Agent agent2 = new Agent("George");
        Calendar cal2 = new Calendar(agent2);
        cal1.setOwner(agent1);

        assertTrue(cal1.getOwner().isSet());
        assertEquals(cal1.getOwner().get(), agent1);
        assertTrue(cal2.getOwner().isSet());
        assertEquals(cal2.getOwner().get(), agent2);
        cal1.setOwner(agent2);
        assertTrue(cal1.getOwner().isSet());
        assertEquals(cal1.getOwner().get(), agent2);
        assertFalse(cal2.getOwner().isSet());
    }
    @Test
    public void testOwnerisNull() throws InvalidClassException {
        assertThrows(IllegalArgumentException.class, () -> {
        cal1.setOwner(null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Calendar cal2 = new Calendar(null);
        });

    }
    @AfterEach
    public void tearDown() throws Exception {
    }
}