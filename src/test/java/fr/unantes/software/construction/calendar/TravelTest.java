package fr.unantes.software.construction.calendar;

import fr.unantes.software.construction.people.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.InvalidClassException;
import java.util.Date;

public class TravelTest {
    private Travel trav1;
    private Person pers1 = new Person("nom1","agent");
    private Person pers2 = new Person("nom2","agent");
    private Calendar cal1 = new Calendar(pers1);
    private Calendar cal2 = new Calendar (pers2);
    private City cit1 = new City ("country1","cname1");
    private City cit2 = new City ("country2", "cname2");
    private City cit3 = new City ("country1","cname3");
    private City cit4 = new City ("country3", "cname4");
    private Date date1 = new Date(1995,12,1);
    private Date date2 = new Date(2005,12,1);
    private Date date3 = new Date(2015,12,1);
    private Date date4 = new Date(2025,12,1);

    public TravelTest() throws InvalidClassException {}

    @BeforeEach
    public void setUp() throws Exception {trav1 = new Travel(cal1);}

    @Test
    public void TestBidirectionnalAddCorrepondence(){
        Correspondence cor1 = new Correspondence(cit1,cit2,date1,date2);
        Correspondence cor2 = new Correspondence(cit2,cit3, date2,date3);
        Correspondence cor3 = new Correspondence(cit3, cit4, date3,date4);
        Correspondence[] listcorr = {cor1, cor2, cor3};
        for (Correspondence each : listcorr){
            trav1.getSteps().add(each);
        }
        for (Correspondence each : listcorr){
            assertTrue(trav1.getSteps().contains(each));
            assertEquals(trav1, each.getTravel().get());
        }
    }
    @Test
    public void TestRemoveCorrespondence(){
        Correspondence cor1 = new Correspondence(cit1,cit2,date1,date2);
        Correspondence cor2 = new Correspondence(cit2,cit3, date2,date3);
        Correspondence cor3 = new Correspondence(cit3, cit4, date3,date4);
        Correspondence[] listcorr = {cor1, cor2, cor3};
        for (Correspondence each : listcorr){
            trav1.getSteps().add(each);
        }
        for (int i = 0; i < listcorr.length; i++){
            trav1.getSteps().remove(listcorr[i]);
        }
        assertEquals(1,trav1.getSteps().size());
    }
    @Test
    public void TestCompleteHandshakeCorrespondence(){
        Travel trav2 = new Travel(cal2);
        Correspondence cor1 = new Correspondence(cit1,cit2,date1,date2);
        Correspondence cor2 = new Correspondence(cit2,cit3, date2,date3);
        Correspondence cor3 = new Correspondence(cit3, cit4, date3,date4);
        Correspondence[] listcorr = {cor1, cor2, cor3};
        for (Correspondence each : listcorr){
            trav1.getSteps().add(each);
        }
        for (Correspondence each : listcorr){
            trav2.getSteps().add(each);
        }
        for (Correspondence each : listcorr){
            assertFalse(trav1.getSteps().contains(each));
            assertTrue(trav2.getSteps().contains(each));
            assertEquals(trav2, each.getTravel().get());
        }
    }
    @Test
    public void testparent(){
        assertTrue(trav1.getParent().get().equals(cal1));
        assertFalse(trav1.getParent().get().equals(cal2));
        trav1.setParent(cal2);
        assertFalse(trav1.getParent().get().equals(cal1));
        assertTrue(trav1.getParent().get().equals(cal2));
    }
    @Test
    public void testSizeMax(){
        Correspondence cor1; 
        assertTrue(trav1.getSteps().add(cor1 = new Correspondence(cit1,cit2,date1,date2)));
        assertTrue(trav1.getSteps().add(cor1 = new Correspondence(cit1,cit2,date1,date2)));
        assertTrue(trav1.getSteps().add(cor1 = new Correspondence(cit1,cit2,date1,date2)));
        assertTrue(trav1.getSteps().add(cor1 = new Correspondence(cit1,cit2,date1,date2)));
        assertTrue(trav1.getSteps().add(cor1 = new Correspondence(cit1,cit2,date1,date2)));
        assertTrue(trav1.getSteps().add(cor1 = new Correspondence(cit1,cit2,date1,date2)));
        assertTrue(trav1.getSteps().add(cor1 = new Correspondence(cit1,cit2,date1,date2)));
        assertTrue(trav1.getSteps().add(cor1 = new Correspondence(cit1,cit2,date1,date2)));
        assertTrue(trav1.getSteps().add(cor1 = new Correspondence(cit1,cit2,date1,date2)));
        assertTrue(trav1.getSteps().add(cor1 = new Correspondence(cit1,cit2,date1,date2)));
        assertFalse(trav1.getSteps().add(cor1 = new Correspondence(cit1,cit2,date1,date2)));

    }
    @Test
    public void testSizeMin(){
        Correspondence cor1 = new Correspondence(cit1,cit2,date1,date2);
        Correspondence cor3 = new Correspondence(cit3, cit4, date3,date4);
        trav1.getSteps().add(cor1);
        trav1.getSteps().add(cor3);

        assertTrue(trav1.getSteps().remove(cor1));
        assertFalse(trav1.getSteps().remove(cor3));
    }
    @Test
    public void TestFirstStep(){
        Correspondence cor1 = new Correspondence(cit1,cit2,date1,date2);
        Correspondence cor2 = new Correspondence(cit2,cit3, date2,date3);
        Correspondence cor3 = new Correspondence(cit3, cit4, date3,date4);
        Correspondence[] listcorr = {cor1, cor2, cor3};
        for (Correspondence each : listcorr){
            trav1.getSteps().add(each);
        }
        assertEquals(cor1, trav1.getFirstStep());
    }
    @Test
    public void TestLastStep(){
        Correspondence cor1 = new Correspondence(cit1,cit2,date1,date2);
        Correspondence cor2 = new Correspondence(cit2,cit3, date2,date3);
        Correspondence cor3 = new Correspondence(cit3, cit4, date3,date4);
        Correspondence[] listcorr = {cor1, cor2, cor3};
        for (Correspondence each : listcorr){
            trav1.getSteps().add(each);
        }
        assertEquals(cor3, trav1.getLastStep());
    }
    @Test
    public void setCalendar(){
    Calendar cal3 = new Calendar(pers1);
    Calendar cal4 = new Calendar(pers1);
    trav1.getParent().set(cal3);
    assertTrue(cal3.getTravels().contains(trav1));
    trav1.getParent().set(cal4);
    assertFalse(cal3.getTravels().contains(trav1));
    assertTrue(cal4.getTravels().contains(trav1));
    assertEquals(cal4, trav1.getParent().get());
    }
    @AfterEach
    public void tearDown() throws Exception {

    }
}