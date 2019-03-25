package fr.unantes.software.construction.calendar;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;

/**
 * A Travel goes from one place to another, with a departure date and an arrival date
 */
public class Travel {
    @NotNull
    private MultipleBidirectionnalReferencesToTravel steps ;
    private static final int taillesteps = 10;
    private static final int taillemin = 1;
    private SingleRefenrence<Calendar> parent = new SingleBidirectionnalReferenceToTravel(this);

    public Travel(Calendar parent) {
        steps = new MultipleBidirectionnalReferencesToTravel(this, taillesteps, taillemin);
        setParent(parent);
    }

    public SingleRefenrence<Calendar> getParent() {
        return parent;
    }

    public void setParent(Calendar parent) { this.parent.set(parent); }

    public Correspondence getFirstStep() {
        return steps.getFirstStep();
    }

    public Correspondence getLastStep() {
        return steps.getLastStep();
    }
    public MultipleBidirectionnalReferencesToTravel getSteps(){return steps;}
    private boolean addCorrespondence(Correspondence step, int index) {

        if (steps.size()==10) {return false;}
        steps.add(step);
        return true;
    }
    private boolean addCorrespondence (Correspondence step){
        if (steps.size()==taillesteps) {return false;}
        return steps.add(step);
    }
    private boolean removeCorrespondence(Correspondence step) {
        if (steps.size()==taillemin){return false;}
        return steps.remove(step);
    }
}
