package fr.unantes.software.construction.calendar;

import fr.unantes.software.construction.people.Person;

import java.util.ArrayList;
import java.util.Vector;

/**
 * A Calendar stores a list of travels for an agent
 */
public class Calendar {
    private ArrayList<Travel> travels;
    private static final int tailletravels = 10;
    private Person owner;

    public Calendar(Person owner) {
        this.owner = owner;
        travels = new ArrayList<Travel>(tailletravels);
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public boolean addTravel(Travel travel) {
        if(travels.size()==tailletravels) {return false;}
        return travels.add(travel);
    }

    public boolean removeTravel(Travel travel) {
        return travels.remove(travel);
    }
}
