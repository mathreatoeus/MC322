package people.staff;

import people.Person;
import people.staff.StaffLevel;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Class that represents a member of the library's staff.
 *
 * @author Matheus Reato (RA: 244088), Caio Taishi (RA: 242908).
 */

public class LibraryStaff extends Person {
    // Private Attributes ---------------------------------------------------------------
    private String staffId;
    private String sector;
    private StaffLevel staffLevel;

    // Constructor ----------------------------------------------------------------------
    public LibraryStaff(String name, String surname, String socialId, String username,
                        String password, String address, String email, String phoneNumber,
                        String sector, StaffLevel staffLevel) {
        super(name, surname, socialId, username, password, address, email, phoneNumber);
        this.staffId = generateStaffId(this.getUsername());
        this.sector = sector;
        this.staffLevel = staffLevel;
    }

    // Getters --------------------------------------------------------------------------
    public String getStaffId() {              // Method made public for testing purposes.
        return staffId;
    }

    public String getSector() {
        return sector;
    }
    public StaffLevel getStaffLevel() {
        return staffLevel;
    }

    // Setters  -------------------------------------------------------------------------
    private void setSector(String newSector) {
        this.sector = newSector;
    }

    private void setStaffLevel(StaffLevel newStaffLevel) {
        this.staffLevel = newStaffLevel;
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
     * Method to try and change the current staff member's sector upon authentication.
     *
     * @param newSector The sector to which the staff member will be transferred.
     * @param username The current staff member's username.
     * @param password The current staff member's password.
     * @return true on success and false on failure.
     */
    private boolean changeSector(String newSector, String username, String password) {
        if (this.getUsername().equals(username) && this.getPassword().equals(password)) {
            setSector(newSector);
            return true;
        }
        else {
            return false;
        }
    }
}
