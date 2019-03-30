package fr.unantes.software.construction.ui;

import fr.unantes.software.construction.calendar.Travel;
import fr.unantes.software.construction.people.Administrateur;
import fr.unantes.software.construction.people.Agent;
import fr.unantes.software.construction.people.Person;
import fr.unantes.software.construction.security.UserManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;

public class Login {

    public TextField idutilisateur;
    public TextField idmdp;
    public Label idmanqueutilisateur;
    public Label idmanquemdp;
    public Label idnoutilisateur;

    private String nom;
    private UserManager bd;
    private Stage stage;
    private ArrayList<Travel> listeVoyages;

    public Login(UserManager basededonnee, ArrayList<Travel> listeVoyages, Stage stage) {
        this.bd = basededonnee;
        this.stage = stage;
        this.listeVoyages = listeVoyages;
    }

    public void login(ActionEvent actionEvent) throws Exception {

        if (idutilisateur.getText().isEmpty()) {
            idmanqueutilisateur.setVisible(true);
        } else {
            idmanqueutilisateur.setVisible(false);
        }

        if (idmdp.getText().isEmpty()) {
            idmanquemdp.setVisible(true);
        } else {
            idmanquemdp.setVisible(false);
        }
        System.out.println(nom);


        if (!idmdp.getText().isEmpty() && !idutilisateur.getText().isEmpty()) {

            if (bd.getMapMdp().validatePassword(idutilisateur.getText(), idmdp.getText())) {
                System.out.println("Vous vous connectez avec le compte suivant : " + idutilisateur.getText());

                if ((bd.getNamesToUsers().get(idutilisateur.getText())) instanceof Agent) {

                    ctrlAgent ctrlA = new ctrlAgent(bd, listeVoyages, idutilisateur.getText(),stage);

                    final URL url3 = getClass().getResource("/views/Agent.fxml");
                    final FXMLLoader fxmlLoader3 = new FXMLLoader(url3);
                    fxmlLoader3.setController(ctrlA);
                    // Chargement du FXML.
                    final AnchorPane root3 = (AnchorPane) fxmlLoader3.load();
                    Scene scene3 = new Scene(root3, 600, 700);

                    stage.setScene(scene3);

                    System.out.println("Connexion avec un agent");


                } else if ((bd.getNamesToUsers().get(idutilisateur.getText())) instanceof Administrateur) {
                    System.out.println("Connexion avec un administrateur");

                } else  if ((bd.getNamesToUsers().get(idutilisateur.getText())) instanceof Person ) {

                    System.out.println("Connexion de Dieu");
                    //construction du controleur de la vue superUtilisateur
                    ctrlSuperUtilisateur ctrlSuperUtilisateurtest = new ctrlSuperUtilisateur(bd,listeVoyages,stage);

                    //Localisation du fichier FXML
                    final URL url2 = getClass().getResource("/views/VueSuperUtilisateur.fxml");

                    //Creation du loader
                    final FXMLLoader fxmlLoader2 = new FXMLLoader(url2);

                    //Affectation du controleur
                    fxmlLoader2.setController(ctrlSuperUtilisateurtest);

                    // Chargement du FXML.
                    final AnchorPane root2 = (AnchorPane) fxmlLoader2.load();

                    Scene scene2 = new Scene(root2, 620, 400);

                    stage.setScene(scene2);
                }
                else {
                    System.out.println("Mauvaise connexion");
                    idnoutilisateur.setVisible(true);
                }
            }

        }
    }

}
