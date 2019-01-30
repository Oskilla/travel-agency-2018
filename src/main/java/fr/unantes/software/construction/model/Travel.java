package fr.unantes.software.construction.model;

import org.joda.time.DateTime;

import java.util.Objects;

public class Travel {
    private City destination = null;
    private City origin = null;
    public int departure;
    public int arrival;

    public Travel() {
        departure = 0;
        arrival = 1;
    }

    public Travel(City destination, City origin, int departure, int arrival) {
        this.destination = destination;
        this.origin = origin;
        this.departure = departure;
        this.arrival = arrival;
    }

    public void setDestination(City destination) {
        this.destination = destination;
    }

    public void setOrigin(City origin) {
        this.origin = origin;
    }

    public boolean isOver() {
        return DateTime.now().isAfter(arrival);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Travel travel = (Travel) o;
        return departure == travel.departure &&
                arrival == travel.arrival &&
                Objects.equals(destination, travel.destination) &&
                Objects.equals(origin, travel.origin);
    }
}
