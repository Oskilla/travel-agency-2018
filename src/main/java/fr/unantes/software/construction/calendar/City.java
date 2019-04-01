package fr.unantes.software.construction.calendar;

import java.util.Objects;

/**
 * A city, defined by a countr yand a name, both immutable
 */
public class City {
    private final String country;
    private final String name;

    /**
     * City's contructor
     * @param country - the city's country
     * @param name - the city's name
     */
    public City(String country, String name) {
        this.country = country;
        this.name = name;
    }

    /**
     * Method to get the city's country
     * @return the city's country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Method to get the city's name
     * @return the city's name
     */
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return getCountry().equals(city.getCountry()) &&
                getName().equals(city.getName());
    }
}
