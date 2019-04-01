package fr.unantes.software.construction.calendar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Multiple Bidirectionnal Reference to Calendar class
 */
public class MultipleBidirectionnalReferencesToCalendar implements MultipleReferences<Travel> {
    private List<Travel> travs = new ArrayList<>();
    private final int max;
    private  Calendar cal;

    /**
     * Constructor
     * @param cal - the attribute calendar
     * @param max - the maximum number of travels in a calendar
     */
    public MultipleBidirectionnalReferencesToCalendar(Calendar cal, int max){this.cal=cal; this.max = max;}



    /* Interface's methods implementation */

    @Override
    public Collection<Travel> get() {
        return Collections.unmodifiableCollection(travs);
    }

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
