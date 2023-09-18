package models.people;

/**
 * Class that represents a registered library user.
 *
 * @author Matheus Reato (RA: 244088), Caio Taishi (RA: 242908).
 */

public class Student extends User {
    // Private Attributes ---------------------------------------------------------------
    private final int studentId;
    private final boolean isGradStudent;

    // Constructor ----------------------------------------------------------------------
    public Student(String name, String surname, String socialId, String username,
                   String password, String address, String email, String phoneNumber,
                   int studentId, boolean isGradStudent) {
        super(name, surname, socialId, username, password, address, email, phoneNumber);
        this.studentId = studentId;
        this.isGradStudent = isGradStudent;
    }

    // Getters --------------------------------------------------------------------------
    public int getStudentId() {
        return studentId;
    }

    public boolean getIsGradStudent() {
        return isGradStudent;
    }
}
