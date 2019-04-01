package fr.unantes.software.construction.calendar;

/**
 * Single Bidirectionnal Reference to Correspondence class
 */
public class SingleBidirectionnalReferenceToCorrespondence extends SingleBidirectionnalReference<Travel>{
    private Correspondence corr;

    /**
     * Constructor
     * @param corr - the corresponding correspondence
     */
    public SingleBidirectionnalReferenceToCorrespondence(Correspondence corr){this.corr = corr;}

    /* Abstract class' method implementation */
    @Override
    protected void propagateSet(Travel newvalue) {
        if(this.isSet()){
            this.unset();
        }
        newvalue.getSteps().add(corr);
    }

    /**
     * Method that will unset the correspondence reference
     */
    public void unset(){
        if (this.att.getSteps().contains(corr)){
            this.att.getSteps().basicRemove(corr);
        }
        this.basicUnset();
    }
}
