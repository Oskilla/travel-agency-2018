package fr.unantes.software.construction.people;

import fr.unantes.software.construction.calendar.Calendar;
import fr.unantes.software.construction.calendar.Travel;

import java.io.InvalidClassException;
import java.util.Objects;

/**
 * An administrator
 */
public class Administrateur extends Person{

    /**
     * Constructor
     * @param name - the Administrator's name
     * @throws InvalidClassException
     */
    public Administrateur(String name) throws InvalidClassException {
        super(name);
    }

    /**
     * Method that will add a travel to a given Agent's calendar
     * @param travel - the travel to add
     * @param agent - the agent to add the travel to
     * @return true if the travel has been added, false otherwise
     */
    public boolean addTravelTo(Travel travel, Agent agent){

            return agent.getCalendar().get().addTravel(travel);

    }

    /**
     * Method that will remove a travel from a given Agent's calendar
     * @param t - the travel to remove
     * @param agent - the agent to remove the travel from
     * @return true if the travel has been removed, false otherwise
     */
    public boolean removeTravelFrom(Travel t, Agent agent){
            return agent.getCalendar().get().removeTravel(t);
    }


}
