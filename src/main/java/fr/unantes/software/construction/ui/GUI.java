package fr.unantes.software.construction.ui;

import fr.unantes.software.construction.people.Administrateur;
import fr.unantes.software.construction.people.Agent;
import fr.unantes.software.construction.people.Person;
import fr.unantes.software.construction.security.UserManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;

public class GUI extends Application  {


    private final Person solineLecomte;
    private final Person gaelLode;
    private final Person yvesmarieCarette;
    private final UserManager bd;
    private final Person dieu;

    public GUI() throws Exception {
        bd =new UserManager();

        dieu = new Person("dieu");
        solineLecomte = new Agent("Soline");
        gaelLode = new Administrateur("Gael");
        yvesmarieCarette = new Administrateur("Yves-Marie");

        bd.addUser(dieu,"mdpdieu");
        bd.addUser(solineLecomte, "mdpsoline");
        bd.addUser(gaelLode, "mdpgael");
        bd.addUser(yvesmarieCarette, "mdpyvesmarie");
    }




    @Override
    public void start(Stage stage) throws Exception {

        //construction du controleur du login
        Login login = new Login("L'interface trop bg de YM", bd, stage);

        // Localisation du fichier FXML.<
        final URL url = getClass().getResource("/views/Login.fxml");

        // Création du loader.
        final FXMLLoader fxmlLoader = new FXMLLoader(url);

        //Affection du controleur
        fxmlLoader.setController(login);

        // Chargement du FXML.
        final AnchorPane root = (AnchorPane) fxmlLoader.load();


        Scene scene = new Scene(root, 800, 800);
        stage.setScene(scene);
        stage.show();


    }
}
