package fr.unantes.software.construction.ui;

import fr.unantes.software.construction.calendar.Travel;
import fr.unantes.software.construction.calendar.City;

import fr.unantes.software.construction.people.Agent;
import fr.unantes.software.construction.security.UserManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.InvalidClassException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class ctrlAgent {
    public TableView FCKINGTEST;
    public TableColumn vDep;
    public TableColumn pDep;
    public TableColumn hDep;
    public TableColumn vArr;
    public TableColumn pArr;
    public TableColumn hArr;


    public TextField test;
    private UserManager bd;
    private String nom;
    private Agent courant;

    public ctrlAgent(UserManager bd, String nom){
        this.bd = bd;
        this.nom = nom;

    }


    public void afficher(ActionEvent actionEvent) throws InvalidClassException {
        FCKINGTEST.setEditable(false);


        ArrayList<Agent> listeAgent = bd.getAgents();


        courant = listeAgent.get(listeAgent.indexOf(bd.getNamesToUsers().get(nom)));
        Collection<Travel> travels = courant.getCalendar().getTravels().get();
        System.out.println(travels);

        ArrayList<Voyage> listeVoyages = new ArrayList<>();

        for(Travel trav : travels){
            City villeArr = (City)trav.getFirstStep().getStartCity().get();
            City villeDep = (City)trav.getLastStep().getDestinationCity().get();
            listeVoyages.add(new Voyage(villeDep.getName(),villeDep.getCountry(),trav.getFirstStep().getStartTime(), villeArr.getName(), villeArr.getCountry(), trav.getLastStep().getArrivalTime()));
        }


        vDep.setCellValueFactory(new PropertyValueFactory<Voyage,String>("departV"));
        pDep.setCellValueFactory(new PropertyValueFactory<Voyage,String>("departP"));
        hDep.setCellValueFactory(new PropertyValueFactory<Voyage,Date>("hDep"));
        vArr.setCellValueFactory(new PropertyValueFactory<Voyage,String>("arriveeV"));
        pArr.setCellValueFactory(new PropertyValueFactory<Voyage,String>("arriveeP"));
        hArr.setCellValueFactory(new PropertyValueFactory<Voyage,Date>("hArr"));
        ObservableList<Voyage> list1 = FXCollections.observableArrayList(listeVoyages);



        FCKINGTEST.setItems(list1);


    }

    public void ajouter(ActionEvent actionEvent) {
        System.out.println(FCKINGTEST);
    }
}
