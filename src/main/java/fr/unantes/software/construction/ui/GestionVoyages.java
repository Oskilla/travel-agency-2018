package fr.unantes.software.construction.ui;

import fr.unantes.software.construction.calendar.City;
import fr.unantes.software.construction.calendar.Correspondence;
import fr.unantes.software.construction.calendar.Travel;
import fr.unantes.software.construction.people.Agent;
import fr.unantes.software.construction.security.UserManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.accessibility.AccessibleRelation;
import java.io.IOException;
import java.io.InvalidClassException;
import java.net.URL;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;


public class GestionVoyages {

    private UserManager bd;
    private ArrayList<Travel> bd2;
    private Stage stage;

    public TextField idVarr;
    public TextField idVdepart;
    public TextField idParr;
    public TextField idPdepart;
    public DatePicker idHarr;
    public DatePicker idHdepart;

    public Label idmanquechamps;


    public TableView tableTravel;
    public TableColumn vDep2;
    public TableColumn pDep2;
    public TableColumn hDep2;
    public TableColumn vArr2;
    public TableColumn pArr2;
    public TableColumn hArr2;

    public GestionVoyages(UserManager bd, ArrayList<Travel> bd2, Stage stage) {
        this.bd = bd;
        this.bd2 = bd2;
        this.stage = stage;
    }


    public void afficher(){
        tableTravel.setEditable(false);

        ArrayList<Voyage> listeVoyages = new ArrayList<>();

        for(Travel travel : bd2){
            City villeArr = (City)travel.getFirstStep().getStartCity().get();
            City villeDep = (City)travel.getLastStep().getDestinationCity().get();
            listeVoyages.add(new Voyage(villeDep.getName(),villeDep.getCountry(),travel.getFirstStep().getStartTime(), villeArr.getName(), villeArr.getCountry(), travel.getLastStep().getArrivalTime()));
        }

        vDep2.setCellValueFactory(new PropertyValueFactory<Voyage,String>("departV"));
        pDep2.setCellValueFactory(new PropertyValueFactory<Voyage,String>("departP"));
        hDep2.setCellValueFactory(new PropertyValueFactory<Voyage, Date>("hDep"));
        vArr2.setCellValueFactory(new PropertyValueFactory<Voyage,String>("arriveeV"));
        pArr2.setCellValueFactory(new PropertyValueFactory<Voyage,String>("arriveeP"));
        hArr2.setCellValueFactory(new PropertyValueFactory<Voyage,Date>("hArr"));
        ObservableList<Voyage> list2 = FXCollections.observableArrayList(listeVoyages);
        tableTravel.setItems(list2);

    }


    public void supprimer(ActionEvent event) {

        Voyage voyage = (Voyage) tableTravel.getSelectionModel().getSelectedItem();
        System.out.println();
        if (voyage != null) {
            Travel tmp = null;
            for (Travel t : bd2) {
                for (Correspondence c : t.getSteps().get()) {
                    if (voyage.equalsTravel(t, c)) {
                        tmp = t;
                    }
                }
            }

            bd2.remove(tmp);
            for(Agent agent : bd.getAgents()){
                Travel tmp2 = null;
                for(Travel travel : agent.getCalendar().get().getTravels().get()){
                    if(travel==tmp){
                        tmp2 = travel;
                    }
                }
                if(tmp2 != null){
                    agent.getCalendar().get().getTravels().remove(tmp2);
                }
            }
            this.afficher();

        }
    }

    public void precedent() throws Exception {
        //construction du controleur du login
        ctrlSuperUtilisateur ctrl = new ctrlSuperUtilisateur(bd, bd2, stage);

        // Localisation du fichier FXML.<
        final URL url = getClass().getResource("/views/VueSuperUtilisateur.fxml");

        // Création du loader.
        final FXMLLoader fxmlLoader = new FXMLLoader(url);

        //Affection du controleur
        fxmlLoader.setController(ctrl);

        // Chargement du FXML.
        final AnchorPane root = (AnchorPane) fxmlLoader.load();


        Scene scene = new Scene(root, 630, 400);
        stage.setScene(scene);
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


    public void ajout() throws Exception {
        if(     !(idHarr.getValue()==null) &&
                !(idHdepart.getValue()==null) &&
                !idParr.getText().isEmpty() &&
                !idPdepart.getText().isEmpty() &&
                !idVarr.getText().isEmpty() &&
                !idVdepart.getText().isEmpty()){
            City c = new City(idPdepart.getText(),idVdepart.getText());
            City c2 = new City(idParr.getText(),idVarr.getText());
            Correspondence corr  = new Correspondence(c,c2,Date.from(idHdepart.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()), Date.from(idHarr.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            Travel nouveautravel = new Travel();
            nouveautravel.getSteps().add(corr);
            bd2.add(nouveautravel);
            idmanquechamps.setVisible(false);
            }
        else{
            idmanquechamps.setVisible(true);
        }

        this.afficher();

    }

}
