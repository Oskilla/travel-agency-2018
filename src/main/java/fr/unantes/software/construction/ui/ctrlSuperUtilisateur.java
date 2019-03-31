package fr.unantes.software.construction.ui;

import fr.unantes.software.construction.calendar.Travel;
import fr.unantes.software.construction.people.Administrateur;
import fr.unantes.software.construction.people.Agent;
import fr.unantes.software.construction.people.Person;
import fr.unantes.software.construction.security.UserManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Label;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.*;

import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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


    //Contructeur de la classe
    public ctrlSuperUtilisateur(UserManager basededonnee, ArrayList bd2, Stage stage) throws Exception {
        this.bd = basededonnee;
        this.bd2 = bd2;
        this.stage = stage;
    }

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


    public void ajoututilisateur(ActionEvent actionEvent) throws Exception {
        if(idnouveaunom.getText().isEmpty()||idnouveaumdp.getText().isEmpty()||idnouveaurole.getText().isEmpty()){
            idmanquechamp.setVisible(true);
        }else{
            idmanquechamp.setVisible(false);
            if (!(idnouveaurole.getText().compareTo("Agent") == 0) && !(idnouveaurole.getText().compareTo("Administrateur") == 0)) {
                idmanquerole.setVisible(true);
            }else {
                idmanquerole.setVisible(false);
                if (idnouveaurole.getText().compareTo("Agent") == 0) {
                    Person nouveau = new Agent(idnouveaunom.getText());
                    System.out.println("Le nouvel agent s'appelle " + nouveau.getName());
                    bd.addUser(nouveau, idnouveaumdp.getText());
                    idmanquerole.setVisible(false);
                    this.miseajour();

                } else if (idnouveaurole.getText().compareTo("Administrateur") == 0) {
                    Person nouveau = new Administrateur(idnouveaunom.getText());
                    System.out.println("Le nouvel administrateur s'appelle " + nouveau.getName());
                    bd.addUser(nouveau, idnouveaumdp.getText());
                    idmanquerole.setVisible(false);
                    this.miseajour();
                    System.out.println("Ajout");

                }
            }
        }
    }

    public void supprimerutilisateur(ActionEvent event) throws Exception {
        idmanquerole.setVisible(false);
        idmanquechamp.setVisible(false);

        if (!idnomasupp.getText().isEmpty()) {

            System.out.println(idnomasupp.getText());

            //Nous récupérons une Collection contenant des Person
            Collection<Person> collectionPer = bd.getNamesToUsers().values();

            //Utilisation d'un itérateur générique
            Iterator<Person> it = collectionPer.iterator();

            boolean sortir = false;

            //On récupere les données
            while (it.hasNext() && !sortir) {

                //On recupere l'instance
                Person key = it.next();

                if (key.getName().contains(idnomasupp.getText())) {


                    if (key instanceof Administrateur) {

                        key.setName(key.getName().replace(" (Administrateur)", ""));
                        System.out.println(key.getName());
                        bd.removeUser(key);
                        System.out.println(bd.getNamesToUsers());
                        this.miseajour();
                        sortir = true;
                    }

                    if (key instanceof Agent) {

                        key.setName(key.getName().replace(" (Agent)", ""));
                        System.out.println(key.getName());
                        bd.removeUser(key);
                        System.out.println(bd.getNamesToUsers());
                        this.miseajour();
                        sortir = true;
                    }
                }
            }

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