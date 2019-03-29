package fr.unantes.software.construction.calendar;

import com.sun.istack.internal.NotNull;

import java.io.InvalidClassException;
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

    public Travel(Calendar parent) throws InvalidClassException {
        steps = new MultipleBidirectionnalReferencesToTravel(this, taillesteps, taillemin);
        setParent(parent);
    }

    public SingleRefenrence<Calendar> getParent() {
        return parent;
    }

    public void setParent(Calendar parent) throws InvalidClassException { this.parent.set(parent); }

    public Correspondence getFirstStep() {
        return steps.getFirstStep();
    }

    public Correspondence getLastStep() {
        return steps.getLastStep();
    }
    public MultipleBidirectionnalReferencesToTravel getSteps(){return steps;}
    public boolean addCorrespondence (Correspondence step) throws InvalidClassException {
        if (steps.size()==taillesteps) {return false;}
        return steps.add(step);
    }
    public boolean removeCorrespondence(Correspondence step) throws InvalidClassException {
        if (steps.size()==taillemin){return false;}
        return steps.remove(step);
    }
}
