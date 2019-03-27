package fr.unantes.software.construction.people;

import fr.unantes.software.construction.calendar.Calendar;
import fr.unantes.software.construction.calendar.Travel;

import java.io.InvalidClassException;
import java.util.Objects;

/**
 * A Generic person, which can be an agent or an administrator
 */
public class Administrateur extends Person{
    public String name;

    public Administrateur(String name, String role) throws InvalidClassException {
        super(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean addTravelTo(Travel travel, Agent agent) throws InvalidClassException {
        try {
            return agent.getCalendar().addTravel(travel);
        } catch (InvalidClassException e) {
            return false;
        }
    }

    public boolean removeTravelFrom(Travel t, Agent agent){
        try {
            return agent.getCalendar().removeTravel(t);
        } catch (InvalidClassException e) {
            return false;
        }
    }
}
