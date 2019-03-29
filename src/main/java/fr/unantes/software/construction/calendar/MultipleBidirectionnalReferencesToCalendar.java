package fr.unantes.software.construction.calendar;

import java.util.ArrayList;
import java.util.List;

public class MultipleBidirectionnalReferencesToCalendar implements MultipleReferences<Travel> {
    private List<Travel> travs = new ArrayList<>();
    private final int max;
    private  Calendar cal;

    public MultipleBidirectionnalReferencesToCalendar(Calendar cal, int max){this.cal=cal; this.max = max;}

    @Override
    public boolean add(Travel value) {
        if(this.size() > max) {return false;}
        if(value.getParent().isSet()){
            value.getParent().unset();
        }
        value.getParent().basicSet(cal);
        this.basicAdd(value);
        return true;
    }

    @Override
    public boolean remove(Travel value) {
        if(value.getParent().isSet())
        {
            value.getParent().unset();
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Travel value) {
        return travs.contains(value);
    }

    @Override
    public int size() {
        return travs.size();
    }

    @Override
    public void basicAdd(Travel value) {
       travs.add(value);
    }

    @Override
    public void basicRemove(Travel value) {
        travs.remove(value);

    }
}