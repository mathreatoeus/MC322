package people;

/**
 * Class that represents a registered library user.
 *
 * @author Matheus Reato (RA: 244088), Caio Taishi (RA: 242908).
 */

public class Student extends Person {
    // Private Attributes ---------------------------------------------------------------
    private int ra;
    private boolean isGradStudent;

    // Constructor ----------------------------------------------------------------------
    public Student(String name, String surname, String socialId, String username,
                String password, int ra, boolean isGradStudent) {
        super(name, surname, socialId, username, password);
        this.ra = ra;
        this.isGradStudent = isGradStudent;
    }
}
