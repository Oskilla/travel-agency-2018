package fr.unantes.software.construction.calendar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MultipleBidirectionnalReferencesToTravel implements MultipleReferences<Correspondence> {
    private List<Correspondence> corr = new ArrayList<>();
    private final int max;
    private final int min;
    private Travel trav;

    public MultipleBidirectionnalReferencesToTravel(Travel trav, int max, int min) {
        this.trav = trav;
        this.max = max;
        this.min = min;
    }

    @Override
    public Collection<Correspondence> get() {
        return Collections.unmodifiableCollection(corr);
    }

    @Override
    public boolean add(Correspondence value) {
        if(this.size() >= max) {return false;}

        if(value.getTravel().isSet()){
            value.getTravel().unset();
        }
        value.getTravel().basicSet(trav);
        this.basicAdd(value);
        return true;
    }

    @Override
    public boolean remove(Correspondence value) {
        if (this.size()<=min) {return false;}
        if (value.getTravel().isSet()) {
            value.getTravel().unset();
        }
        return true;
    }

    @Override
    public boolean contains(Correspondence value) {
        return corr.contains(value);
    }

    @Override
    public int size() {
        return corr.size();
    }

    @Override
    public void basicAdd(Correspondence value) {
        corr.add(value);
    }

    @Override
    public void basicRemove(Correspondence value) {
        corr.remove(value);
    }
    public Correspondence getFirstStep(){
        return corr.get(0);
    }
    public Correspondence getLastStep(){
        return corr.get(corr.size()-1);
    }
}
