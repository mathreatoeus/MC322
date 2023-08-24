package people;

/**
 * Class that represents a user who's a faculty member.
 *
 * @author Matheus Reato (RA: 244088), Caio Taishi (RA: 242908).
 */

public class FacultyUser extends User {
    // Private Attributes ---------------------------------------------------------------
    private int facultyId;

    // Constructor ----------------------------------------------------------------------
    public FacultyUser(String name, String surname, String socialId, String username,
                       String password, int facultyId) {
        super(name, surname, socialId, username, password);
        this.facultyId = facultyId;
    }

    // Getters --------------------------------------------------------------------------
    private int getFacultyId() {
        return facultyId;
    }
}
