package fr.unantes.software.construction.ui;

import fr.unantes.software.construction.calendar.Correspondence;
import fr.unantes.software.construction.calendar.Travel;
import fr.unantes.software.construction.calendar.City;

import fr.unantes.software.construction.people.Administrateur;
import fr.unantes.software.construction.people.Agent;
import fr.unantes.software.construction.people.Person;
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

/**
 * Administrator's view's controller
 */
public class ctrlAdministrateur {
    public TableView tableTravel;
    public TableColumn vDep;
    public TableColumn pDep;
    public TableColumn hDep;
    public TableColumn vArr;
    public TableColumn pArr;
    public TableColumn hArr;

    public TableView agents;
    public TableColumn colAgents;

    public Label erreur;
    public Label erreur2;
    public Label valide;

    private UserManager bd;
    private String nom;
    private Administrateur courant;
    private ArrayList<Travel> bd2;
    private Stage stage;

    /**
     * Controller
     * @param bd the usermanager
     * @param bd2 the travel list
     * @param nom the name of the current user
     * @param stage
     */
    public ctrlAdministrateur(UserManager bd, ArrayList<Travel> bd2, String nom, Stage stage){
        this.bd = bd;
        this.bd2 = bd2;
        this.nom = nom;
        ArrayList<Administrateur> listeAdmin = bd.getAdmin();
        this.courant = listeAdmin.get(listeAdmin.indexOf(bd.getNamesToUsers().get(nom)));
        this.stage = stage;
    }

    /**
     * Method used to display the travel table's content
     * */
    public void afficher(){
        tableTravel.setEditable(false);

        ArrayList<Voyage> listeVoyages = new ArrayList<>();
        // For each travel, a new Voyage is created to be displayed in the table
        for(Travel travel : bd2){
            City villeArr = (City)travel.getFirstStep().getStartCity().get();
            City villeDep = (City)travel.getLastStep().getDestinationCity().get();
            listeVoyages.add(new Voyage(villeDep.getName(),villeDep.getCountry(),travel.getFirstStep().getStartTime(), villeArr.getName(), villeArr.getCountry(), travel.getLastStep().getArrivalTime()));
        }

        vDep.setCellValueFactory(new PropertyValueFactory<Voyage,String>("departV"));
        pDep.setCellValueFactory(new PropertyValueFactory<Voyage,String>("departP"));
        hDep.setCellValueFactory(new PropertyValueFactory<Voyage,Date>("hDep"));
        vArr.setCellValueFactory(new PropertyValueFactory<Voyage,String>("arriveeV"));
        pArr.setCellValueFactory(new PropertyValueFactory<Voyage,String>("arriveeP"));
        hArr.setCellValueFactory(new PropertyValueFactory<Voyage,Date>("hArr"));
        ObservableList<Voyage> list2 = FXCollections.observableArrayList(listeVoyages);
        tableTravel.setItems(list2);
    }

    /**
     * Method used to display the users table's content
     */
    public void afficher2(){
        agents.setEditable(false);
        ObservableList<Agent> listeAgents = FXCollections.observableArrayList();
        for (Agent a : bd.getAgents()){
            listeAgents.add(a);
        }

        colAgents.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
        agents.setItems(listeAgents);
    }


    /**
     * Method used to add a selected travel to the selected Agent's calendar
     */
    public void ajouter(){
        erreur.setVisible(false);
        erreur2.setVisible(false);
        Voyage voyage = (Voyage)tableTravel.getSelectionModel().getSelectedItem();
        Agent agent = (Agent)agents.getSelectionModel().getSelectedItem();
        if(voyage!=null){
            if(agent!=null){
                //Looking for the travel corresponding to the voyage
                Travel tmp=null;
                for (Travel t : bd2){
                    for (Correspondence c : t.getSteps().get()){
                        if(voyage.equalsTravel(t,c)){
                            tmp=t;
                        }
                    }
                }
                agent.getCalendar().get().addTravel(bd2.get(bd2.indexOf(tmp)));
                valide.setVisible(true);
            }else{
                erreur2.setVisible(true);
            }
        }else{
            erreur.setVisible(true);
        }
    }

    /**
     * Method called to go back to the authentication screen
     * @throws IOException
     */
    public void deconnexion() throws IOException {
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
