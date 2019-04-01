package fr.unantes.software.construction.security;

import fr.unantes.software.construction.people.Person;

import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Class that wil manager the passwords
 */
public class GestionMdp {

    private Map<String, String> usersToPasswords;
    private Map<String,byte []> usersToSalt;

    /**
     * Constructor
     * The usersToPassword map will save encrypted passwords only
     */
    public GestionMdp() {
        usersToPasswords = new HashMap<>();
        usersToSalt = new HashMap<>();
    }

    /**
     * Add a password to the map
     * @param person - User associated to the password
     * @param password - password to validate
     * @return True if the password is added correctly, false otherwise
     */
    public void addMdp(Person person, String password) throws NoSuchAlgorithmException{
        byte [] salt = getSalt();
        usersToSalt.put(person.getName(),salt);
        usersToPasswords.put(person.getName(), encryptPassword(password,salt));
    }

    /**
     * Method that will return the map associating names to passwords
     * @return the map associating names to passwords
     */
    public Map<String, String> getUsersToPasswords() {
        return usersToPasswords;
    }

    /**
     * Remove a password from the map
     * @param person - User associated to the password
     * @return True if the password is removed correctly, false otherwise
     */
    public void removeMdp(Person person) {
        usersToPasswords.remove(person.getName());
        usersToSalt.remove(person.getName());
    }

    /**
     * Checks if the person is already in the map
     * @param person - User to look for
     * @return true if the user is in the map, false otherwise
     */
    public boolean hasUser(Person person) {
        return usersToPasswords.containsKey(person.getName())&&usersToSalt.containsKey(person.getName());
    }

    /**
     * Method that will return a user's encrypted password
     * @param personne - User associated to the password
     * @return the user's encrypted password
     */
    public String getMdp(Person personne){
        return usersToPasswords.get(personne.getName());
    }

    
    /**
     * Encrypt a password
     * @param password - Password to encrypt
     * @return Encrypted password
     * @throws IllegalArgumentException
     */
    public String encryptPassword(String password, byte[] salt) throws IllegalArgumentException
    {
        String securePassword = get_SHA_256_SecurePassword(password, salt);
        return securePassword;
    }


    /**
     * Method that generates the encrypted password using a salt
     * @param passwordToHash - the password to encrypt
     * @param salt to salt used in the encryption
     * @return the encrypted password
     */
    private static String get_SHA_256_SecurePassword(String passwordToHash, byte[] salt)
    {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    /**
     * Method that will generate a salt
     * @return a String corresponding to a salt
     * @throws NoSuchAlgorithmException
     */
    //Add salt
    private static byte[] getSalt() throws NoSuchAlgorithmException
        {
            SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
            byte[] salt = new byte[16];
            sr.nextBytes(salt);
            return salt;
        }


    /**
     * Method that will check if the given password fits the correct user's password
     * @param name - User's name associated to the password
     * @param password - the password to validate
     * @return true if the password is correct, false otherwise
     */
    public boolean validatePassword(String name, String password) {
        if (usersToPasswords.containsKey(name)) {
            return encryptPassword(password,usersToSalt.get(name)).equals(usersToPasswords.get(name));
        }
        return false;
    }

}
