package fr.unantes.software.construction.calendar;

import java.util.*; //Importation des packages

/**
 * A correspondence has a start and arrival city, as well as a start and arrival Date
 */
public class Correspondence {
    private SingleReference<Travel> travel;
    private SingleReference<City> startCity = new SingleReferenceToCity();
    private SingleReference<City> destinationCity = new SingleReferenceToCity();
    private Date startTime; //Changement du type
    private Date arrivalTime; //Changement du type

    /**
     * Correspondence's constructor
     * @param startCity - the City where the correspondence starts
     * @param destinationCity - the City where the correspondence ends
     * @param startTime - the Date where the correspondence starts
     * @param arrivalTime - the Date where the correspondence ends
     */
    public Correspondence(City startCity, City destinationCity, Date startTime, Date arrivalTime) {
        this.travel = new SingleBidirectionnalReferenceToCorrespondence(this);
        if (startCity == null){throw new IllegalArgumentException("start city cannot be null");}
        this.startCity.set(startCity);
        if(destinationCity == null){throw new IllegalArgumentException("destination city cannot be null");}
        this.destinationCity.set(destinationCity);
        if(arrivalTime.before(startTime)){throw new IllegalArgumentException("arrival time cannot be before start time");}
        this.startTime = startTime;
        this.arrivalTime = arrivalTime;
    }

    /**
     * Method to get the correspondence's travel
     * @return a Single Reference to travel(to get the corresponding travel, use SingleReference's method get)
     */
   public SingleReference<Travel> getTravel() {
        return travel;
    }

    /**
     * Method to set the correspondence's travel
     * @param travel the new correspondence's travel
     */
    public void setTravel(Travel travel) {
        if (travel==null){throw new IllegalArgumentException("travel cannot be null");}
        this.travel.set(travel);
    }

    /**
     * Method to get the departure city
     * @return a single reference to City (to get the city itself, use the SingleReference's method get)
     */
    public SingleReference getStartCity() {
        return startCity;
    }

    /**
     * Method to set the departure city
     * @param startCity -  the new departure city
     */
    public void setStartCity(City startCity) {
        if (startCity == null){throw new IllegalArgumentException("startCity cannot be null");}
        this.startCity.set(startCity);
    }

    /**
     * Method to get the destination city
     * @return a single reference to City (to get the city itself, use the SingleReference's method get)
     */
    public SingleReference getDestinationCity() {
        return destinationCity;
    }

    /**
     * Method to set the destination city
     * @param destinationCity -  the new destination city
     */
    public void setDestinationCity(City destinationCity) {
        if (destinationCity == null){throw new IllegalArgumentException("destinationCity cannot be null");}
        this.destinationCity.set(destinationCity);
    }

    /**
     * Method to get the departure Date
     * @return the departure Date
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * Method to set the departure Date
     * @param startTime - the new departure Date
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    } //Changement du type de retour et du paramètre

    /**
     * Method to get the arrival Date
     * @return the arrival Date
     */
    public Date getArrivalTime() {
        return arrivalTime;
    } //Changement du type de retour et du paramètre

    /**
     * Method to set the arrival Date
     * @param arrivalTime - the new arrival Date
     */
    public void setArrivalTime(Date arrivalTime) {
        if (arrivalTime.before(this.startTime)){throw new IllegalArgumentException("arrival cannot be before start");}
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

}
