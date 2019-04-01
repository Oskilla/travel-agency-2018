package fr.unantes.software.construction.ui;

import fr.unantes.software.construction.calendar.Travel;
import fr.unantes.software.construction.security.UserManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.accessibility.AccessibleRelation;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;


public class GestionVoyages {

    private UserManager bd;
    private ArrayList<Travel> bd2;
    private Stage stage;

    public GestionVoyages(UserManager bd, ArrayList<Travel> bd2, Stage stage) {
        this.bd = bd;
        this.bd2 = bd2;
        this.stage = stage;
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
