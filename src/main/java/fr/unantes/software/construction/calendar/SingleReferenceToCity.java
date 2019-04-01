package fr.unantes.software.construction.calendar;

/**
 * Single Reference to City class
 */
public class SingleReferenceToCity implements SingleReference<City> {
    protected City city;

    /* Interface's methods implementation */
    @Override
    public void set(City newvalue) {
        if(this.isSet()){this.unset();}
        this.basicSet(newvalue);
    }

    @Override
    public City get() {
        return city;
    }

    @Override
    public void unset() {
        this.basicUnset();
    }

    @Override
    public boolean isSet() {
        return city!=null;
    }

    @Override
    public void basicSet(City newvalue) {
        city = newvalue;
    }

    @Override
    public void basicUnset() {
        city = null;
    }
}
