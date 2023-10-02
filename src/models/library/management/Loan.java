package models.library.management;

import java.time.LocalDate;
import models.library.content.Item;
import models.people.*;

/**
 * Class that represents a loan of a Book from a Library to a User. The retrieval date will
 * be null if the loan can't be completed.
 *
 * @author Matheus Reato (RA: 244088), Caio Taishi (RA: 242908).
 */

public class Loan {
    // Private Attributes ---------------------------------------------------------------
    private Library library;
    private Item item;
    private User user;                                                  // If applicable.
    private LibraryStaff libStaffMember;                                // If applicable.
    private final LocalDate loanDate;
    private LocalDate retrievalDate;
    private byte amountOfRenewals;
    private boolean retrieved;
    private boolean isActive;

    // Constructor (loan to user) -------------------------------------------------------
    public Loan(Library library, Item item, User user) {
        this.loanDate = LocalDate.now();
        this.amountOfRenewals = 0;
        this.retrieved = false;

        // Evaluating each possible case.
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

        // Taking action based on the isPossible flag.
        if (isPossible) {
            this.library = library;
            this.item = item;
            this.user = user;
            this.libStaffMember = null;
            this.isActive = true;

            this.item.setAvailable(false);
            this.user.incrementActiveLoans();
            this.user.addLoan(this);
        }
        else {
            this.library = null;
            this.item = null;
            this.user = null;
            this.libStaffMember = null;
            this.retrievalDate = null;
            this.isActive = false;
        }

    }

    // Constructor (loan to a staff member)
    public Loan(Library library, Item item, LibraryStaff staff) {
        this.loanDate = LocalDate.now();
        this.amountOfRenewals = 0;
        this.retrieved = false;

        if (item.getAvailable() && !staff.getIsSuspended() && staff.getNumberOfActiveLoans() < 4) {
            this.library = library;
            this.item = item;
            this.user = null;
            this.libStaffMember = staff;
            this.isActive = true;

            this.item.setAvailable(false);
            this.libStaffMember.incrementActiveLoans();
            this.libStaffMember.addLoan(this);
        }
        else {
            this.library = null;
            this.item = null;
            this.user = null;
            this.libStaffMember = null;
            this.retrievalDate = null;
            this.isActive = false;

            System.out.println("Sorry, the loan cannot be completed either because the" +
                    " item is not available at the moment, you have been suspended, or" +
                    " you have reached the maximum amount of simultaneous loans.");
        }
    }

    // Getters --------------------------------------------------------------------------
    public Library getLibrary() {
        return library;
    }

    public Item getItem() {
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

    public boolean getRetrieved() {
        return retrieved;
    }

    public boolean getIsActive() {
        return isActive;
    }

    // Setters --------------------------------------------------------------------------
    public void setRetrievalDate(LocalDate newRetrievalDate) {
        this.retrievalDate = newRetrievalDate;
    }

    public void setRetrieved(boolean newStatus) {
        this.retrieved = newStatus;
    }

    public void setIsActive(boolean newStatus) {
        this.isActive = newStatus;
    }

    // Methods --------------------------------------------------------------------------

    @Override
    public String toString() {
        return "Item ID: " + (this.item).getId() + "\n" +
                "User: " + (this.user).getName() + "\n" +
                "Retrieval Date: " + (this.retrievalDate).toString() + "\n";
    }

    /**
     * Method to try and renew the loan made to a user or staff member.
     *
     * @return true on success and false on failure.
     */
    public boolean renewLoan() {
        // If the loan was made by a User object.
        if (this.user != null) {
            if (!(this.user).getIsSuspended()) {
                this.amountOfRenewals++;

                // Evaluating each possible case for user.
                if (this.user instanceof Student) {
                    if (((Student) this.user).getIsGradStudent()) {
                        this.retrievalDate = this.retrievalDate.plusDays(20);
                    }
                    else {
                        this.retrievalDate = this.retrievalDate.plusDays(15);
                    }
                }
                else if (this.user instanceof FacultyUser) {
                    this.retrievalDate = this.retrievalDate.plusDays(30);
                }
                else if (this.user instanceof UniversityStaff) {
                    this.retrievalDate = this.retrievalDate.plusDays(20);
                }
                else {   // External User
                    this.retrievalDate = this.retrievalDate.plusDays(7);
                }

                return true;
            }
            else {
                System.out.println("Sorry, this loan cannot be renewed either because the item" +
                        " is reserved or you have been suspended.");

                return false;
            }
        }
        // If the loan was made by a LibraryStaff object.
        else {
            if (!this.libStaffMember.getIsSuspended()) {
                this.retrievalDate = this.retrievalDate.plusDays(20);
                this.amountOfRenewals++;

                return true;
            }
            else {
                System.out.println("Sorry, this loan cannot be renewed either because the item" +
                        " is reserved or you have been suspended.");

                return false;
            }
        }
    }

    /**
     * Method to check if the current loan is still valid and update the book's
     * availability status.
     *
     * @return true if it is and false if it isn't.
     */
    public boolean isExpired() {
        return (LocalDate.now()).isAfter(this.retrievalDate);
    }
}
