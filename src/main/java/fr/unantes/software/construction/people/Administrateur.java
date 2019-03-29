package fr.unantes.software.construction.people;

import fr.unantes.software.construction.calendar.Calendar;
import fr.unantes.software.construction.calendar.Travel;

import java.io.InvalidClassException;
import java.util.Objects;

/**
 * A Generic person, which can be an agent or an administrator
 */
public class Administrateur extends Person{

    public Administrateur(String name) throws InvalidClassException {
        super(name);
    }

    public boolean addTravelTo(Travel travel, Agent agent){

            return agent.getCalendar().get().addTravel(travel);

    }

    public boolean removeTravelFrom(Travel t, Agent agent){
            return agent.getCalendar().get().removeTravel(t);
    }
}
