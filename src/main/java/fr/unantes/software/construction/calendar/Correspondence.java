package fr.unantes.software.construction.calendar;

import java.util.Objects;
import java.util.*; //Importation des packages

public class Correspondence {
    private SingleRefenrence<Travel> travel;
    private SingleRefenrence<City> startCity = new SingleReferenceToCity();
    private SingleRefenrence<City> destinationCity = new SingleReferenceToCity();
    private Date startTime; //Changement du type
    private Date arrivalTime; //Changement du type

    public Correspondence(City startCity, City destinationCity, Date startTime, Date arrivalTime) {
        this.travel = new SingleBidirectionnalReferenceToCorrespondence(this);
        this.startCity.set(startCity);
        this.destinationCity.set(startCity);
        this.startTime = startTime;
        this.arrivalTime = arrivalTime;
    }

    public SingleRefenrence<Travel> getTravel() {
        return travel;
    }

    public void setTravel(Travel travel) {
        this.travel.set(travel);
    }

    public SingleRefenrence getStartCity() {
        return startCity;
    }

    public void setStartCity(City startCity) {
        this.startCity.set(startCity);
    }

    public SingleRefenrence getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(City destinationCity) {
        this.destinationCity.set(destinationCity);
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    } //Changement du type de retour et du paramètre

    public Date getArrivalTime() {
        return arrivalTime;
    } //Changement du type de retour et du paramètre

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Correspondence that = (Correspondence) o;
        return getStartCity().equals(that.getStartCity()) &&
                getDestinationCity().equals(that.getDestinationCity()) &&
                getStartTime() == that.getStartTime() &&
                getArrivalTime() == that.getArrivalTime();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTravel(), getStartCity(), getDestinationCity(), getStartTime(), getArrivalTime());
    }
}
