package people;

public class UniversityStaff extends User {
    private int uniStaffId;

    // Constructor ----------------------------------------------------------------------
    public UniversityStaff(String name, String surname, String socialId, String username,
                           String password, int uniStaffId) {
        super(name, surname, socialId, username, password);
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
