package fr.unantes.software.construction.security;

import fr.unantes.software.construction.people.Person;

import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class GestionMdp {

    private Map<String, String> usersToPasswords;
    private Map<String,byte []> usersToSalt;


    public GestionMdp() {
        usersToPasswords = new HashMap<>();
        usersToSalt = new HashMap<>();
    }

    /**
     * Ajouter un mot de passe dans la map
     * @param person - User associated to the password
     * @param password - password to validate
     * @return True si le mot de passe est ajouté faux sinon
     */
    public void addMdp(Person person, String password) throws NoSuchAlgorithmException{
        byte [] salt = getSalt();
        usersToSalt.put(person.getName(),salt);
        usersToPasswords.put(person.getName(), encryptPassword(password,salt));
    }

    public void removeMdp(Person person) {
        usersToPasswords.remove(person.getName());
        usersToSalt.remove(person.getName());
    }

    public boolean hasUser(Person person) {
        return usersToPasswords.containsKey(person.getName())&&usersToSalt.containsKey(person.getName());
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
    public String encryptPassword(String password, byte[] salt) throws IllegalArgumentException
    {
        String securePassword = get_SHA_256_SecurePassword(password, salt);
        return securePassword;
    }



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


    //Add salt
    private static byte[] getSalt() throws NoSuchAlgorithmException
        {
            SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
            byte[] salt = new byte[16];
            sr.nextBytes(salt);
            return salt;
        }

        

    public boolean validatePassword(String name, String password) {
        if (usersToPasswords.containsKey(name)) {
            return encryptPassword(password,usersToSalt.get(name)).equals(usersToPasswords.get(name));
        }
        return false;
    }

}
