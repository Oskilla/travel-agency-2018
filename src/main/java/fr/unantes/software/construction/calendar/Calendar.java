package fr.unantes.software.construction.calendar;

import fr.unantes.software.construction.people.Agent;

import java.util.LinkedList;
import java.util.List;

/**
 * A Calendar stores a list of travels for an agent
 */
public class Calendar {
    private List<Travel> travels;
    private Agent owner;

    public Calendar(Agent owner) {
        this.owner = owner;
        travels = new LinkedList<>();
    }

    public Agent getOwner() {
        return owner;
    }

    public void setOwner(Agent owner) {
        this.owner = owner;
    }

    public boolean addTravel(Travel travel) {
        return travels.add(travel);
    }

    public boolean removeTravel(Travel travel) {
        return travels.remove(travel);
    }
}
