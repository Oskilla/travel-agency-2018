package fr.unantes.software.construction.ui;

import fr.unantes.software.construction.security.UserManager;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Login {

    public TextField idutilisateur;
    public TextField idmdp;
    public Label idmanqueutilisateur;
    public Label idmanquemdp;
    public Label idnoutilisateur;
    private String nom;
    private UserManager bd;


    public Login(String s){
        this.nom = s;
    }


/*
    public Login(String s, UserManager basededonnee){
        this.bd = basededonnee;
        this.nom =s;
    }*/

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
/*
        if (basededonne.validatePassword(idutilisateur.getText(), idmdp.getText())) {
            System.out.println("Vous vous connectez avec le compte suivant : " + idutilisateur.getText());
            fenetre
        } else {
            idnoutilisateur.isVisible();
        }*/
    }
}
