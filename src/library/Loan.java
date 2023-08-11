package library;

import java.time.LocalDate;
import people.User;
import people.Staff;

/**
 * Class that represents a loan of a Book from a Library to a User
 *
 * @author Matheus Reato (RA: 244088)
 */

public class Loan {
    // Private Attributes ---------------------------------------------------------------
    private Library library;
    private Book book;
    private User user;      // If applicable
    private Staff staff;    // If applicable
    private LocalDate loanDate;
    private LocalDate retrievalDate;
    private byte amountOfRenewals;

    // Constructor (loan to user) -------------------------------------------------------
    public Loan(Library library, Book book, User user) {
        this.library = library;
        this.book = book;
        this.user = user;
        this.loanDate = LocalDate.now();
        this.retrievalDate = this.loanDate.plusDays(7);
        this.amountOfRenewals = 0;
    }

    // Constructor (loan to a staff member)
    public Loan(Library library, Book book, Staff staff) {
        this.library = library;
        this.book = book;
        this.staff = staff;
        this.loanDate = LocalDate.now();
        this.retrievalDate = this.loanDate.plusDays(7);
        this.amountOfRenewals = 0;
    }

    // Getters --------------------------------------------------------------------------
    public Library getLibrary() {
        return library;
    }

    public Book getBook() {
        return book;
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
     * Method to try and renewal the loan. The maximum amount of renewals allowed is 5.
     *
     * @return true on success and false on failure.
     */
    public boolean renewLoan() {
        if (this.amountOfRenewals <= 5) {
            this.setRetrievalDate(this.retrievalDate.plusDays(7));
            this.amountOfRenewals++;
            this.book.incrementTimesBorrowed();

            return true;
        }
        else {
            return false;
        }
    }
}
