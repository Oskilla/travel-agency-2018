package fr.unantes.software.construction.people;

import fr.unantes.software.construction.calendar.Calendar;
import fr.unantes.software.construction.calendar.SingleBidirectionnalReferenceToPerson;
import fr.unantes.software.construction.calendar.Travel;

import java.io.InvalidClassException;
import java.util.Objects;

/**
 * A Generic person, which can be an agent or an administrator
 */
public class Agent extends Person{

    protected SingleBidirectionnalReferenceToPerson calendar;

    public Agent(String name) throws InvalidClassException {
        super(name);
        calendar = new SingleBidirectionnalReferenceToPerson(this);
    }

    public SingleBidirectionnalReferenceToPerson getCalendar(){
        return calendar;
    }

    public void setCalendar(Calendar calendar){
        this.calendar.set(calendar);
    }

    public boolean addTravel(Travel travel){
            return this.getCalendar().get().addTravel(travel);
    }

    public boolean removeTravel(Travel t){
            return this.getCalendar().get().removeTravel(t);

    }
}
