package models.people;

import java.time.LocalDate;
import java.util.LinkedList;
import models.library.management.Loan;
import models.library.management.Reserve;

/**
 * Class that represents a general person. Superclass of User.
 *
 * @author Matheus Reato (RA: 244088), Caio Taishi (RA: 242908).
 */

abstract public class Person {
    // Private Attributes -------------------------------------------------------------

    private String name;
    private String surname;
    private String socialId;
    private String username;
    private String password;
    private String address;
    private String email;
    private String phoneNumber;
    private int numberOfActiveLoans;
    private double totalFines;
    private boolean isSuspended;
    private LocalDate registrationDate;
    private LinkedList<Loan> loans;
    private LinkedList<Reserve> reserves;

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
        this.totalFines = 0;
        this.loans = new LinkedList<>();
        this.reserves = new LinkedList<>();
    }

    // Getters --------------------------------------------------------------------------

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getSocialId() {
        return socialId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
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

    public int getNumberOfActiveLoans() {
        return numberOfActiveLoans;
    }

    private double getTotalFines() {
        return totalFines;
    }

    public boolean getIsSuspended() {
        return isSuspended;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public LinkedList<Loan> getLoans() {
        return loans;
    }

    public LinkedList<Reserve> getReserves() {
        return reserves;
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

    private void setNumberOfActiveLoans(int num) {
        this.numberOfActiveLoans = num;
    }

    public void setTotalFines(double newTotalFines) {
        this.totalFines = newTotalFines;
    }

    // Methods --------------------------------------------------------------------------

    @Override
    public String toString() {
        return "Name: " + this.name + " " + this.surname + "\n" +
                "Social ID: " + this.socialId;
    }

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

    /**
     * Method that increments the user's number of active loans.
     */
    public void incrementActiveLoans() {
        this.numberOfActiveLoans++;
    }

    /**
     * Method that decreases the user's number of active loans.
     */
    public void decreaseActiveLoans() {
        this.numberOfActiveLoans--;
    }

    /**
     * Method to add a new loan to the user's loan list.
     *
     * @param newLoan the loan to be added.
     */
    public void addLoan(Loan newLoan) {
        (this.loans).add(newLoan);
    }

    /**
     * Method to add a new reserve to the user's reserve list.
     *
     * @param newReserve the reserve to be added.
     */
    public void addReserve(Reserve newReserve) {
        (this.reserves).add(newReserve);
    }
}
