package fr.unantes.software.construction.ui;

import fr.unantes.software.construction.people.Administrateur;
import fr.unantes.software.construction.people.Agent;
import fr.unantes.software.construction.people.Person;
import fr.unantes.software.construction.security.UserManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.*;
import java.io.InvalidClassException;
import java.util.*;
import fr.unantes.software.construction.people.Administrateur;
import fr.unantes.software.construction.people.Agent;
import fr.unantes.software.construction.people.Person;
import fr.unantes.software.construction.security.UserManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.util.concurrent.TimeUnit;

public class VueSuperUtilisateur {

    public TableView<Person> idlistutilisateur;
    public TableColumn<Person, String> idnom;
    public TableColumn<Person, String> idrole;
    public TextField idnouveaunom;
    public TextField idnouveaumdp;

    private UserManager bd;

    //Contructeur de la classe
    public VueSuperUtilisateur(UserManager basededonnee) throws Exception {
        this.bd = basededonnee;
    }


    public void miseajour(ActionEvent actionEvent) throws Exception {


        idnom.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));

        //Nous récupérons une Collection contenant des Person
        Collection<Person> collectionPer = bd.getNamesToUsers().values();

        //Utilisation d'un itérateur générique
        Iterator<Person> it = collectionPer.iterator();

        //Creation de la liste
        ObservableList<Person> listtest = FXCollections.observableArrayList();

        //On récupere les données
        while(it.hasNext()){

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

    public void miseajourclean(ActionEvent actionEvent) {

        ObservableList<Person> listevide = FXCollections.observableArrayList();
        idlistutilisateur.setItems(listevide);
    }

    public void ajoututilisateur(ActionEvent actionEvent) throws Exception{

        if (!idnouveaunom.getText().isEmpty() && !idnouveaumdp.getText().isEmpty()){
            System.out.println("Ajout");

        }

    }


}