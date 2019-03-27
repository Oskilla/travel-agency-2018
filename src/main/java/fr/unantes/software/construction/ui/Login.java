package fr.unantes.software.construction.ui;

import fr.unantes.software.construction.security.UserManager;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Login {

    public TextField idutilisateur;
    public TextField idmdp;
    public Label idmanqueutilisateur;
    public Label idmanquemdp;
    public Label idnoutilisateur;

    private String nom;
    private UserManager bd;
    private Stage stage;
    private Scene scene;

    public Login(String s, UserManager basededonnee, Stage stage, Scene scene){
        this.bd = basededonnee;
        this.nom =s;
        this.stage = stage;
        this.scene = scene;
    }

    public void login(ActionEvent actionEvent) {

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
                System.out.println("Vous vous connectez avec le compte suivant : " + idutilisateur.getText());
                stage.setScene(scene);
            /*
            if (idmdp.getText() == "mdpsoline"){

            }
            else if(typeutilisateur == agent) {
                nouvellevueagent
            }
            else (typeutilisateur == administrateur){
                nouvellevueadministrateur
            }*/

            } else {
                System.out.println("ici");
                idnoutilisateur.setVisible(true);
            }
        }

    }
}
