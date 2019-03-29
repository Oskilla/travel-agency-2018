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

    public GUI() throws Exception {
        bd =new UserManager();

        solineLecomte = new Agent("Soline");
        gaelLode = new Administrateur("Gael");
        yvesmarieCarette = new Administrateur("YvesMarie");

        bd.addUser(solineLecomte, "mdpsoline");
        bd.addUser(gaelLode, "mdpgael");
        bd.addUser(yvesmarieCarette, "mdpyvesmarie");
    }




    @Override
    public void start(Stage stage) throws Exception {

        final URL url2 = getClass().getResource("/views/VueSuperUtilisateur.fxml");
        final FXMLLoader fxmlLoader2 = new FXMLLoader(url2);
        //fxmlLoader2.setController(login);
        // Chargement du FXML.
        final AnchorPane root2 = (AnchorPane) fxmlLoader2.load();
        Scene scene2 = new Scene(root2, 800, 800);



        Login login = new Login("L'interface trop bg de YM", bd ,stage, scene2);


        // Localisation du fichier FXML.<
        final URL url = getClass().getResource("/views/Login.fxml");

        // Création du loader.
        final FXMLLoader fxmlLoader = new FXMLLoader(url);
        fxmlLoader.setController(login);

        // Chargement du FXML.
        final AnchorPane root = (AnchorPane) fxmlLoader.load();





        Scene scene = new Scene(root, 800, 800);
        stage.setScene(scene);
        stage.show();


    }
}
