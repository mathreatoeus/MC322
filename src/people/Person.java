package people;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;

/**
 * Class that represents a general person. Superclass of InternalUser, FacultyUser,
 * ExternalUser and Staff.
 *
 * @author Matheus Reato (RA: 244088), Caio Taishi (RA: 242908).
 */

public class Person {
    // Protected Attributes -------------------------------------------------------------
    protected String name;
    protected String surname;
    protected String socialId;
    protected String username;
    protected String password;
    protected boolean isSuspended;
    protected LocalDate registrationDate;
    protected String memberId;

    // Getters --------------------------------------------------------------------------
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    protected String getSocialId() {
        return socialId;
    }

    protected String getUsername() {
        return username;
    }

    protected String getPassword() {
        return password;
    }

    protected boolean getIsSuspended() {
        return isSuspended;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    // Setters --------------------------------------------------------------------------
    protected void setUsername(String newUsername) {
        this.username = newUsername;
    }

    protected void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public void setIsSuspended(boolean new_status) {
        this.isSuspended = new_status;
    }

    // Methods --------------------------------------------------------------------------

    /**
     * Takes a username and hashes it using SHA-256 to generate a secure ID.
     *
     * @param username User's personal username.
     * @return hash Member's ID.
     */
    protected String generateId(String username) {
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
     * Method to try and change the current staff member's username upon authentication.
     *
     * @param newUsername New desired username.
     * @param currentPassword This staff member's current password.
     * @return true on success and false on failure.
     */
    public boolean changeUsername(String newUsername, String currentPassword) {
        if (currentPassword.equals(this.password)) {
            setUsername(newUsername);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Method to try and change the current staff member's password upon authentication.
     *
     * @param newPassword New desired password.
     * @param currentPassword This staff member's current password.
     * @return true on success and false on failure.
     */
    public boolean changePassword(String newPassword, String currentPassword) {
        if (currentPassword.equals(this.password)) {
            setPassword(newPassword);
            return true;
        }
        else {
            return false;
        }
    }
}
