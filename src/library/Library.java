package library;

import people.Staff;
import people.User;
<<<<<<< HEAD

=======
>>>>>>> 0d64a83d68b00042db9dd681820de4cf181007e2
import java.util.LinkedList;

/**
 * Class that represents a library belonging to an institute of the university.
 *
 * @author Matheus Reato (RA: 244088), Caio Taishi (RA: 242908).
 */

public class Library {
    // Private Attributes ---------------------------------------------------------------
    private String institute;
<<<<<<< HEAD
=======
    private String address;
>>>>>>> 0d64a83d68b00042db9dd681820de4cf181007e2
    private LinkedList<Book> books;  // Might be substituted by a min-heap in the future.
    private LinkedList<Staff> staff;
    private LinkedList<User> users;

    // Constructor ----------------------------------------------------------------------
<<<<<<< HEAD
    public Library(String institute) {
        this.institute = institute;
=======
    public Library(String institute, String address) {
        this.institute = institute;
        this.address = address;
>>>>>>> 0d64a83d68b00042db9dd681820de4cf181007e2
        this.books = new LinkedList<>();
        this.staff = new LinkedList<>();
        this.users = new LinkedList<>();
    }

    // Getters --------------------------------------------------------------------------
    public String getInstitute() {
        return institute;
    }

<<<<<<< HEAD
=======
    public String getAddress() {
        return address;
    }

>>>>>>> 0d64a83d68b00042db9dd681820de4cf181007e2
    public LinkedList<Book> getBooks() {
        return books;
    }

    public LinkedList<Staff> getStaff() {
        return staff;
    }

    public LinkedList<User> getUsers() {
        return users;
    }

    // Setters --------------------------------------------------------------------------
    public void setInstitute(String newInstitute) {
        this.institute = newInstitute;
    }

    // Methods --------------------------------------------------------------------------

    /**
     * Method to try and add a Book to the Library.
     *
     * @param newBook Book to be added.
     * @return true on succcess and false on failure.
     */
    public boolean addBook(Book newBook) {
        if (!this.books.contains(newBook)) {
            this.books.add(newBook);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Method to try and remove a Book from the Library.
     *
     * @param bookToRemove Book to be removed.
     * @return true on success and false on failure.
     */
    public boolean removeBook(Book bookToRemove) {
        if (this.books.contains(bookToRemove)) {
            this.books.remove(bookToRemove);
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
    public boolean addStaff(Staff staffMember) {
        if (!this.staff.contains(staffMember)) {
            this.staff.add(staffMember);
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
    public boolean removeStaff(Staff staffMember) {
        if (this.staff.contains(staffMember)) {
            this.staff.remove(staffMember);
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
