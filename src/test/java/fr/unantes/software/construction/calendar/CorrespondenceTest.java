package fr.unantes.software.construction.calendar;

import fr.unantes.software.construction.people.Agent;
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
    private Agent pers1 = new Agent("nom1");
    private Agent pers2 = new Agent("nom2");
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
    public void setStartCity() {
        City cit3 = new City("country3","name3");
        assertTrue(cor1.getStartCity().isSet());
        assertFalse(cor1.getStartCity().get()==cit3);
        cor1.setStartCity(cit3);
        assertFalse(cor1.getStartCity().get()==cit1);
        assertTrue(cor1.getStartCity().isSet());
        assertTrue(cor1.getStartCity().get()==cit3);
    }
    @Test
    public void setDestCity() {
        City cit3 = new City("country3","name3");
        assertTrue(cor1.getDestinationCity().isSet());
        assertFalse(cor1.getDestinationCity().get()==cit3);
        cor1.setDestinationCity(cit3);
        assertFalse(cor1.getDestinationCity().get()==cit1);
        assertTrue(cor1.getDestinationCity().isSet());
        assertTrue(cor1.getDestinationCity().get()==cit3);
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

    @Test
    public void testStartCityNull(){
        assertThrows(IllegalArgumentException.class, () -> {
            new Correspondence(null, cit2,date1,date2);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            cor1.setStartCity(null);
        });
    }
    @Test
    public void testEndCityNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Correspondence(cit1, null, date1, date2);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            cor1.setDestinationCity(null);
        });
    }
    @Test
    public void testArrivalBeforeStart(){
        assertThrows(IllegalArgumentException.class, () ->{
            new Correspondence(cit1,cit2,date2,date1);
        });
        Date date3 = new Date(1986,1,1);//est avant date1
        assertThrows(IllegalArgumentException.class, () -> {
            cor1.setArrivalTime(date3);
        });
    }
    public void testTravelNull(){
        assertThrows(IllegalArgumentException.class, () -> {
            cor1.setTravel(null);
        });
    }
    @AfterEach
    void tearDown() {
    }
}