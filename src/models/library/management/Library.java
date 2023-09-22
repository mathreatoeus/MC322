package models.library.management;

import models.library.content.*;
import models.people.User;
import models.people.LibraryStaff;

import java.util.LinkedList;

/**
 * Class that represents a library belonging to an institute of the university.
 *
 * @author Matheus Reato (RA: 244088), Caio Taishi (RA: 242908).
 */

public class Library {
    // Private Attributes ---------------------------------------------------------------
    private String institute;
    private LinkedList<Item> items;
    private LinkedList<LibraryStaff> libStaff;
    private LinkedList<User> users;

    // Constructor ----------------------------------------------------------------------
    public Library(String institute) {
        this.institute = institute;
        this.items = new LinkedList<>();
        this.libStaff = new LinkedList<>();
        this.users = new LinkedList<>();
    }

    // Getters --------------------------------------------------------------------------
    public String getInstitute() {
        return institute;
    }

    public LinkedList<Item> getItems() {
        return items;
    }

    public LinkedList<LibraryStaff> getStaff() {
        return libStaff;
    }

    public LinkedList<User> getUsers() {
        return users;
    }

    // Setters --------------------------------------------------------------------------
    private void setInstitute(String newInstitute) {
        this.institute = newInstitute;
    }

    // Methods -------------------------------------------------------------------------

    /**
     * Method to try and add a Book to the Library.
     *
     * @param newItem item to add.
     * @return true on success and false on failure.
     */
    public boolean addItem(Item newItem) {
        if (!this.items.contains(newItem)) {
            (this.items).add(newItem);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Method to try and add a new staff member to a Library's staff list.
     *
     * @param staffMember The new staff member to be added to the list.
     * @return true on success and false on failure.
     */
    public boolean addStaff(LibraryStaff staffMember) {
        if (!this.libStaff.contains(staffMember)) {
            this.libStaff.add(staffMember);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Method to try and remove a staff member from a Library's staff.
     *
     * @param staffMember The staff member to be removed.
     * @return true on success and false on failure.
     */
    public boolean removeStaff(LibraryStaff staffMember) {
        if (this.libStaff.contains(staffMember)) {
            this.libStaff.remove(staffMember);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Method to try and add a new user to a Library's user list.
     *
     * @param newUser User to be added.
     * @return true on success and false on failure.
     */
    public boolean addUser(User newUser) {
        if(!this.users.contains(newUser)) {
            this.users.add(newUser);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Method to try and remove a user from a Library's user list.
     *
     * @param user User to be removed.
     * @return true on success and false on failure.
     */
    public boolean removeUser(User user) {
        if(this.users.contains(user)) {
            this.users.remove(user);
            return true;
        }
        else {
            return false;
        }
    }
}
