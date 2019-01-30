package fr.unantes.software.construction;

import fr.unantes.software.construction.common.People;

import java.util.*;

/**
 * Manage login and all security checks
 */
public class SecurityManager {
    private List<People> peoples;
    private Map<String, String> logins;

    public SecurityManager() {
        peoples = new ArrayList<>();
        logins = new HashMap<>();
    }

    /**
     * Register someone in the security manager
     * @param pp People to register
     * @param login Login associated
     */
    public void register(People pp, String login) {
        peoples.add(pp);
        Optional<String> encryptedLogin = execute(0, login, null);
        if (encryptedLogin.isPresent()) {
            logins.put(pp.getName(), encryptedLogin.get());
        } else {
            System.err.println("Cannot encrypt login due to some errors (see above)");
            // unregister the guy as we are not able to encrypt its login
            peoples.remove(pp);
        }
    }

    /**
     * Unregister someone
     * @param pp People to unregister
     */
    public void unregister(People pp) {
        peoples.remove(pp);
        logins.remove(pp.getName());
    }

    /**
     * Execute a security operation
     * @param operation Operation code (0, 1 or 2)
     * @param param1 First parameter to the security operation
     * @param param2 Second parameter to the security operation
     * @return Security operation result
     */
    private Optional<String> execute(int operation, String param1, String param2) {
        Optional<String> result = Optional.empty();
        // switch compared to operation code
        // 0 -> encrypt
        // 1 -> decrypt
        // 2 -> certify login
        // default -> do nothing
        switch (operation) {
            case 0: {
                result = Optional.of(param1.replaceAll("e", "#a#"));
                break;
            }
            case 1: {
                result = Optional.of(param1.replaceAll("#a#", "e"));
                break;
            }
            case 2: {
                String decodedLogin = execute(1, param1, null).get();
                if (decodedLogin.equals(param2)) {
                    result = Optional.of("LOGIN_SUCCESS");
                }
                break;
            }
            default: {
                break;
            }
        }
        return result;
    }
}
