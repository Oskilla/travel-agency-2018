package fr.unantes.software.construction.calendar;

public abstract class SingleBidirectionnalReference<T> implements SingleReference<T> {
    protected  T att;

    /**
     * Method that will propagate a change of value
     * @param newvalue - the new value to set
     */
    abstract protected void propagateSet(T newvalue);


    /* Interface's methods implementation */
    @Override
    public void set(T newvalue) {
        propagateSet(newvalue);
        basicSet(newvalue);
    }

    @Override
    public T get() {
        return att;
    }

    @Override
    public void unset() {}

    @Override
    public boolean isSet() {
        return att !=null;
    }

    @Override
    public void basicSet(T newvalue) {
        att = newvalue;
    }

    @Override
    public void basicUnset() {
        att = null;
    }
}
