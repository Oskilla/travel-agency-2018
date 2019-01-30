package fr.unantes.software.construction.model;

import fr.unantes.software.construction.common.Agent;
import org.apache.commons.lang3.tuple.Pair;

import java.util.LinkedList;
import java.util.List;

/**
 * A Calendar stores a list of travels for an agent
 */
public class Calendar {
    // list of (travel, who added the travel to the calendar)
    // this way, we can track who added which travel!
    private List<Pair<Travel, String>> travels;
    private Agent owner;
    // max number of travels
    private final int MAX_SIZE = 10;

    public Calendar(Agent owner) {
        travels = new LinkedList<>();
        this.owner = owner;
    }

    public void setOwner(Agent owner) {
        this.owner = owner;
    }

    /**
     * Simple way of adding a travel to the calendar
     * @param t Travel to add
     * @return if it was a success
     * @throws RuntimeException if something went wrong
     */
    public boolean addTravel(Travel t) throws RuntimeException {
        if (travels.size() >= MAX_SIZE) {
            System.err.println("Too many travels");
            throw new RuntimeException("Too many travels");
        }
        return travels.add(Pair.of(t, owner.getName()));
    }

    /**
     * Add a travel, but this time the travel was added by another agent
     * @param t Travel to add
     * @param agent Agent who is adding the travel to the calendar
     * @return if it was a success
     * @throws RuntimeException if something went wrong
     */
    public boolean addTravelByAnotherAgent(Travel t, Agent agent) throws RuntimeException {
        if (travels.size() >= MAX_SIZE) {
            System.err.println("Too many travels");
            throw new RuntimeException("Too many travels");
        }
        return travels.add(Pair.of(t, agent.getName()));
    }

    /**
     * Add a travel, but this time the travel was added by an Administrator
     * @param t Travel to add
     * @param admin Administrator who is adding the travel to the calendar
     * @return if it was a success
     * @throws RuntimeException if something went wrong
     */
    public boolean addTravelByAdministrator(Travel t, Administrator admin) throws RuntimeException {
        if (travels.size() >= MAX_SIZE) {
            System.err.println("Too many travels");
            throw new RuntimeException("Too many travels");
        }
        return travels.add(Pair.of(t, admin.getName()));
    }

    /**
     * Remove a travel from the calendar
     * @param t Travel to remove
     * @return if it was a success
     */
    public boolean removeTravel(Travel t) {
        int i = -1;
        for(Pair<Travel, String> tt: travels) {
            i++;
            if (tt.getLeft().equals(t)) {
                break;
            }
        }
        travels.remove(i);
        // TODO returns false when the operation is not a success
        return true;
    }
}
