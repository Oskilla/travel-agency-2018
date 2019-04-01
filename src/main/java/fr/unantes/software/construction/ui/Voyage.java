package fr.unantes.software.construction.ui;

import fr.unantes.software.construction.calendar.City;
import fr.unantes.software.construction.calendar.Correspondence;
import fr.unantes.software.construction.calendar.Travel;


import java.util.Date;

/**
 * Voyage class - used to display travels into tables
 */
//In order to display travels in a table, using a made-up class appeared to be a lot easier, as it regroups all the important information
public class Voyage {

    private String departV;
    private String departP;
    private Date hDep;
    private String arriveeV;
    private String arriveeP;
    private Date hArr;

    /**
     * Contructor
     * @param departV the departure city
     * @param departP the departure country
     * @param hDep the departure time
     * @param arriveeV the arrival city
     * @param arriveeP the arrival country
     * @param hArr the arrival time
     */
    public Voyage(String departV, String departP, Date hDep, String arriveeV, String arriveeP, Date hArr) {
        this.departV = departV;
        this.departP = departP;
        this.hDep = hDep;
        this.arriveeV = arriveeV;
        this.arriveeP = arriveeP;
        this.hArr = hArr;
    }

    /* Getters and setters */
    public String getDepartV() {
        return departV;
    }

    public void setDepartV(String departV) {
        this.departV = departV;
    }

    public String getDepartP() {
        return departP;
    }

    public void setDepartP(String departP) {
        this.departP = departP;
    }

    public Date gethDep() {
        return hDep;
    }

    public void sethDep(Date hDep) {
        this.hDep = hDep;
    }

    public String getArriveeV() {
        return arriveeV;
    }

    public void setArriveeV(String arriveeV) {
        this.arriveeV = arriveeV;
    }

    public String getArriveeP() {
        return arriveeP;
    }

    public void setArriveeP(String arriveeP) {
        this.arriveeP = arriveeP;
    }

    public Date gethArr() {
        return hArr;
    }

    public void sethArr(Date hArr) {
        this.hArr = hArr;
    }

    /**
     * Method checking if the departure and arrival places are equals to a given travel.
     * This method does not checks anything about intermediary steps
     * @param t - the travel to check
     * @param c - the correspondance
     * @return true if the travel fits the current voyage, false otherwise
     */
    public boolean equalsTravel(Travel t, Correspondence c){
        City villeArr = (City)t.getFirstStep().getStartCity().get();
        City villeDep = (City)t.getLastStep().getDestinationCity().get();
        return villeArr.getName()==this.getArriveeV()&&villeArr.getCountry()==this.getArriveeP()
                &&villeDep.getName()==this.getDepartV()&&villeDep.getCountry()==this.getDepartP();
    }
}
