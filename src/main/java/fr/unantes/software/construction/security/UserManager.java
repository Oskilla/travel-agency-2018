package fr.unantes.software.construction.security;

import fr.unantes.software.construction.people.Person;

import java.util.HashMap;
import java.util.Map;

public class UserManager {

    private Map<String, Person> namesToUsers;
    GestionMdp mapMdp = new GestionMdp();


    public UserManager() {
        namesToUsers = new HashMap<>();
    }

    /**
     * Test if an user is registered in the manager
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
    public boolean addUser(Person person, String password) throws IllegalArgumentException {
        if (namesToUsers.containsKey(person.getName())) {
            throw new IllegalArgumentException("Invalid argument: the person is already registered.");
        }
        namesToUsers.put(person.toString(), person);
        mapMdp.addMdp(person, password);
        return true;
    }

    /**
     * Remove a user from the manager
     * @param person - User to remove
     * @return True if everything went smoothly, False otherwise
     */
    public boolean removeUser(Person personne) {
        if (namesToUsers.containsKey(personne.getName())) {
            mapMdp.removeMdp(personne);
            namesToUsers.remove(personne.getName());
        }
        return true;
    }


}
