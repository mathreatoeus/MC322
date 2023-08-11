package people;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;

/**
 * Class that represents a member of the library's staff
 *
 * @author Matheus Reato (RA: 244088)
 */

public class Staff extends Person {
    // Private Attributes ---------------------------------------------------------------
    private String staffId;
    private String sector;
    private String username;
    private String password;
    private LocalDate registrationDate;

    // Constructor ----------------------------------------------------------------------
    public Staff(String name, String surname, String socialId, String sector,
                 String username, String password) {
        this.name = name;
        this.surname = surname;
        this.socialId = socialId;
        this.sector = sector;
        this.username = username;
        this.password = password;
        this.registrationDate = LocalDate.now();
        this.staffId = generateStaffId(this.username);
    }

    // Getters --------------------------------------------------------------------------
    public String getStaffId() {     // Method made public for testing purposes.
        return staffId;
    }

    public String getSector() {
        return sector;
    }

    public String getUsername() {    // Method made public for testing purposes.
        return username;
    }

    public String getPassword() {    // Method made public for testing purposes.
        return password;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    // Setters  -------------------------------------------------------------------------
    public void setSector(String newSector) {
        this.sector = newSector;
    }

    private void setUsername(String newUsername) {
        this.username = newUsername;
    }

    private void setPassword(String newPassword) {
        this.password = newPassword;
    }

    // Methods --------------------------------------------------------------------------

    /**
     * Takes a username and hashes it using SHA-256 to generate a secure ID.
     *
     * @param username Staff member's username (used for the hash function).
     * @return hash New Staff member's Staff ID.
     */
    private String generateStaffId(String username) {
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
            this.username = newUsername;
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
            this.password = newPassword;
            return true;
        }
        else {
            return false;
        }
    }
}
