package controllers;

import java.util.ArrayList;
import models.people.*;

public class PersonController {
    // Private Attributes ---------------------------------------------------------------
    private final ArrayList<Person> users;

    // Constructor ----------------------------------------------------------------------
    public PersonController() {
        this.users = new ArrayList<>();
    }

    // Methods --------------------------------------------------------------------------

    /**
     * Method that returns the list of current active users.
     *
     * @return the users list.
     */
    public ArrayList<Person> listUsers() {
        return users;
    }

    /**
     * Method that performs a linear search in the users list by social ID.
     *
     * @param socialId the social ID you're looking for.
     * @return the user with the corresponding social ID (if existing).
     */
    public Person searchUserBySocialId(String socialId) {
        for (Person user : users) {
            if (user.getSocialId().equals(socialId)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Method that searches for a student by their student ID.
     *
     * @param studentId the student's ID.
     * @return the student with the corresponding ID (if existing).
     */
    public Person searchUserByStudentId(int studentId) {
        for (Person student : users) {
            if (student instanceof Student && ((Student) student).getStudentId() == studentId) {
                return student;
            }
        }
        return null;
    }

    /**
     * Method that searches for a staff member by their staff ID.
     *
     * @param uniStaffId the staff member's ID.
     * @return the staff member with the corresponding ID (if existing).
     */
    public Person searchUserByUniStaffId(int uniStaffId) {
        for (Person staff : users) {
            if (staff instanceof UniversityStaff && ((UniversityStaff) staff).getUniStaffId() == uniStaffId) {
                return staff;
            }
        }
        return null;
    }

    /**
     * Method that searches for a member of faculty by their faculty id.
     *
     * @param facultyId the user's faculty ID.
     * @return the faculty member with the corresponding ID.
     */
    public Person searchUserByFacultyId(int facultyId) {
        for (Person faculty : users) {
            if (faculty instanceof FacultyUser && ((FacultyUser) faculty).getFacultyId() == facultyId) {
                return faculty;
            }
        }
        return null;
    }

    /**
     * Tries to add a user to the user list.
     *
     * @param user user to add.
     * @return true on success and false on failure.
     */
    public boolean addUser(Person user) {
        if (!((this.users).contains(user))) {
            (this.users).add(user);
            return true;
        }
        else {
            System.out.println("This user has already been added.");
            return false;
        }
    }

    /**
     * Removes a user from the user list.
     *
     * @param user user to remove.
     */
    public void removeUser(Person user) {
        this.users.remove(user);
    }
}
