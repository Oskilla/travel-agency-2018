package fr.unantes.software.construction.security;

import fr.unantes.software.construction.people.Person;

import java.util.*;

public class GestionMdp {

    private Map<String, String> usersToPasswords;


    public GestionMdp() {
        usersToPasswords = new HashMap<>();
    }

    /**
     * Ajouter un mot de passe dans la map
     * @param person - User associated to the password
     * @param password - password to validate
     * @return True si le mot de passe est ajouté faux sinon
     */
    public void addMdp(Person person, String password) {

        usersToPasswords.put(person.getName(), encryptPassword(password));
    }

    public void removeMdp(Person person) {

        usersToPasswords.remove(person.getName());
    }

    public String getMdp(Person personne){
        return usersToPasswords.get(personne.getName());
    }

    /**
     * Encrypt a password
     * @param password - Password to encrypt
     * @return Encrypted password
     * @throws IllegalArgumentException
     */
    private String encryptPassword(String password) throws IllegalArgumentException {
        if (password.contains("a")) {
            throw new IllegalArgumentException("The password contains unsecure characters, cannot perform encryption.");
        }
        return password.replaceAll("a", "e");
    }

    /**
     * Decrypt a password
     * @param encrypted - Password to decrypt
     * @return Decrypted password
     */
    private String decryptPassword(String encrypted) {
        return encrypted.replaceAll("e", "a");
    }


    /**
     * Valid a password
     * @param person - User associated to the password
     * @param password - password to validate
     * @return True if the password is valid, false otherwise
     */
/*
    public boolean validatePassword(Person personne, String password) {
        if (namesToUsers.containsKey(personne.getName())) {
            String reference = mapMdp.getMdp(personne);
            return mapMdp.decryptPassword(reference).equals(password);
        }
        return false;
    }
*/
}
