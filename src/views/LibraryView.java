package views;

import controllers.LibraryController;
import models.library.management.Loan;
import models.library.content.Item;
import models.library.management.Reserve;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class LibraryView {
    // Private Attributes ---------------------------------------------------------------
    private final LibraryController libController;

    // Constructor ----------------------------------------------------------------------
    public LibraryView(LibraryController libController) {
        this.libController = libController;
    }

    // Getters --------------------------------------------------------------------------
    public LibraryController getLibController() {
        return libController;
    }

    // Methods --------------------------------------------------------------------------

    /**
     * Displays all the items in the library.
     */
    public void displayItems() {
        HashMap<String, Item> items = (this.libController).listItems();
        System.out.println("---------- Item List ----------");

        for (HashMap.Entry<String, Item> item : items.entrySet()) {
            System.out.println("-------------------------------");
            System.out.println(item.toString());                            // Overriden.
            System.out.println("-------------------------------");
        }

        System.out.println("-------------------------------");
    }

    /**
     * Displays all the active loans.
     */
    public void displayActiveLoans() {
        HashSet<Loan> loans = (this.libController).listLoans();
        System.out.println("---------- Loan List ----------");

        for (Loan loan : loans) {
            System.out.println("-------------------------------");
            System.out.println(loan.toString());                            // Overriden.
            System.out.println("-------------------------------");
        }
    }

    public void displayReserves() {
        ArrayList<Reserve> reserves = (this.libController).listReserves();
        System.out.println("---------- Reserve List ----------");

        for (Reserve reserve : reserves) {
            System.out.println("----------------------------------");
            System.out.println(reserve.toString());
            System.out.println("----------------------------------");
        }
    }

    public void voidshowLoanStatus(boolean status) {
        if (status){
            System.out.println("Loan completed!");
        }
        else {
            System.out.println("Failed to complete the loan.");
        }
    }

    public void displayRetrievalStatus(boolean status) {
        if (status) {
            System.out.println("Retrieval completed!");
        }
        else {
            System.out.println("Failed to perform the retrieval.");
        }
    }
}
