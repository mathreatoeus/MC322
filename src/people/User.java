package people;

import java.time.LocalDate;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Class that represents a registered library user.
 *
 * @author Matheus Reato (RA: 244088).
 */

public class User extends Person {
    // Private Attributes ---------------------------------------------------------------
    private String username;
    private String password;
    private String memberId;
    private LocalDate registrationDate;
    private boolean isSuspended;

    // Constructor ----------------------------------------------------------------------
    public User(String name, String surname, String socialId, String username,
                String password) {
        this.name = name;
        this.surname = surname;
        this.socialId = socialId;
        this.username = username;
        this.password = password;
        this.memberId = generateId(this.username);
        this.registrationDate = LocalDate.now();
        this.isSuspended = false;
    }

    // Getters --------------------------------------------------------------------------
    public String getUsername() {
        return username;
    }

    public String getPassword() {             // Method made public for testing purposes.
        return password;
    }

    public String getMemberId() {             // Method made public for testing purposes.
        return memberId;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public boolean getIsSuspended() {
        return isSuspended;
    }

    // Setters --------------------------------------------------------------------------
    private void setUsername(String newUsername) {
        this.username = newUsername;
    }

    private void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public void setIsSuspended() {
        this.isSuspended = !this.isSuspended;
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

    /**
     * Method to try and change the current user's username upon authentication.
     *
     * @param newUsername The new desired username.
     * @param password This user's current password.
     * @return true on success and false on failure.
     */
    public boolean changeUsername(String newUsername, String password) {
        if (password.equals(this.password)) {
            this.username = newUsername;
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Method to try and change the current user's password upon authentication.
     *
     * @param currentPassword This user's current password.
     * @param newPassword This user's desired new password.
     * @return true on success and false on failure.
     */
    public boolean changePassword(String currentPassword, String newPassword) {
        if (currentPassword.equals(this.password)) {
            this.password = newPassword;
            return true;
        }
        else {
            return false;
        }
    }
}
