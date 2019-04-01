package fr.unantes.software.construction.calendar;

/**
 * Single Bidirectionnal Reference to Travel class
 */
public class  SingleBidirectionnalReferenceToTravel extends SingleBidirectionnalReference<Calendar>{
    private Travel trav;

    /**
     * Constructor
     * @param trav - the corresponding travel
     */
    public SingleBidirectionnalReferenceToTravel(Travel trav){ this.trav = trav;}

    /* Abstract class' method implementation */
    @Override
    protected void propagateSet(Calendar newvalue) {
        if(isSet()){
            this.unset();
        }
        newvalue.getTravels().add(trav);
    }

    /**
     * Method that will unset the travel reference
     */
    public void unset(){
        if (this.att.getTravels().contains(trav)){
            this.att.getTravels().basicRemove(trav);
        }
        this.basicUnset();
    }
}
