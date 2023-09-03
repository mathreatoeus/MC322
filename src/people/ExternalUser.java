package people;

import java.time.LocalDate;

/**
 * Class that represents a user from outside the University.
 *
 * @author Matheus Reato (RA: 244088), Caio Taishi (RA: 242908).
 */

public class ExternalUser extends User {
    // Private Attributes ---------------------------------------------------------------
    private LocalDate expirationDate;

    // Constructor ----------------------------------------------------------------------
    public ExternalUser(String name, String surname, String socialId, String username,
                        String password, String address, String email, String phoneNumber) {
        super(name, surname, socialId, username, password, address, email, phoneNumber);
        this.expirationDate = this.getRegistrationDate().plusMonths(6);
    }

    // Getters --------------------------------------------------------------------------
    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    // Setters --------------------------------------------------------------------------
    private void setExpirationDate(LocalDate newExpirationDate) {
        this.expirationDate = newExpirationDate;
    }

    // Methods --------------------------------------------------------------------------

    /**
     * Method to try and renew an ExternalUser's membership to the Library. It can only be
     * renewed if the user is not suspended.
     *
     * @param amountOfTime The amount of time by which to extend the membership.
     * @return true on success and false on failure.
     */
    public boolean renewMembership(long amountOfTime) {
        if (!this.getIsSuspended()) {
            setExpirationDate(this.expirationDate.plusMonths(amountOfTime));
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Method to try and renew an ExternalUser's membership to the Library for 1
     * semester (six months). It can only be renewed if the user is not suspended.
     *
     * @return true on success and false on failure.
     */
    public boolean renewMembership() {
        if (!this.getIsSuspended()) {
            setExpirationDate(this.expirationDate.plusMonths(6));
            return true;
        }
        else {
            return false;
        }
    }
}
