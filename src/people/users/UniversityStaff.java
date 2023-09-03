package people.users;

/**
 * Class that represents a user who's a member of the University's staff
 *
 * @author Matheus Reato (RA: 244088), Caio Taishi (RA: 242908).
 */

public class UniversityStaff extends User {
    private int uniStaffId;

    // Constructor ----------------------------------------------------------------------
    public UniversityStaff(String name, String surname, String socialId, String username,
                           String password, String address, String email, String phoneNumber,
                           int uniStaffId) {
        super(name, surname, socialId, username, password, address, email, phoneNumber);
        this.uniStaffId = uniStaffId;
    }

    // Getters --------------------------------------------------------------------------
    private int getUniStaffId() {
        return uniStaffId;
    }

    // Setters --------------------------------------------------------------------------
    private void setUserStaffId(int newUniStaffId) {
        this.uniStaffId = newUniStaffId;
    }
}
