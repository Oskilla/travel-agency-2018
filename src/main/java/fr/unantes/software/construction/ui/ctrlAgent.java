package fr.unantes.software.construction.ui;

import fr.unantes.software.construction.calendar.Correspondence;
import fr.unantes.software.construction.calendar.Travel;
import fr.unantes.software.construction.calendar.City;

import fr.unantes.software.construction.people.Agent;
import fr.unantes.software.construction.security.UserManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InvalidClassException;
import java.net.URL;
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

    public Label erreur;
    public Label erreur2;
    private UserManager bd;
    private String nom;
    private Agent courant;
    private ArrayList<Travel> bd2;
    private Stage stage;

    public ctrlAgent(UserManager bd, ArrayList<Travel> bd2, String nom, Stage stage){
        this.bd = bd;
        this.bd2 = bd2;
        this.nom = nom;
        ArrayList<Agent> listeAgent = bd.getAgents();
        this.courant = listeAgent.get(listeAgent.indexOf(bd.getNamesToUsers().get(nom)));
        this.stage = stage;
    }


    public void update(){
        tableTravelUser.setEditable(false);

        Collection<Travel> voyagesUsers = courant.getCalendar().get().getTravels().get();
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

    public void afficher(ActionEvent actionEvent){
        tableTravel.setEditable(false);

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



    public void ajouter(ActionEvent actionEvent){
        Voyage voyage = (Voyage)tableTravel.getSelectionModel().getSelectedItem();
        if(voyage!=null){
            Travel tmp=null;
            for (Travel t : bd2){
                for (Correspondence c : t.getSteps().get()){
                    if(voyage.equalsTravel(t,c)){
                        tmp=t;
                    }
                }
            }
            courant.getCalendar().get().addTravel(bd2.get(bd2.indexOf(tmp)));
            erreur.setVisible(false);
            erreur2.setVisible(false);
            update();

        }else{
            erreur.setVisible(true);
            erreur2.setVisible(false);
            erreur.setText("Selectionnez un voyage");
            erreur.setTextAlignment(TextAlignment.CENTER);
        }
    }



    public void supprimer(ActionEvent actionEvent){
        Voyage voyage = (Voyage)tableTravelUser.getSelectionModel().getSelectedItem();
        if(voyage!=null){
            Travel tmp=null;
            for (Travel t : bd2){
                for (Correspondence c : t.getSteps().get()){
                    if (voyage.equalsTravel(t, c)) {
                        tmp = t;
                    }
                }
            }
            courant.getCalendar().get().removeTravel(bd2.get(bd2.indexOf(tmp)));
            courant.getCalendar().get().getTravels().remove(bd2.get((bd2.indexOf(tmp))));
            erreur.setVisible(false);
            erreur2.setVisible(false);
            update();

        }else{
            erreur.setVisible(false);
            erreur2.setVisible(true);
            erreur2.setText("Selectionnez un voyage");
            erreur2.setTextAlignment(TextAlignment.CENTER);

        }
    }
    public void deconnexion(ActionEvent event) throws IOException {
        //construction du controleur du login
        Login login = new Login(bd, bd2, stage);

        // Localisation du fichier FXML.<
        final URL url = getClass().getResource("/views/Login.fxml");

        // Création du loader.
        final FXMLLoader fxmlLoader = new FXMLLoader(url);

        //Affection du controleur
        fxmlLoader.setController(login);

        // Chargement du FXML.
        final AnchorPane root = (AnchorPane) fxmlLoader.load();


        Scene scene = new Scene(root, 460, 320);
        stage.setScene(scene);
    }



}
