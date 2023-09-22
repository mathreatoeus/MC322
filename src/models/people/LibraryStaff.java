package models.people;

import models.library.management.Loan;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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
     * Method that checks if a loan made by a user or staff member is expired and the item
     * hasn't been returned yet, in which case the user or staff member will be suspended
     * and fined accordingly. The staff member performing this operation must be an ADMINISTRATOR.
     *
     * @param loan the loan to be examined.
     */
    public void fineUser(Loan loan) {
        // Checking the staff member's level.
        if (this.getStaffLevel() == StaffLevel.ADMINISTRATOR) {
            if (loan.isExpired() && !loan.getRetrieved()) {
                // Determining the amount of days by which the retrieval is late.
                long amountOfDays = ChronoUnit.DAYS.between(loan.getRetrievalDate(),
                        LocalDate.now());

                // If the loan was made by a user.
                if (loan.getUser() != null) {
                    (loan.getUser()).setIsSuspended(true);

                    if (loan.getUser() instanceof Student || loan.getUser() instanceof ExternalUser) {
                        (loan.getUser()).setTotalFines(amountOfDays * 1.0);
                    }
                    else if (loan.getUser() instanceof FacultyUser) {
                        (loan.getUser()).setTotalFines(amountOfDays * 0.5);
                    }
                    else if (loan.getUser() instanceof UniversityStaff) {
                        (loan.getUser()).setTotalFines(amountOfDays * 0.75);
                    }
                    return;
                }
                // If the loan was made by a member of staff.
                else {
                    (loan.getStaff()).setIsSuspended(true);
                    (loan.getStaff()).setTotalFines(amountOfDays * 0.75);
                    return;
                }
            }
            else {
                System.out.println("This loan is either not expired or the item has already" +
                        " been returned.");
                return;
            }
        }
        else {
            System.out.println("You must be an ADMINISTRATOR to perform this operation.");
            return;
        }
    }
}
