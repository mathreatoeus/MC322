package people.users;

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
                       String password, String address, String email, String phoneNumber,
                       int facultyId) {
        super(name, surname, socialId, username, password, address, email, phoneNumber);
        this.facultyId = facultyId;
    }

    // Getters --------------------------------------------------------------------------
    private int getFacultyId() {
        return facultyId;
    }
}
