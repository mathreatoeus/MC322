package people;

import java.time.LocalDate;

/**
 * Class that represents a general person. Superclass of User.
 *
 * @author Matheus Reato (RA: 244088), Caio Taishi (RA: 242908).
 */

abstract public class Person {
    // Protected Attributes -------------------------------------------------------------
    private String name;
    private String surname;
    private String socialId;
    private String username;
    private String password;
    private String address;
    private String email;
    private String phoneNumber;
    private int numberOfActiveLoans;
    private boolean isSuspended;
    private LocalDate registrationDate;

    // Constructor ----------------------------------------------------------------------

    public Person(String name, String surname, String socialId, String username,
                  String password, String address, String email, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.socialId = socialId;
        this.username = username;
        this.password = password;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.numberOfActiveLoans = 0;
        this.isSuspended =  false;
        this.registrationDate = LocalDate.now();
    }

    // Getters --------------------------------------------------------------------------
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    private String getSocialId() {
        return socialId;
    }

    public String getUsername() {
        return username;
    }

    protected String getPassword() {
        return password;
    }

    private String getAddress() {
        return address;
    }

    private String getEmail() {
        return email;
    }

    private String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean getIsSuspended() {
        return isSuspended;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    // Setters --------------------------------------------------------------------------
    private void setUsername(String newUsername) {
        this.username = newUsername;
    }

    private void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public void setIsSuspended(boolean new_status) {
        this.isSuspended = new_status;
    }

    // Methods --------------------------------------------------------------------------

    /**
     * Method to try and change the current user's username upon authentication.
     *
     * @param newUsername New desired username.
     * @param currentPassword This staff member's current password.
     * @return true on success and false on failure.
     */
    public boolean changeUsername(String newUsername, String currentPassword) {
        if (currentPassword.equals(this.password)) {
            setUsername(newUsername);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Method to try and change the current user's password upon authentication.
     *
     * @param newPassword New desired password.
     * @param currentPassword This staff member's current password.
     * @return true on success and false on failure.
     */
    public boolean changePassword(String newPassword, String currentPassword) {
        if (currentPassword.equals(this.password)) {
            setPassword(newPassword);
            return true;
        }
        else {
            return false;
        }
    }
}
