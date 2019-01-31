package fr.unantes.software.construction.people;

import java.util.Objects;

/**
 * A Generic people
 */
public abstract class People {
    protected String name;

    public People(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        People people = (People) o;
        return getName().equals(people.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
