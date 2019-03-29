package fr.unantes.software.construction.calendar;

import fr.unantes.software.construction.people.Agent;


public class SingleBidirectionnalReferenceToPerson extends SingleBidirectionnalReference<Calendar> {
    private Agent agent;
    public SingleBidirectionnalReferenceToPerson(Agent agent){
        this.agent = agent;
    }
    @Override
    protected void propagateSet(Calendar newvalue) {
        if(this.isSet()){this.unset();}
        if(newvalue.getOwner().isSet()){newvalue.getOwner().unset();}
        newvalue.getOwner().basicSet(agent);
    }
    public void unset(){
        if(this.att.getOwner().isSet()){
            this.att.getOwner().basicUnset();
        }
        this.basicUnset();
    }
}
