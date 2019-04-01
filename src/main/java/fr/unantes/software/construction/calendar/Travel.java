package fr.unantes.software.construction.calendar;

import com.sun.istack.internal.NotNull;

import java.io.InvalidClassException;
import java.util.ArrayList;

/**
 * A Travel has up to 10 steps/correspondences
 */
public class Travel {
    @NotNull
    private MultipleBidirectionnalReferencesToTravel steps ;
    private static final int taillesteps = 10;
    private static final int taillemin = 1;
    private SingleRefenrence<Calendar> parent = new SingleBidirectionnalReferenceToTravel(this);

    /**
     * Travel's constructor
     * @param parent - the Calendar in which the travel will be
     * @throws InvalidClassException
     */
    public Travel(Calendar parent) throws InvalidClassException {
        steps = new MultipleBidirectionnalReferencesToTravel(this, taillesteps, taillemin);
        setParent(parent);
    }

    /**
     * Travel's constructor if no calendar is associated with it
     * @throws InvalidClassException
     */
    public Travel() throws InvalidClassException {
        steps = new MultipleBidirectionnalReferencesToTravel(this, taillesteps, taillemin);
    }

    /**
     * Method to get the Calendar in which the travel is in
     * @return a single reference to calendar - to get the Calendar itself, use the single reference's method get
     */
    public SingleRefenrence<Calendar> getParent() {
        return parent;
    }

    /**
     * Method to set the new Calendar parent
     * @param parent - the new parent
     * @throws InvalidClassException
     */
    public void setParent(Calendar parent) throws InvalidClassException { this.parent.set(parent); }

    /**
     * method to get the first correspondence of the travel
     * @return the first correspondence
     */
    public Correspondence getFirstStep() {
        return steps.getFirstStep();
    }

    /**
     * method to get the last correspondence of the travel
     * @return the last correspondence
     */
    public Correspondence getLastStep() {
        return steps.getLastStep();
    }

    /**
     * Method to get the travel's correspondances
     * @return a multiple reference to travel - to get an ArrayList of correspondences, use MultipleBidirectionnalReferencesToTravel's method get
     */
    public MultipleBidirectionnalReferencesToTravel getSteps(){return steps;}

    /**
     * MEthod to add a correspodence to the travel
     * @param step the correspondence to add
     * @return true if the correspondence has been added, false otherwise
     * @throws InvalidClassException
     */
    public boolean addCorrespondence (Correspondence step) throws InvalidClassException {
        if (steps.size()==taillesteps) {return false;}
        return steps.add(step);
    }

    /**
     * Method to remove a correspondance from the travel
     * @param step the correpsondance to remove
     * @return true if the correspondence has been removed, false otherwise
     * @throws InvalidClassException
     */
    public boolean removeCorrespondence(Correspondence step) throws InvalidClassException {
        if (steps.size()==taillemin){return false;}
        return steps.remove(step);
    }
}
