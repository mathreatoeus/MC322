package people;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Class that represents a general User.
 *
 * @author Matheus Reato (RA: 244088), Caio Taishi (RA: 242908).
 */

public class User extends Person {      // Can't be abstract (must be imported by Library
    private String memberId;

    // Constructor ----------------------------------------------------------------------
    public User(String name, String surname, String socialId, String username,
                String password) {
        super(name, surname, socialId, username, password);
        this.memberId = generateId(username);
    }

    // Getters --------------------------------------------------------------------------
    private String getMemberId() {
        return memberId;
    }

    // Methods --------------------------------------------------------------------------

    /**
     * Takes a username and hashes it using SHA-256 to generate a secure ID.
     *
     * @param username User's personal username.
     * @return hash Member's ID.
     */
    private String generateId(String username) {
        try {
            MessageDigest msgDigest = MessageDigest.getInstance(("SHA-256"));
            byte[] hashBytes = msgDigest.digest(username.getBytes());

            StringBuilder hexString = new StringBuilder();

            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);

                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            return "none";
        }
    }

}
