package fr.unantes.software.construction.calendar;

import java.util.Collection;

/**
 * Multiple Reference interface
 * @param <T>
 */
public interface MultipleReferences<T> {

    /**
     * Method that will add a value to the Multiple reference's list and apply the changes to the corresponding object
     * @param value - the value to add
     * @return true if the value has been added, false otherwise
     */
    boolean add (T value);

    /**
     * Method that will remove a value from the Multiple reference's list and apply the changes to the corresponding object
     * @param value - the value to remove
     * @return true if the value has been removed, false otherwise
     */
    boolean remove(T value);

    /**
     * Method that will check if a value is in the Multiple reference's list
     * @param value the value to look for
     * @return true if the value is in the list, false otherwise
     */
    boolean contains(T value);

    /**
     * Method that will give the number of values in the Multiple reference's list
     * @return the size of the list (numbers of values in it)
     */
    int size();

    /**
     * Method that will add a value to the Multiple reference's list without applying the changes to the corresponding object
     * Method called by the corresponding object
     * @param value - the value to add
     */
    void basicAdd(T value);

    /**
     * Method that will remove a value from the Multiple reference's list without applying the changes to the corresponding object
     * Method called by the corresponding object
     * @param value - the value to add
     */
    void basicRemove(T value);

    /**
     * Method that will return the Multiple reference's list
     * @return the Multiple reference's list
     */
    Collection<T> get();
}
