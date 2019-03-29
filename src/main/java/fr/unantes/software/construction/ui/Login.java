package fr.unantes.software.construction.ui;

import fr.unantes.software.construction.people.Administrateur;
import fr.unantes.software.construction.people.Agent;
import fr.unantes.software.construction.security.UserManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InvalidClassException;
import java.net.URL;
import java.util.ArrayList;

public class Login {

    public TextField idutilisateur;
    public PasswordField idmdp;
    public Label idmanqueutilisateur;
    public Label idmanquemdp;
    public Label idnoutilisateur;

    private String nom;
    private UserManager bd;
    private Stage stage;
    private ArrayList<Scene> scenes;

    public Login(String s, UserManager basededonnee, Stage stage, ArrayList<Scene> scenes){
        this.bd = basededonnee;
        this.nom =s;
        this.stage = stage;
        this.scenes = scenes;

    }


    public void login(ActionEvent actionEvent) throws IOException {
        if (idutilisateur.getText().isEmpty()){
            idmanqueutilisateur.setVisible(true);
        }
        else {
            idmanqueutilisateur.setVisible(false);
        }

        if (idmdp.getText().isEmpty()){
            idmanquemdp.setVisible(true);
        }
        else{
            idmanquemdp.setVisible(false);
        }
        System.out.println(nom);


        if(!idmdp.getText().isEmpty()&&!idutilisateur.getText().isEmpty()) {
            if (bd.getMapMdp().validatePassword(idutilisateur.getText(), idmdp.getText())) {
                if((bd.getNamesToUsers().get(idutilisateur.getText())) instanceof Agent){

                    ctrlAgent ctrlA = new ctrlAgent(bd,idutilisateur.getText());

                    final URL url3 = getClass().getResource("/views/Agent.fxml");
                    final FXMLLoader fxmlLoader3 = new FXMLLoader(url3);
                    fxmlLoader3.setController(ctrlA);
                    // Chargement du FXML.
                    final AnchorPane root3 = (AnchorPane) fxmlLoader3.load();
                    Scene scene3 = new Scene(root3, 800, 800);

                    stage.setScene(scene3);


                }else if ((bd.getNamesToUsers().get(idutilisateur.getText())) instanceof Administrateur) {

                }else{

                    System.out.println("Vous vous connectez avec le compte suivant : " + idutilisateur.getText());
                    stage.setScene(scenes.get(0));
                }

            } else {
                System.out.println("ici");
                idnoutilisateur.setVisible(true);
            }
        }

    }
}
