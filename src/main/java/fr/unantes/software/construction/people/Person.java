package fr.unantes.software.construction.people;

import fr.unantes.software.construction.calendar.Calendar;
import fr.unantes.software.construction.calendar.Travel;

import java.io.InvalidClassException;
import java.util.Objects;

/**
 * A Generic person, which can be an agent or an administrator
 */
public class Person {

    public String name;


    public Person(String name) throws InvalidClassException {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
