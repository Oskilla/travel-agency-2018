package fr.unantes.software.construction.calendar;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;

/**
 * A Travel goes from one place to another, with a departure date and an arrival date
 */
public class Travel {
    @NotNull
    private ArrayList<Correspondence> steps ;
    private static final int taillesteps = 10;
    private static final int taillemin = 1;
    private SingleRefenrence<Calendar> parent = new SingleBidirectionnalReferenceToTravel(this);

    public Travel(Calendar parent) {
        steps = new ArrayList<>(taillesteps);
        setParent(parent);
    }

    public SingleRefenrence<Calendar> getParent() {
        return parent;
    }

    public void setParent(Calendar parent) { this.parent.set(parent); }

    public Correspondence getFirstStep() {
        return (Correspondence) steps.get(0);
    }

    public Correspondence getLastStep() {
        return (Correspondence) steps.get(steps.size() - 1);
    }

    public boolean addCorrespondence(Correspondence step, int index) {

        if (steps.size()==10) {return false;}
        steps.add(index,step);
        return true;
    }
    public boolean addCorrespondence (Correspondence step){
        if (steps.size()==taillesteps) {return false;}
        return steps.add(step);
    }
    public boolean removeCorrespondence(Correspondence step) {
        if (steps.size()==taillemin){return false;}
        return steps.remove(step);
    }
}
