
package fr.unantes.software.construction.security;

import fr.unantes.software.construction.calendar.Calendar;
import fr.unantes.software.construction.people.Administrateur;
import fr.unantes.software.construction.people.Agent;
import fr.unantes.software.construction.people.Person;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that will manage the users, and contains the passwords manager
 */
public class UserManager {

    private Map<String, Person> namesToUsers;
    private GestionMdp mapMdp;


    /**
     * Constructor
     * Create the passwords manager
     */
    public UserManager() {

        namesToUsers = new HashMap<>();
        mapMdp = new GestionMdp();
    }

    /**
     * Method that will return the passwords manager
     * @return the passwords manager
     */
    public GestionMdp getMapMdp() {
        return mapMdp;
    }

    /**
     * Method that will return the map containing the users and their names
     * @return the map containing the users and their names
     */
    public Map<String, Person> getNamesToUsers() {
        return namesToUsers;
    }

    /**
     * Method that will create a list containing all the Agents created
     * @return a list containing all the Agents created
     */
    public ArrayList<Agent> getAgents(){
        ArrayList<Agent> listeAgent = new ArrayList<>();
        for(Map.Entry<String, Person> entry : namesToUsers.entrySet()) {
            Person valeur = entry.getValue();
            if(valeur instanceof Agent){
                listeAgent.add((Agent) valeur);
            }
        }
        return listeAgent;
    }

    /**
     * Method that will create a list containing all the Admin created
     * @return a list containing all the Admin created
     */
    public ArrayList<Administrateur> getAdmin(){
        ArrayList<Administrateur> listeAdmin = new ArrayList<>();
        for(Map.Entry<String, Person> entry : namesToUsers.entrySet()) {
            Person valeur = entry.getValue();
            if(valeur instanceof Administrateur){
                listeAdmin.add((Administrateur) valeur);
            }
        }
        return listeAdmin;
    }



    /**
     * Test if a user is registered in the manager
     * @param person - User to search for
     * @return True if the user is registered, False otherwise
     */
    public boolean hasUser(Person person) {
        return namesToUsers.containsKey(person.getName());
    }


    /**
     * Add a new user to the manager
     * @param person - User to add
     * @param password - User's password
     * @return True if everything went smoothly, False otherwise
     * @throws IllegalArgumentException
     */
    public boolean addUser(Person person, String password) throws
            NoSuchAlgorithmException, IllegalArgumentException {
        if (namesToUsers.containsKey(person.getName())) {
            throw new IllegalArgumentException("Invalid argument: the person is already registered.");
        }
        else {
            namesToUsers.put(person.getName(), person);
            mapMdp.addMdp(person, password);
            if(person instanceof Agent){
                new Calendar((Agent)person);
            }
            return true;
        }
    }

    /**
     * Remove a user from the manager
     * @param personne - User to remove
     * @return True if everything went smoothly, False otherwise
     */
    public boolean removeUser(Person personne) {
        if (namesToUsers.containsKey(personne.getName())) {
            mapMdp.removeMdp(personne);
            namesToUsers.remove(personne.getName());
            return true;
        } else return false;

    }
}


