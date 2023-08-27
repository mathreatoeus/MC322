package library;

import java.time.LocalDate;
import people.User;
import people.ExternalUser;
import people.FacultyUser;
import people.LibraryStaff;
import people.UniversityStaff;
import library.Report;

/**
 * Class that represents a loan of a Book from a Library to a User.
 *
 * @author Matheus Reato (RA: 244088), Caio Taishi (RA: 242908).
 */

public class Loan {
    // Private Attributes ---------------------------------------------------------------
    private Library library;
    private Multimedia item;
    private User user;                                                  // If applicable.
    private LibraryStaff libStaffMember;                                // If applicable.
    private LocalDate loanDate;
    private LocalDate retrievalDate;
    private byte amountOfRenewals;
    private boolean retrieved;

    // Constructor (loan to user) ----------------------------------------------
    public Loan(Library library, Multimedia item, User user) {
        this.library = library;
        this.user = user;
        this.libStaffMember = null;
        this.loanDate = LocalDate.now();
        this.retrievalDate = this.loanDate.plusDays(7);
        this.amountOfRenewals = 0;
        this.retrieved = false;

        // Checking to see if the requested book is available for loan.
        if (item.getAvailable()) {
            this.item = item;
            this.item.incrementTimesBorrowed();
            this.item.setAvailable(false);

            // Generating Report
            Report newReport = new Report("Loan", this.user, this.item);
            newReport.generateReport();
        }
        else {
            this.item = null;
            System.out.println("Sorry, that book is not currently available.");
        }
    }

    // Constructor (loan to a staff member)
    public Loan(Library library, Book book, LibraryStaff staff) {
        this.library = library;
        this.user = null;
        this.libStaffMember = staff;
        this.loanDate = LocalDate.now();
        this.retrievalDate = this.loanDate.plusDays(7);
        this.amountOfRenewals = 0;

        // Checking to see if the requested book is available for loan.
        if (book.getAvailable()) {
            this.item = book;
            this.item.incrementTimesBorrowed();
            this.item.setAvailable(false);
        }
        else {
            this.item = null;
            System.out.println("Sorry, that book is not currently available.");
        }

        // Generating Report
        Report newReport = new Report("Loan", this.user, this.item);
        newReport.generateReport();
    }

    // Getters --------------------------------------------------------------------------
    public Library getLibrary() {
        return library;
    }

    public Multimedia getItem() {
        return item;
    }

    public String getBookTitle() {
        return this.getItem().getTitle();
    }

    public User getUser() {
        return user;
    }

    public LibraryStaff getStaff() {
        return libStaffMember;
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
    public boolean isExpired() {
        if (LocalDate.now().isAfter(this.retrievalDate)) {
            Report suspensionReport;

            if (this.user != null) {
                this.user.setIsSuspended(true);
                suspensionReport = new Report("Suspension", this.user, this.item);
            }
            else {
                this.libStaffMember.setIsSuspended(true);
                suspensionReport = new Report("Suspension", this.libStaffMember, this.item);
            }
            suspensionReport.generateReport();
            return true;
        }
        else {
            return false;
        }
    }
}
