package fr.unantes.software.construction.people;

import fr.unantes.software.construction.calendar.Calendar;
import fr.unantes.software.construction.calendar.Travel;

import java.io.InvalidClassException;
import java.util.Objects;

/**
 * A Generic person, which can be an agent or an administrator
 */
public class Agent extends Person{
    public String name;
    protected Calendar calendar;

    public Agent(String name, String role) throws InvalidClassException {
        super(name);
        calendar = new Calendar(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getCalendar() throws InvalidClassException {
        return calendar;
    }

    public void setCalendar(Calendar calendar) throws InvalidClassException {
        this.calendar = calendar;
    }

    public boolean addTravel(Travel travel) throws InvalidClassException {
        try {
            return this.getCalendar().addTravel(travel);
        } catch (InvalidClassException e) {
            return false;
        }
    }

    public boolean removeTravel(Travel t){
        try {
            return this.getCalendar().removeTravel(t);
        } catch (InvalidClassException e) {
            return false;
        }
    }
}
