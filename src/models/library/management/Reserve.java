package models.library.management;

import java.time.LocalDate;

import models.library.content.Item;
import models.people.*;

/**
 * Class that represents a reserve of an item.
 *
 * @author Matheus Reato (RA: 244088), Caio Taishi (RA: 242908).
 */

public class Reserve {
    // Private Attributes ---------------------------------------------------------------
    private Library library;
    private Item item;
    private User user;
    private LibraryStaff libStaff;
    private LocalDate reserveDate;
    private LocalDate pickupDate;

    // Constructor (reserved by user) ---------------------------------------------------
    public Reserve(Library library, Item item, User user) {
        if (!this.user.getIsSuspended()) {
            this.library = library;
            this.item = item;
            this.user = user;
            this.libStaff = null;

            // Determining the pickup date.
            if (((this.item).getReserves()).isEmpty()) {
                // If there are no reserves, the pickup date is this item's retrieval date
                // from the current loan.
                this.pickupDate = (((this.item).getCurrentLoan()).getRetrievalDate());
            }
            else {
                Reserve latestReserve = (this.item).pickLatestReserve();

                // Determining the amount of time the user will keep the item.
                if (latestReserve.getUser() == null) {
                    // It's a library staff member.
                    this.pickupDate = latestReserve.getPickupDate().plusDays(20);
                }
                else if (latestReserve.getUser() instanceof Student) {
                    if (((Student) latestReserve.getUser()).getIsGradStudent()) {
                        this.pickupDate = latestReserve.getPickupDate().plusDays(20);
                    }
                    else {
                        this.pickupDate = latestReserve.getPickupDate().plusDays(15);
                    }
                }
                else if (latestReserve.getUser() instanceof FacultyUser) {
                    this.pickupDate = latestReserve.getPickupDate().plusDays(30);
                }
                else if (latestReserve.getUser() instanceof UniversityStaff) {
                    this.pickupDate = latestReserve.getPickupDate().plusDays(20);
                }
                else {
                    // External user
                    this.pickupDate = latestReserve.getPickupDate().plusDays(7);
                }

                this.item.addReserve(this);
                this.user.addReserve(this);
            }

        } else {
            this.library = null;
            this.item = null;
            this.user = null;
            this.libStaff = null;
            this.pickupDate = null;

            System.out.println("Sorry, this item can't be reserved.");
        }

        this.reserveDate = LocalDate.now();
    }

    // Constructor (reserved by library staff)
    public Reserve(Library library, Item item, LibraryStaff libStaff) {
        // Must be updated to get pickup date and add the reserve to the staff member's
        // reserve list
        if (!this.libStaff.getIsSuspended()) {
            this.library = library;
            this.item = item;
            this.user = null;
            this.libStaff = libStaff;
        }
        else {
            this.library = null;
            this.item = null;
            this.user = null;
            this.libStaff = null;

            System.out.println("Sorry, this item can't be reserved.");
        }
    }

    // Getters --------------------------------------------------------------------------
    public Library getLibrary() {
        return library;
    }

    public Item getItem() {
        return item;
    }

    public User getUser() {
        return user;
    }

    public LibraryStaff getLibStaff() {
        return libStaff;
    }

    public LocalDate getReserveDate() {
        return reserveDate;
    }

    public LocalDate getPickupDate() {
        return pickupDate;
    }

    // Methods --------------------------------------------------------------------------

    @Override
    public String toString() {
        return "Item ID: " + (this.item).getId() + "\n" +
                "User: " + (this.user).getName() + " " + (this.user).getSurname() + "\n" +
                "Pickup date: " + (this.getPickupDate()).toString() + "\n";
    }
}
