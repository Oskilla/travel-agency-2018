package fr.unantes.software.construction.ui;

import fr.unantes.software.construction.calendar.Travel;
import fr.unantes.software.construction.people.Administrateur;
import fr.unantes.software.construction.people.Agent;
import fr.unantes.software.construction.people.Person;
import fr.unantes.software.construction.security.UserManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * SuperUser's view controller
 */
public class ctrlSuperUtilisateur {

    public TableView<Person> idlistutilisateur;
    public TableColumn<Person, String> idnom;
    public TableColumn<Person, String> idrole;
    public TextField idnouveaunom;
    public TextField idnouveaumdp;
    public TextField idnouveaurole;
    public Label idmanquerole;
    public Label idmanquechamp;
    public TextField idnomasupp;

    private UserManager bd;
    private ArrayList<Travel> bd2;
    private Stage stage;


    /**
     * Controller
     * @param bd the usermanager
     * @param bd2 the travel list
     * @param stage
     * @throws Exception
     */
    public ctrlSuperUtilisateur(UserManager bd, ArrayList bd2, Stage stage) throws Exception {
        this.bd = bd;
        this.bd2 = bd2;
        this.stage = stage;
    }

    /**
     * Method used to display the users table's content
     * @throws Exception
     */
    public void miseajour() throws Exception {

        //Clean de la table
        ObservableList<Person> listevide = FXCollections.observableArrayList();
        idlistutilisateur.setItems(listevide);

        idnom.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));

        //Nous récupérons une Collection contenant des Person
        Collection<Person> collectionPer = bd.getNamesToUsers().values();

        //Utilisation d'un itérateur générique
        Iterator<Person> it = collectionPer.iterator();

        //Creation de la liste
        ObservableList<Person> listtest = FXCollections.observableArrayList();

        //On récupere les données
        while (it.hasNext()) {

            //On recupere l'instance
            Person key = it.next();
            if (key.getName() != "dieu") {
                if (key instanceof Administrateur && !key.getName().contains("(Administrateur)")) {
                    String tmp = key.getName();
                    key.setName(tmp + " (Administrateur)");
                } else if (key instanceof Agent && !key.getName().contains("(Agent)")) {
                    String tmp = key.getName();
                    key.setName(tmp + " (Agent)");
                }

                //Ajout dans la liste
                listtest.add(key);
            }
        }
        //Ajout dans la table
        idlistutilisateur.setItems(listtest);

    }

    /**
     * Method used to add a new User to bd
     * @throws Exception
     */
    public void ajoututilisateur() throws Exception {
        if (idnouveaunom.getText().isEmpty() || idnouveaumdp.getText().isEmpty() || idnouveaurole.getText().isEmpty()) {
            idmanquechamp.setVisible(true);
        } else {
            idmanquechamp.setVisible(false);
            if (!(idnouveaurole.getText().compareTo("Agent") == 0) && !(idnouveaurole.getText().compareTo("Administrateur") == 0)) {
                idmanquerole.setVisible(true);
            } else {
                idmanquerole.setVisible(false);
                if (idnouveaurole.getText().compareTo("Agent") == 0) {
                    Person nouveau = new Agent(idnouveaunom.getText());
                    bd.addUser(nouveau, idnouveaumdp.getText());
                    idmanquerole.setVisible(false);
                    this.miseajour();

                } else if (idnouveaurole.getText().compareTo("Administrateur") == 0) {
                    Person nouveau = new Administrateur(idnouveaunom.getText());
                    bd.addUser(nouveau, idnouveaumdp.getText());
                    idmanquerole.setVisible(false);
                    this.miseajour();

                }
            }
        }
    }

    /**
     * Method used to delete the selected user's existence
     * @throws Exception
     */
    public void supprimerutilisateur() throws Exception {

        idmanquerole.setVisible(false);
        idmanquechamp.setVisible(false);

        Person perso = (Person) idlistutilisateur.getSelectionModel().getSelectedItem();


        if (perso instanceof Administrateur) {

            perso.setName(perso.getName().replace(" (Administrateur)", ""));
            bd.removeUser(perso);
            this.miseajour();
        }

        if (perso instanceof Agent) {

            perso.setName(perso.getName().replace(" (Agent)", ""));
            bd.removeUser(perso);
            this.miseajour();
        }
    }

    /**
     * Method used to modify the selected user, and affect him the new values filled
     * To modify a user, select it in the table, fill the fields where you want the values to change, and click "Modify"
     * @throws Exception
     */
    public void modifier() throws Exception {

        Person perso = idlistutilisateur.getSelectionModel().getSelectedItem();
        perso.setName(perso.getName().replace(" (Administrateur)", ""));
        perso.setName(perso.getName().replace(" (Agent)", ""));
        String nom = perso.getName();
        String mdp = bd.getMapMdp().getMdp(perso);
        String role = null;

        if (perso instanceof Agent) {
            role = "Agent";
        } else {
            role = "Administrateur";
        }

        if (!idnouveaunom.getText().isEmpty()) {
            nom = idnouveaunom.getText();
        }
        if (!idnouveaumdp.getText().isEmpty()) {
            mdp = idnouveaumdp.getText();
        }
        if (idnouveaurole.getText().compareTo("Agent") == 0 || idnouveaurole.getText().compareTo("Administrateur") == 0) {
            role = idnouveaurole.getText();
        }
        this.supprimerutilisateur();
        if (role.compareTo("Agent") ==0){
            Person nouveau = new Agent(nom);
            bd.addUser(nouveau, mdp);
            this.miseajour();
        } else if (role.compareTo("Administrateur")==0) {
            Person nouveau = new Administrateur(nom);
            bd.addUser(nouveau, mdp);
            this.miseajour();
        }

    }

    /**
     * Method used to call the travel manager interface
     * @throws Exception
     */
    public void gestionvoyage() throws Exception {

        //construction du controleur du login
        ctrlGestionVoyages ctrlCtrlGestionVoyages = new ctrlGestionVoyages(bd, bd2, stage);

        // Localisation du fichier FXML.<
        final URL url = getClass().getResource("/views/GestionVoyages.fxml");

        // Création du loader.
        final FXMLLoader fxmlLoader = new FXMLLoader(url);

        //Affection du controleur
        fxmlLoader.setController(ctrlCtrlGestionVoyages);

        // Chargement du FXML.
        final AnchorPane root = (AnchorPane) fxmlLoader.load();


        Scene scene = new Scene(root, 600, 345);
        stage.setScene(scene);
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
