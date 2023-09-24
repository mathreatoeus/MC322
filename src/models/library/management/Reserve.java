package models.library.management;

import java.time.LocalDate;
import models.people.*;

/**
 * Class that represents a reserve of an item.
 *
 * @author Matheus Reato (RA: 244088), Caio Taishi (RA: 242908).
 */

public abstract class Reserve {
    // Private Attributes ---------------------------------------------------------------
    private final Person user;
    private final LocalDate reserveDate;

    // Constructor (reserved by user) ---------------------------------------------------
    public Reserve(Person user) {
        if (!user.getIsSuspended()) {
            this.user = user;
            this.reserveDate = LocalDate.now();
        }
        else {
            this.user = null;
            this.reserveDate = null;
        }
    }

    // Getters --------------------------------------------------------------------------
    public Person getUser() {
        return user;
    }

    public LocalDate getReserveDate() {
        return getReserveDate();
    }
}
