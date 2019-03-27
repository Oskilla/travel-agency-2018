package fr.unantes.software.construction.calendar;

import fr.unantes.software.construction.people.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.InvalidClassException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CorrespondenceTest {
    private City cit1 = new City ("country1","cname1");
    private City cit2 = new City ("country2", "cname2");
    private Date date1 = new Date(1995,12,1);
    private Date date2 = new Date(2005,12,1);
    private Person pers1 = new Person("nom1","agent");
    private Person pers2 = new Person("nom2","agent");
    private Calendar cal1 = new Calendar(pers1);
    private Calendar cal2 = new Calendar (pers2);
    private Correspondence cor1;

    CorrespondenceTest() throws InvalidClassException {
    }

    @BeforeEach
    void setUp() {
        cor1 = new Correspondence(cit1,cit2,date1,date2);
    }
    @Test
    public  void TestSetTravel(){
        Travel trav1 = new Travel(cal1);
        Travel trav2 = new Travel(cal2);
        cor1.getTravel().set(trav1);
        assertTrue(trav1.getSteps().contains(cor1));
        assertEquals(trav1,cor1.getTravel().get());
        cor1.getTravel().set(trav2);
        assertFalse(trav1.getSteps().contains(cor1));
        assertTrue(trav2.getSteps().contains(cor1));
        assertEquals(trav2,cor1.getTravel().get());
    }
    @Test
    public void TestUnsetTravel(){
        Travel trav1 = new Travel(cal1);
        cor1.getTravel().set(trav1);
        assertTrue(cor1.getTravel().get()==trav1);
        cor1.getTravel().unset();
        assertTrue(cor1.getTravel().get()==null);
    }
    @Test
    public void TestIsSet(){
        Travel trav1 = new Travel(cal1);
        cor1.getTravel().set(trav1);
        assertTrue(cor1.getTravel().isSet());
        cor1.getTravel().unset();
        assertFalse(cor1.getTravel().isSet());
    }
    @AfterEach
    void tearDown() {
    }
}