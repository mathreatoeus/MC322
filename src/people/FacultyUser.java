package people;

public class FacultyUser extends Person {
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
