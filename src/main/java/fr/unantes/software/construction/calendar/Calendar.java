package fr.unantes.software.construction.calendar;

import fr.unantes.software.construction.people.Agent;
import fr.unantes.software.construction.people.Person;

import java.util.ArrayList;
import java.util.Vector;

/**
 * A Calendar stores a list of travels for an agent
 */
public class Calendar {
    private final static  int maxtravels = 10;
    private MultipleReferences<Travel> travels = new MultipleBidirectionnalReferencesToCalendar(this, maxtravels);
    private SingleBidirectionnalReferenceToCalendar owner;

    /**
     * Calendar's constructor
     * @param owner - Calendar's owner
     */
    public Calendar(Agent owner) {
        this.owner = new SingleBidirectionnalReferenceToCalendar(this);
        this.setOwner(owner);
    }

    /**
     * Method to get the owner of the calendar
     * @return a Single Reference to owner(to get the person that owns the calendar, use SingleBidirectionnalReferenceToCalendar's method get)
     */
    public SingleBidirectionnalReferenceToCalendar getOwner() {
        return owner;
    }

    /**
     * Method to set the owner of a Calendar
     * @param owner - the new owner of the Calendar
     */
    public void setOwner(Agent owner) {

        if (owner == null) { throw new IllegalArgumentException("owner cannot be null");}
            this.owner.set(owner);
    }

    /**
     * Method to add a travel to a calendar
     * @param travel - the travel to add to the calendar
     * @return true if the travel has been added, false otherwise
     */
    public boolean addTravel(Travel travel) {
        return travels.add(travel);
    }

    /**
     * Method to remove a Travel from a Calendar
     * @param travel - the travel to remove
     * @return true if the travel has been removed, false otherwise
     */
    public boolean removeTravel(Travel travel) {
        return travels.remove(travel);
    }

    /**
     * Method to get the Calendar's travels
     * @return a Multiple Reference to travel(to get the list of travels, use MultipleReference's method get)
     */
    public MultipleReferences<Travel> getTravels() {
        return travels;
    }
}
