package fr.unantes.software.construction.ui;

import fr.unantes.software.construction.calendar.Correspondence;
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
    public TableView tableTravelUser;
    public TableColumn vDep1;
    public TableColumn pDep1;
    public TableColumn hDep1;
    public TableColumn vArr1;
    public TableColumn pArr1;
    public TableColumn hArr1;

    public TableView tableTravel;
    public TableColumn vDep2;
    public TableColumn pDep2;
    public TableColumn hDep2;
    public TableColumn vArr2;
    public TableColumn pArr2;
    public TableColumn hArr2;


    public TextField test;
    private UserManager bd;
    private String nom;
    private Agent courant;
    private ArrayList<Travel> bd2;

    public ctrlAgent(UserManager bd, ArrayList<Travel> bd2, String nom){
        this.bd = bd;
        this.bd2 = bd2;
        this.nom = nom;
        ArrayList<Agent> listeAgent = bd.getAgents();

        this.courant = listeAgent.get(listeAgent.indexOf(bd.getNamesToUsers().get(nom)));

    }


    public void update() throws InvalidClassException {
        tableTravelUser.setEditable(false);


        Collection<Travel> voyagesUsers = courant.getCalendar().get().getTravels().get();



        System.out.println(voyagesUsers);
        ArrayList<Voyage> listeVoyagesUser = new ArrayList<>();

        for(Travel trav : voyagesUsers){
            City villeArr = (City)trav.getFirstStep().getStartCity().get();
            City villeDep = (City)trav.getLastStep().getDestinationCity().get();
            listeVoyagesUser.add(new Voyage(villeDep.getName(),villeDep.getCountry(),trav.getFirstStep().getStartTime(), villeArr.getName(), villeArr.getCountry(), trav.getLastStep().getArrivalTime()));
        }


        vDep1.setCellValueFactory(new PropertyValueFactory<Voyage,String>("departV"));
        pDep1.setCellValueFactory(new PropertyValueFactory<Voyage,String>("departP"));
        hDep1.setCellValueFactory(new PropertyValueFactory<Voyage,Date>("hDep"));
        vArr1.setCellValueFactory(new PropertyValueFactory<Voyage,String>("arriveeV"));
        pArr1.setCellValueFactory(new PropertyValueFactory<Voyage,String>("arriveeP"));
        hArr1.setCellValueFactory(new PropertyValueFactory<Voyage,Date>("hArr"));
        ObservableList<Voyage> list1 = FXCollections.observableArrayList(listeVoyagesUser);


        tableTravelUser.setItems(list1);


    }



    public void afficher2(ActionEvent actionEvent) throws InvalidClassException {
        tableTravelUser.setEditable(false);

        ArrayList<Voyage> listeVoyages = new ArrayList<>();

        for(Travel travel : bd2){
            City villeArr = (City)travel.getFirstStep().getStartCity().get();

            City villeDep = (City)travel.getLastStep().getDestinationCity().get();
            listeVoyages.add(new Voyage(villeDep.getName(),villeDep.getCountry(),travel.getFirstStep().getStartTime(), villeArr.getName(), villeArr.getCountry(), travel.getLastStep().getArrivalTime()));
        }

        vDep2.setCellValueFactory(new PropertyValueFactory<Voyage,String>("departV"));
        pDep2.setCellValueFactory(new PropertyValueFactory<Voyage,String>("departP"));
        hDep2.setCellValueFactory(new PropertyValueFactory<Voyage,Date>("hDep"));
        vArr2.setCellValueFactory(new PropertyValueFactory<Voyage,String>("arriveeV"));
        pArr2.setCellValueFactory(new PropertyValueFactory<Voyage,String>("arriveeP"));
        hArr2.setCellValueFactory(new PropertyValueFactory<Voyage,Date>("hArr"));
        ObservableList<Voyage> list2 = FXCollections.observableArrayList(listeVoyages);
        tableTravel.setItems(list2);

    }


    public void ajouter(ActionEvent actionEvent) throws InvalidClassException {
        Voyage voyage = (Voyage)tableTravel.getSelectionModel().getSelectedItem();
        System.out.println(voyage);
        Travel tmp=null;
        for (Travel t : bd2){
            for (Correspondence c : t.getSteps().get()){
                City villeArr = (City)t.getFirstStep().getStartCity().get();

                City villeDep = (City)t.getLastStep().getDestinationCity().get();
                System.out.println(villeArr.getName());
                System.out.println(voyage.getArriveeV());
                System.out.println(villeArr.getCountry());
                System.out.println(voyage.getArriveeP());
                System.out.println(villeDep.getName());
                System.out.println(voyage.getDepartV());
                System.out.println(villeDep.getCountry());
                System.out.println(voyage.getDepartP());


                if(voyage.equalsTravel(t,c)){
                    tmp=t;
                }
            }
        }
        System.out.println(tmp);
        if(tmp!=null){
            System.out.println("la");

            courant.getCalendar().get().addTravel(bd2.get(bd2.indexOf(tmp)));
        }else{
            System.out.println("ici");
        }
        update();
    }

}
