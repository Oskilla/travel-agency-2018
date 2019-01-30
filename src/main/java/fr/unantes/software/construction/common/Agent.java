package fr.unantes.software.construction.common;

import fr.unantes.software.construction.model.Calendar;
import fr.unantes.software.construction.model.Travel;

/**
 * An agent is someone that can travel for the company
 * @extends People
 */
public class Agent extends People {
    private Calendar calendar;

    public Agent(String name, String birthplace) {
        super(name, birthplace, "Agent");
        calendar = new Calendar(this);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getBirthplace() {
        return super.getBirthplace();
    }

    @Override
    public void setBirthplace(String birthplace) {
        super.setBirthplace(birthplace);
    }

    @Override
    public String getRole() {
        return "Agent";
    }

    @Override
    public void setRole(String role) {
        if (!role.equals("Agent")) {
            throw new RuntimeException("Cannot set the role of an agent to something is not agent!");
        }
    }

    public Calendar getCalendar() {
        return calendar;
    }

    /**
     * Add a travel to the agent's calendar
     * @param t Travel to add
     */
    public void addTravel(Travel t) {
        try {
            if (!calendar.addTravel(t)) {
                System.err.println("Impossible to add a travel for some reasons :-(");
            }
        } catch (RuntimeException e) {
            System.err.println("Impossible to add a travel for some reasons :-(");
        }
    }

    /**
     * Remove a travel from the agent's calendar
     * @param t Travel to remove
     */
    public void removeTravel(Travel t) {
        if (!calendar.removeTravel(t)) {
            System.err.println("Impossible to remove a travel for some reasons :-(");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agent agent = (Agent) o;
        if (agent.getName().equals(name)) {
            if (agent.getBirthplace().equals(birthplace)) {
                if (agent.getRole().equals("Agent")) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return false;
    }
}
