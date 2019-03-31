package fr.unantes.software.construction.calendar;

import fr.unantes.software.construction.people.Agent;

public class SingleBidirectionnalReferenceToCalendar extends SingleBidirectionnalReference<Agent> {
    private Calendar calendar;
    private Calendar othercal;
    private Agent otheragt;
    public SingleBidirectionnalReferenceToCalendar(Calendar calendar){
    this.calendar = calendar;
    }
    @Override
    protected void propagateSet(Agent newvalue) {
        othercal = newvalue.getCalendar().att;
        otheragt = this.att;
    if(this.isSet()){this.unset();}
    if(newvalue.getCalendar().isSet()){
        newvalue.getCalendar().unset();
    }
    newvalue.getCalendar().basicSet(calendar);
    }
    public void unset(){
        if(this.att.getCalendar().isSet()){
            this.att.getCalendar().basicUnset();
        }
        this.basicUnset();
    }
}
