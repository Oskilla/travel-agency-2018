package fr.unantes.software.construction.calendar;

public class SingleBidirectionnalReferenceToCorrespondence extends SingleBidirectionnalReference<Travel>{
    private Correspondence corr;
    public SingleBidirectionnalReferenceToCorrespondence(Correspondence corr){this.corr = corr;}

    @Override
    protected void propagateSet(Travel newvalue) {
        if(this.isSet()){this.unset();}
        newvalue.getSteps().add(corr);
    }
    public void unset(){
        if (this.att.getSteps().contains(corr)){
            this.att.getSteps().basicRemove(corr);
        }
        this.basicUnset();
    }
}
