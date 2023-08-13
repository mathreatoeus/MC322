package people;

/**
 * Class that represents a general non-registered, non-staff person. Superclass of User
 * and Staff.
 *
 * @author Matheus Reato (RA: 244088), Caio Taishi (RA: 242908).
 */

public class Person {
    // Protected Attributes -------------------------------------------------------------
    protected String name;
    protected String surname;
    protected String socialId;

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
}
