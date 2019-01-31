package fr.unantes.software.construction.people;

import fr.unantes.software.construction.calendar.Calendar;

import java.util.Objects;

/**
 * An agent is someone that can travel for the company
 * @extends People
 */
public class Agent extends People {

    protected Calendar calendar;

    public Agent(String name, Calendar calendar) {
        super(name);
        this.calendar = calendar;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Agent agent = (Agent) o;
        return getCalendar().equals(agent.getCalendar());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCalendar());
    }
}
