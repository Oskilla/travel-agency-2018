package fr.unantes.software.construction.calendar;

import fr.unantes.software.construction.people.Person;

import java.util.ArrayList;
import java.util.Vector;

/**
 * A Calendar stores a list of travels for an agent
 */
public class Calendar {
    private final static  int maxtravels = 10;
    private MultipleReferences<Travel> travels = new MultipleBidirectionnalReferencesToCalendar(this, maxtravels);
    private Person owner;

    public Calendar(Person owner) {
        this.owner = owner;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public boolean addTravel(Travel travel) {
        return travels.add(travel);
    }

    public boolean removeTravel(Travel travel) {
        return travels.remove(travel);
    }

    public MultipleReferences<Travel> getTravels() {
        return travels;
    }
}
