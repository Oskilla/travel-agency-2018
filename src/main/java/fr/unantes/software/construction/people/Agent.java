package fr.unantes.software.construction.people;

import fr.unantes.software.construction.calendar.Calendar;
import fr.unantes.software.construction.calendar.SingleBidirectionnalReferenceToPerson;
import fr.unantes.software.construction.calendar.Travel;

import java.io.InvalidClassException;
import java.util.Objects;

/**
 * An Agent
 */
public class Agent extends Person{

    protected SingleBidirectionnalReferenceToPerson calendar;

    /**
     * Constructor
     * An agent is automatically associated to a Calendar
     * @param name the Agent's name
     * @throws InvalidClassException
     */
    public Agent(String name) throws InvalidClassException {
        super(name);
        calendar = new SingleBidirectionnalReferenceToPerson(this);
    }

    /**
     * Method that will return a single reference to calendar
     * To get the Calendar itself, use the single reference to calendar's get method
     * @return
     */
    public SingleBidirectionnalReferenceToPerson getCalendar(){
        return calendar;
    }

    /**
     * Method that will associate a new calendar to the Agent
     * @param calendar The new calendar to associate
     */
    public void setCalendar(Calendar calendar){
        if(calendar == null){throw new IllegalArgumentException("calendar cannot be null");}
        this.calendar.set(calendar);
    }

    /**
     * Method that will add a travel to the agent's calendar
     * @param travel - the travel to add
     * @return true if the travel has been added, false otherwise
     */
    public boolean addTravel(Travel travel){
            return this.getCalendar().get().addTravel(travel);
    }

    /**
     * Method that will remove a travel from the agent's calendar
     * @param t - the travel to remove
     * @return true if the travel has been removed, false otherwise
     */
    public boolean removeTravel(Travel t){
            return this.getCalendar().get().removeTravel(t);

    }
}
