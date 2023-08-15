package library;

import java.time.LocalDate;
import people.InternalUser;
import people.ExternalUser;
import people.FacultyUser;
import people.Staff;

/**
 * Class that represents a loan of a Book from a Library to a User.
 *
 * @author Matheus Reato (RA: 244088), Caio Taishi (RA: 242908).
 */

public class Loan {
    // Private Attributes ---------------------------------------------------------------
    private Library library;
    private Book book;
    private Staff staff;                                                // If applicable.
    private InternalUser internalUser;                                  // If applicable.
    private ExternalUser externalUser;                                  // If applicable.
    private FacultyUser facultyUser;                                    // If applicable.
    private LocalDate loanDate;
    private LocalDate retrievalDate;
    private byte amountOfRenewals;

    // Constructor (loan to internal user) -------------------------------------------------------
    public Loan(Library library, Book book, InternalUser internalUser) {
        this.library = library;
        this.internalUser = internalUser;
        this.loanDate = LocalDate.now();
        this.retrievalDate = this.loanDate.plusDays(7);
        this.amountOfRenewals = 0;

        // Checking to see if the requested book is available for loan.
        if (book.getAvailable()) {
            this.book = book;
            this.book.incrementTimesBorrowed();
            this.book.setAvailable(false);
        }
        else {
            this.book = null;
        }
    }

    // Constructor (loan to an external user)
    public Loan(Library library, Book book, ExternalUser externalUser) {
        this.library = library;
        this.externalUser = externalUser;
        this.loanDate = LocalDate.now();
        this.retrievalDate = this.loanDate.plusDays(7);
        this.amountOfRenewals = 0;

        // Checking to see if the requested book is available for loan.
        if (book.getAvailable()) {
            this.book = book;
            this.book.incrementTimesBorrowed();
            this.book.setAvailable(false);
        }
        else {
            this.book = null;
        }
    }

    // Constructor (loan to faculty user)
    public Loan(Library library, Book book, FacultyUser facultyUser) {
        this.library = library;
        this.facultyUser = facultyUser;
        this.loanDate = LocalDate.now();
        this.retrievalDate = this.loanDate.plusDays(7);
        this.amountOfRenewals = 0;

        // Checking to see if the requested book is available for loan.
        if (book.getAvailable()) {
            this.book = book;
            this.book.incrementTimesBorrowed();
            this.book.setAvailable(false);
        }
        else {
            this.book = null;
        }
    }

    // Constructor (loan to a staff member)
    public Loan(Library library, Book book, Staff staff) {
        this.library = library;
        this.staff = staff;
        this.loanDate = LocalDate.now();
        this.retrievalDate = this.loanDate.plusDays(7);
        this.amountOfRenewals = 0;

        // Checking to see if the requested book is available for loan.
        if (book.getAvailable()) {
            this.book = book;
            this.book.incrementTimesBorrowed();
            this.book.setAvailable(false);
        }
        else {
            this.book = null;
        }
    }

    // Getters --------------------------------------------------------------------------
    public Library getLibrary() {
        return library;
    }

    public Book getBook() {
        return book;
    }

    public String getBookTitle() {
        return this.getBook().getTitle();
    }

    public User getUser() {
        return user;
    }

    public Staff getStaff() {
        return staff;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public LocalDate getRetrievalDate() {
        return retrievalDate;
    }

    // Setters --------------------------------------------------------------------------
    public void setRetrievalDate(LocalDate newRetrievalDate) {
        this.retrievalDate = newRetrievalDate;
    }

    // Methods --------------------------------------------------------------------------

    /**
     * Method to try and renew the loan. The maximum amount of renewals allowed is 5.
     *
     * @return true on success and false on failure.
     */
    public boolean renewLoan() {
        if (this.amountOfRenewals <= 5) {
            this.setRetrievalDate(this.retrievalDate.plusDays(7));
            this.amountOfRenewals++;

            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Method to check if the current loan is still valid and update the book's
     * availability status.
     *
     * @return true if it is and false if it isn't.
     */
    public boolean checkExpiration() {
        if (this.getRetrievalDate().equals(LocalDate.now())) {
            this.book.setAvailable(true);
            return false;
        }
        else {
            return true;
        }
    }
}
