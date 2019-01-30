package fr.unantes.software.construction.model;

/**
 * A city is a large human settlement. Cities generally have extensive systems for housing, transportation, sanitation, utilities,
 * land use, and communication. Their density facilitates interaction between people, government organizations and businesses,
 * sometimes benefiting different parties in the process.
 *
 * Historically, city-dwellers have been a small proportion of humanity overall,
 * but following two centuries of unprecedented and rapid urbanization, roughly half of the world population now lives in cities,
 * which has had profound consequences for global sustainability.
 * Present-day cities usually form the core of larger metropolitan areas and urban areas—creating numerous commuters traveling towards
 * city centers for employment, entertainment, and edification.
 * However, in a world of intensifying globalization, all cities are in different degree also connected globally beyond these regions.
 *
 * The most populated city proper is Chongqing while the most populous metropolitan areas are the Greater Tokyo Area,
 * the Shanghai area, and Jabodetabek (Jakarta). The cities of Faiyum, Damascus, and Varanasi are among those laying
 * claim to longest continual inhabitation.
 */
public class City {
    public String country;
    public String name;

    public City(String country, String name) {
        this.country = country;
        this.name = name;
    }
}
