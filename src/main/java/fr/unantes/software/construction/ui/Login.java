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

/**
 * Login view controller
 */
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

    /**
     * Controller
     * @param bd the usermanager
     * @param listeVoyages the travel list
     * @param stage
     */
    public Login(UserManager bd, ArrayList<Travel> listeVoyages, Stage stage) {
        this.bd = bd;
        this.stage = stage;
        this.listeVoyages = listeVoyages;
    }

    /**
     * Method used to check if the user exists.
     * If so, checks whether it is an Agent or an Administrator, and opens a new view depending on the result
     * @throws Exception
     */
    public void login() throws Exception {

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
                    ctrlAdministrateur ctrlAdmin = new ctrlAdministrateur(bd, listeVoyages, idutilisateur.getText(),stage);

                    final URL url4 = getClass().getResource("/views/Admin.fxml");
                    final FXMLLoader fxmlLoader4 = new FXMLLoader(url4);
                    fxmlLoader4.setController(ctrlAdmin);
                    // Chargement du FXML.
                    final AnchorPane root4 = (AnchorPane) fxmlLoader4.load();
                    Scene scene4 = new Scene(root4, 830, 425);

                    stage.setScene(scene4);

                    System.out.println("Connexion avec un admin");


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

                    Scene scene2 = new Scene(root2, 660, 400);

                    stage.setScene(scene2);
                }
            }else{
                idnoutilisateur.setVisible(true);
            }

        }
    }

}
