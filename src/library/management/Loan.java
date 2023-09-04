package library.management;

import java.time.LocalDate;

import library.Book;
import library.Library;
import library.Multimedia;
import people.staff.LibraryStaff;
import people.users.FacultyUser;
import people.users.Student;
import people.users.UniversityStaff;
import people.users.User;

/**
 * Class that represents a loan of a Book from a Library to a User. The retrieval date will
 * be null if the loan can't be completed.
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

    // Constructor (loan to user) -------------------------------------------------------
    public Loan(Library library, Multimedia item, User user) {
        this.loanDate = LocalDate.now();
        this.amountOfRenewals = 0;
        this.retrieved = false;

        // Checking to see if the loan is possible.
        boolean isPossible = true;

        if (item.getAvailable() && !user.getIsSuspended()) {
            if (user instanceof Student) {
                if (((Student) user).getIsGradStudent() && user.getNumberOfActiveLoans() < 5) {
                    this.retrievalDate = this.loanDate.plusDays(20);
                }
                else if (((Student) user).getIsGradStudent() && user.getNumberOfActiveLoans() < 3) {
                    this.retrievalDate = this.loanDate.plusDays(15);
                }
                else {
                    isPossible = false;

                    System.out.println("Sorry, the loan cannot be completed because you" +
                            " have reached the maximum amount of simultaneous loans");
                }
            }
            else if (user instanceof FacultyUser) {
                if (user.getNumberOfActiveLoans() < 7) {
                    this.retrievalDate = this.loanDate.plusDays(30);
                }
                else {
                    isPossible = false;

                    System.out.println("Sorry, the loan cannot be completed because you" +
                            " have reached the maximum amount of simultaneous loans");
                }
            }
            else if (user instanceof UniversityStaff) {
                if (user.getNumberOfActiveLoans() < 4) {
                    this.retrievalDate = this.loanDate.plusDays(20);
                }
                else {
                    isPossible = false;

                    System.out.println("Sorry, the loan cannot be completed because you" +
                            " have reached the maximum amount of simultaneous loans");
                }
            }
            else { // External User
                if (user.getNumberOfActiveLoans() < 3) {
                    this.retrievalDate = this.loanDate.plusDays(7);
                }
                else {
                    isPossible = false;

                    System.out.println("Sorry, the loan cannot be completed because you" +
                            " have reached the maximum amount of simultaneous loans");
                }
            }
        }
        else {
            this.library = null;
            this.item = null;
            this.user = null;
            this.libStaffMember = null;
            this.retrievalDate = null;

            System.out.println("Sorry, the loan cannot be completed either because the" +
                    " item is not available at the moment or you have been suspended.");
        }

        if (isPossible) {
            this.library = library;
            this.item = item;
            this.user = user;
            this.libStaffMember = null;

            this.item.setAvailable(false);
            this.user.incrementActiveLoans();
        }
        else {
            this.library = null;
            this.item = null;
            this.user = null;
            this.libStaffMember = null;
            this.retrievalDate = null;
        }

    }

    // Constructor (loan to a staff member)
    public Loan(Library library, Book book, LibraryStaff staff) {
        this.loanDate = LocalDate.now();
        this.amountOfRenewals = 0;
        this.retrieved = false;

        // Checking to see if the loan is possible.
        if (item.getAvailable() && !staff.getIsSuspended() && staff.getNumberOfActiveLoans() < 4) {
            this.library = library;
            this.item = item;
            this.user = null;
            this.libStaffMember = staff;

            this.item.setAvailable(false);
            this.libStaffMember.incrementActiveLoans();
        }
        else {
            this.library = null;
            this.item = null;
            this.user = null;
            this.libStaffMember = null;
            this.retrievalDate = null;

            System.out.println("Sorry, the loan cannot be completed either because the" +
                    " item is not available at the moment, you have been suspended, or" +
                    " you have reached the maximum amount of simultaneous loans.");
        }
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
        return true;
    }

    /**
     * Method to check if the current loan is still valid and update the book's
     * availability status.
     *
     * @return true if it is and false if it isn't.
     */
    public boolean isExpired() {
        return true;
    }
}
