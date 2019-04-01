package fr.unantes.software.construction.calendar;

/**
 * Single Reference interface
 * @param <T>
 */
public interface SingleReference<T> {

    /**
     * Method that will set the value of the Single reference and apply the changes to the corresponding object
     * @param newvalue - the value to set
     */
    void set (T newvalue);

    /**
     * Method that will get the value of the correpsonding object
     * @return the corresponding object
     */
    T get();

    /**
     * Method that will unset the Single reference and apply the changes to the corresponding object
     */
    void unset();

    /**
     * Method that will check if the Single reference is set
     * @return true if it is set, false otherwise
     */
    boolean isSet();

    /**
     * Method that will set the value of the Single reference without applying the changes to the corresponding object
     * Method called by the corresponding object
     * @param newvalue - the value to set
     */
    void basicSet(T newvalue);

    /**
     * Method that will unset the Single reference without applying the changes to the corresponding object
     * Method called by the corresponding objects
     */
    void basicUnset();
}
