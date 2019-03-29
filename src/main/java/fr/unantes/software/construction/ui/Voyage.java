package fr.unantes.software.construction.ui;

import fr.unantes.software.construction.calendar.City;
import fr.unantes.software.construction.calendar.Correspondence;
import fr.unantes.software.construction.calendar.Travel;


import java.util.Date;

public class Voyage {

    private String departV;
    private String departP;
    private Date hDep;
    private String arriveeV;
    private String arriveeP;
    private Date hArr;

    public Voyage(String departV, String departP, Date hDep, String arriveeV, String arriveeP, Date hArr) {
        this.departV = departV;
        this.departP = departP;
        this.hDep = hDep;
        this.arriveeV = arriveeV;
        this.arriveeP = arriveeP;
        this.hArr = hArr;
    }

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

    public boolean equalsTravel(Travel t, Correspondence c){
        City villeArr = (City)t.getFirstStep().getStartCity().get();
        City villeDep = (City)t.getLastStep().getDestinationCity().get();
        return villeArr.getName()==this.getArriveeV()&&villeArr.getCountry()==this.getArriveeP()
                &&villeDep.getName()==this.getDepartV()&&villeDep.getCountry()==this.getDepartP();
    }
}
