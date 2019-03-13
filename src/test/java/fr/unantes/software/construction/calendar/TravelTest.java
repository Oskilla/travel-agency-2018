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
    private Correspondence cor1 = new Correspondence(trav1,cit1,cit2,date1,date2);
    private Correspondence cor2 = new Correspondence(trav1,cit2,cit3, date2,date3);
    private Correspondence cor3 = new Correspondence(trav1, cit3, cit4, date3,date4);
    public TravelTest() throws InvalidClassException {}

    @BeforeEach
    public void setUp() throws Exception {trav1 = new Travel(cal1);}

    @Test
    public void insertStart(){
        trav1.addCorrespondence(cor1,0);
        assertTrue(trav1.getFirstStep().equals(cor1));
    }
    @Test
    public void insertEnd(){
       trav1.addCorrespondence(cor3);
       assertTrue(trav1.getLastStep().equals(cor3));
    }
    @Test
    public void insertBetween(){
        trav1.addCorrespondence(cor1);
        trav1.addCorrespondence(cor3);
        trav1.addCorrespondence(cor2,1);
        assertTrue(trav1.getFirstStep().equals(cor1));
        assertTrue(trav1.getLastStep().equals(cor3));
    }
    @Test
    public void removeStart(){
        trav1.addCorrespondence(cor1);
        trav1.addCorrespondence(cor3);
        trav1.removeCorrespondence(cor1);
        assertTrue(trav1.getFirstStep().equals(cor3));
    }
    @Test
    public void removeEnd(){
        trav1.addCorrespondence(cor1);
        trav1.addCorrespondence(cor3);
        trav1.removeCorrespondence(cor3);
        assertTrue(trav1.getLastStep().equals(cor1));
    }
    @Test
    public void testparent(){
        assertTrue(trav1.getParent().equals(cal1));
        assertFalse(trav1.getParent().equals(cal2));
        trav1.setParent(cal2);
        assertFalse(trav1.getParent().equals(cal1));
        assertTrue(trav1.getParent().equals(cal2));
    }
    @Test
    public void testSizemin(){
        assertTrue(trav1.addCorrespondence(cor1));
        assertTrue(trav1.addCorrespondence(cor1));
        assertTrue(trav1.addCorrespondence(cor1));
        assertTrue(trav1.addCorrespondence(cor1));
        assertTrue(trav1.addCorrespondence(cor1));
        assertTrue(trav1.addCorrespondence(cor1));
        assertTrue(trav1.addCorrespondence(cor1));
        assertTrue(trav1.addCorrespondence(cor1));
        assertTrue(trav1.addCorrespondence(cor1));
        assertTrue(trav1.addCorrespondence(cor1));
        assertFalse(trav1.addCorrespondence(cor1));

    }
    public void testSizemax(){
        trav1.addCorrespondence(cor1);
        trav1.addCorrespondence(cor3);

        assertTrue(trav1.removeCorrespondence(cor1));
        assertFalse(trav1.removeCorrespondence(cor3));
    }
    @AfterEach
    public void tearDown() throws Exception {

    }
}