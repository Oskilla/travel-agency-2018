package fr.unantes.software.construction.calendar;

import java.util.LinkedList;
import java.util.List;

/**
 * A Travel goes from one place to another, with a departure date and an arrival date
 */
public class Travel {
    private List<Correspondence> steps;
    private Calendar parent;

    public Travel(Calendar parent) {
        this.parent = parent;
        steps = new LinkedList<>();
    }

    public Calendar getParent() {
        return parent;
    }

    public void setParent(Calendar parent) {
        this.parent = parent;
    }

    public Correspondence getFirstStep() {
        return steps.get(0);
    }

    public Correspondence getLastStep() {
        return steps.get(steps.size() - 1);
    }

    public boolean addCorrespondence(Correspondence step) {
        return steps.add(step);
    }

    public boolean removeCorrespondence(Correspondence step) {
        return steps.remove(step);
    }
}
