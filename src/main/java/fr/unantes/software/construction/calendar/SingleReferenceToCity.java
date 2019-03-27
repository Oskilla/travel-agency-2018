package fr.unantes.software.construction.calendar;

public class SingleReferenceToCity implements SingleRefenrence<City> {
    protected City city;
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
