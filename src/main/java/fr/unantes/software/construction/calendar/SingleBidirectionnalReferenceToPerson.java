package fr.unantes.software.construction.calendar;

import fr.unantes.software.construction.people.Agent;

/**
 * Single Bidirectionnal Reference to Person class
 */
public class SingleBidirectionnalReferenceToPerson extends SingleBidirectionnalReference<Calendar> {
    private Agent agent;

    /**
     * Constructor
     * @param agent - the corresponding agent
     */
    public SingleBidirectionnalReferenceToPerson(Agent agent){
        this.agent = agent;
    }

    /* Abstract class' method implementation */
    @Override
    protected void propagateSet(Calendar newvalue) {
        if(this.isSet()){
            this.unset();
        }
        if(newvalue.getOwner().isSet()){
            newvalue.getOwner().unset();
        }
        newvalue.getOwner().basicSet(agent);
    }

    /**
     * Method that will unset the person reference
     */
    public void unset(){
        if(this.att.getOwner().isSet()){
            this.att.getOwner().basicUnset();
        }
        this.basicUnset();
    }
}
