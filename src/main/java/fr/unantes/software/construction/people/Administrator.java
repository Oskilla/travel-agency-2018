package fr.unantes.software.construction.people;

import fr.unantes.software.construction.calendar.Travel;

/**
 * An administrator manage travels for agents
 */
public class Administrator extends People {
    public Administrator(String name) {
        super(name);
    }

    public boolean addTravelTo(Travel travel, Agent agent) {
        return agent.getCalendar().addTravel(travel);
    }
}
