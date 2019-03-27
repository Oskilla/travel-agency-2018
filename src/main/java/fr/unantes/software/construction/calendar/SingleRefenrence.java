package fr.unantes.software.construction.calendar;

public interface SingleRefenrence<T> {
    void set (T newvalue);
    T get();
    void unset();
    boolean isSet();
    void basicSet(T newvalue);
    void basicUnset();
}
