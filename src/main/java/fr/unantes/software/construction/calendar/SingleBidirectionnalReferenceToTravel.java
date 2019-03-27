package fr.unantes.software.construction.calendar;

public class  SingleBidirectionnalReferenceToTravel extends SingleBidirectionnalReference<Calendar>{
    private Travel trav;
    public SingleBidirectionnalReferenceToTravel(Travel trav){ this.trav = trav;}

    @Override
    protected void propagateSet(Calendar newvalue) {
        if(isSet()){this.unset();}
        newvalue.getTravels().add(trav);
    }
    public void unset(){
        if (this.att.getTravels().contains(trav)){
            this.att.getTravels().basicRemove(trav);
        }
        this.basicUnset();
    }
}
