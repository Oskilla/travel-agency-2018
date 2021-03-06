package fr.unantes.software.construction.ui;

import fr.unantes.software.construction.calendar.Calendar;
import fr.unantes.software.construction.calendar.City;
import fr.unantes.software.construction.calendar.Correspondence;
import fr.unantes.software.construction.calendar.Travel;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * class launching the app
 */
public class GUI extends Application  {

    private final Person dieu;
    private final Person solineLecomte;
    private final Person gaelLode;
    private final Person yvesmarieCarette;
    private final UserManager bd;
    private final ArrayList<Travel> bd2;


    public GUI() throws Exception {
        /* Creation de la "base de donnees", soit un user manager et une liste de travels*/
        bd =new UserManager();
        bd2 = new ArrayList<Travel>();

        /* Creation du super utilisateur*/
        dieu = new Person("Dieu");
        bd.addUser(dieu,"mdpdieu");


        /* Creation de variables test */

        solineLecomte = new Agent("Soline");
        gaelLode = new Administrateur("Gael");
        yvesmarieCarette = new Administrateur("Yves-Marie");

        bd.addUser(solineLecomte, "mdpsoline");
        bd.addUser(gaelLode, "mdpgael");
        bd.addUser(yvesmarieCarette, "mdpyvesmarie");


        Calendar cal1 = new Calendar((Agent)solineLecomte);
        City cit1 = new City ("Maroc","Rabat");
        City cit2 = new City ("Allemagne", "Berlin");
        City cit3 = new City ("Chili","Santiago");
        City cit4 = new City ("Ireland", "Shannon");
        Date date1 = new Date(2019,1,12);
        Date date2 = new Date(2019,2,12);
        Date date3 = new Date(2019,3,1);
        Date date4 = new Date(2019,4,1);
        Date date5 = new Date(2019,5,1);
        Date date6 = new Date(2019,6,1);


        Travel trav1 = new Travel(cal1);
        Correspondence cor1 = new Correspondence(cit1,cit2,date1,date2);
        Correspondence cor2 = new Correspondence(cit2,cit3, date2,date3);
        Correspondence[] listcorr = {cor1, cor2};
        for (Correspondence each : listcorr){
            trav1.getSteps().add(each);
        }

        Travel trav2 = new Travel();
        Correspondence cor3 = new Correspondence(cit2, cit4, date3,date4);
        Correspondence cor4 = new Correspondence(cit4, cit2, date4,date5);
        Correspondence[] listcorr2 = {cor3, cor4};
        for (Correspondence each : listcorr2){
            trav2.getSteps().add(each);
        }

        Travel trav3 = new Travel();
        Correspondence cor5 = new Correspondence(cit3, cit1, date1,date3);
        Correspondence cor6 = new Correspondence(cit1, cit3, date5,date6);
        Correspondence[] listcorr3 = {cor5, cor6};
        for (Correspondence each : listcorr3){
            trav3.getSteps().add(each);
        }
        bd2.add(trav1);
        bd2.add(trav2);
        bd2.add(trav3);

        ArrayList<Agent> listeAgent = bd.getAgents();
        Agent courant = listeAgent.get(listeAgent.indexOf(bd.getNamesToUsers().get("Soline")));
        courant.getCalendar().get().getTravels().add(trav1);
    }


    /**
     *Method launching the app on the first view
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {

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
        stage.show();


    }
}
