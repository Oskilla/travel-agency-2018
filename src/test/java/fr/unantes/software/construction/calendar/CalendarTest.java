package fr.unantes.software.construction.calendar;


import fr.unantes.software.construction.people.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.InvalidClassException;

import static org.junit.jupiter.api.Assertions.*;

public class CalendarTest {
    private Person pers1 = new Person("nom1","agent");
    private Calendar cal1;
    public CalendarTest() throws InvalidClassException {
    }

    @BeforeEach
    public void setUp() throws Exception {cal1 = new Calendar(pers1);}
    @Test
    public void insertList(){
        Travel trav1 = new Travel(cal1);
        assertTrue(cal1.addTravel(trav1));
    }
    @Test
    public void removeList(){
        Travel trav1 = new Travel(cal1);
        cal1.addTravel(trav1);
        assertTrue(cal1.removeTravel(trav1));
    }
    @Test
    public void sizeList(){
        Travel trav1 = new Travel(cal1);
        Travel trav2 = new Travel(cal1);
        Travel trav3 = new Travel(cal1);
        Travel trav4 = new Travel(cal1);
        Travel trav5 = new Travel(cal1);
        Travel trav6 = new Travel(cal1);
        Travel trav7 = new Travel(cal1);
        Travel trav8 = new Travel(cal1);
        Travel trav9 = new Travel(cal1);
        Travel trav10 = new Travel(cal1);
        Travel trav11 = new Travel(cal1);
        assertTrue(cal1.addTravel(trav1));
        assertTrue(cal1.addTravel(trav2));
        assertTrue(cal1.addTravel(trav3));
        assertTrue(cal1.addTravel(trav4));
        assertTrue(cal1.addTravel(trav5));
        assertTrue(cal1.addTravel(trav6));
        assertTrue(cal1.addTravel(trav7));
        assertTrue(cal1.addTravel(trav8));
        assertTrue(cal1.addTravel(trav9));
        assertTrue(cal1.addTravel(trav10));
        assertFalse(cal1.addTravel(trav11));
    }
    @AfterEach
    public void tearDown() throws Exception {
    }
}