package fr.unantes.software.construction.calendar;

public interface MultipleReferences<T> {
    boolean add (T value);

    boolean remove(T value);

    boolean contains(T value);

    int size();

    void basicAdd(T value);

    void basicRemove(T value);
}
