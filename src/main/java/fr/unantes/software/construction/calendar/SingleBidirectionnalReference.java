package fr.unantes.software.construction.calendar;

public abstract class SingleBidirectionnalReference<T> implements SingleRefenrence<T> {
    protected  T att;

    @Override
    public void set(T newvalue) {
        propagateSet(newvalue);
        basicSet(newvalue);
    }

    abstract protected void propagateSet(T newvalue);

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
