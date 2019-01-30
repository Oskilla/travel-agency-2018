package fr.unantes.software.construction.model;

import fr.unantes.software.construction.common.Agent;
import fr.unantes.software.construction.common.People;

/**
 * An administrator manage travels for agents
 */
public class Administrator extends People {

    public Administrator(String name, String birthplace) {
        super(name, birthplace, "Admin");
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
        return "Admin";
    }

    @Override
    public void setRole(String role) {
        if (!role.equals("Admin")) {
            throw new RuntimeException("Cannot set the role of an agent to something is not Admin!");
        }
    }

    /**
     * Add a travel to an agent's calendar
     * @param t Travel to add
     * @param agent Agent who is going to have a new travel added
     * @return If it was a success
     */
    public boolean addTravelForAnAgent(Travel t, Agent agent) {
        try {
            if(!agent.getCalendar().addTravelByAdministrator(t, this)) {
                System.out.println("Cannot add the travel for some reason");
                return false;
            }
        } catch(RuntimeException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Administrator admin = (Administrator) o;
        if (admin.getName().equals(name)) {
            if (admin.getBirthplace().equals(birthplace)) {
                if (admin.getRole().equals("Admin")) {
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
