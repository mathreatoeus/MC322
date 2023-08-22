package people;

import java.time.LocalDate;

/**
 * Class that represents a user from outside the University.
 *
 * @author Matheus Reato (RA: 244088), Caio Taishi (RA: 242908).
 */

public class ExternalUser extends Person {
    // Private Attributes ---------------------------------------------------------------
    private LocalDate expirationDate;

    // Constructor ----------------------------------------------------------------------
    public ExternalUser(String name, String surname, String socialId, String username,
                        String password) {
        this.name = name;
        this.surname = surname;
        this.socialId = socialId;
        this.username = username;
        this.password = password;
        this.isSuspended = false;
        this.registrationDate = LocalDate.now();
        this.memberId = generateId(this.username);
        this.expirationDate = this.registrationDate.plusMonths(6);
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
        if (!this.isSuspended) {
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
        if (!this.isSuspended) {
            setExpirationDate(this.expirationDate.plusMonths(6));
            return true;
        }
        else {
            return false;
        }
    }
}
