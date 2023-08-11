package library;

import people.Staff;
import people.User;

import java.util.LinkedList;

/**
 * Class that represents a library belonging to an institute of the university
 *
 * @author Matheus Reato (RA: 244088)
 */

public class Library {
    // Private Attributes ---------------------------------------------------------------
    private String institute;
    private LinkedList<Book> books;   // Might be substituted by a min-heap in the future
    private LinkedList<Staff> staff;
    private LinkedList<User> users;

    // Constructor ----------------------------------------------------------------------
    public Library(String institute) {
        this.institute = institute;
        this.books = new LinkedList<>();
        this.staff = new LinkedList<>();
        this.users = new LinkedList<>();
    }

    // Getters --------------------------------------------------------------------------
    public String getInstitute() {
        return institute;
    }

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
     * Method to try and add a Book to the Library. It will only add the book if it isn't
     * yet in the Library.
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
     * Method to try and remove a Book from the Library. It will only remove the book if
     * it is already in the Library.
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
}
