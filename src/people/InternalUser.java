package people;

import java.time.LocalDate;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Class that represents a registered library user.
 *
 * @author Matheus Reato (RA: 244088), Caio Taishi (RA: 242908).
 */

public class InternalUser extends Person {
    // Private Attributes ---------------------------------------------------------------
    private int ra;

    // Constructor ----------------------------------------------------------------------
    public InternalUser(String name, String surname, String socialId, String username,
                String password, int ra) {
        this.name = name;
        this.surname = surname;
        this.socialId = socialId;
        this.username = username;
        this.password = password;
        this.ra = ra;
        this.isSuspended = false;
        this.memberId = generateId(this.username);
        this.registrationDate = LocalDate.now();
    }

    // Getters --------------------------------------------------------------------------
    public String getMemberId() {             // Method made public for testing purposes.
        return memberId;
    }
}
