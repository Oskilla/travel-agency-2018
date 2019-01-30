package fr.unantes.software.construction.model;

import fr.unantes.software.construction.common.People;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A Travel goes from one place to another, with a departure date and an arrival date
 */
public class Travel {
    private City destination = null;
    private City origin = null;
    public int departure;
    public int arrival;
    private List<People> participants = new ArrayList<>();

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

    /**
     * add some to the trip
     * @param participant People to add
     * @param maxNumberParticipants Max number of participants (if null, defaults to 10)
     * @throws IllegalArgumentException if sometinhg went wrong
     */
    public void addParticipant(People participant, Integer maxNumberParticipants) throws IllegalArgumentException{
        // default max number of participants to 10
        if (maxNumberParticipants == null) {
            maxNumberParticipants = 10;
        }
        if (participants.size() > maxNumberParticipants) {
            throw new IllegalArgumentException("Too many participants to this travel");
        }
        participants.add(participant);
    }

    /**
     * remove someone from the trip
     * @param pp People to remove
     */
    public void removeParticipantFromTravel(People pp) {
        participants.remove(pp);
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
