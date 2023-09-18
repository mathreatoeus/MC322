package views;

import controllers.LibraryController;
import models.library.management.Loan;
import models.library.content.Item;
import java.util.ArrayList;

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
    public void displayItems() {
        ArrayList<Item> items = (this.libController).listItems();
        System.out.println("---------- Item List ----------");

        for (Item item : items) {
            System.out.println("-------------------------------");
            System.out.println(item.toString());                            // Overriden.
            System.out.println("-------------------------------");
        }

        System.out.println("-------------------------------");
    }

    public void displayActiveLoans() {
        ArrayList<Loan> loans = (this.libController).listLoans();
        System.out.println("---------- Loan List ----------");

        for (Loan loan : loans) {
            System.out.println("-------------------------------");
            System.out.println(loan.toString());                            // Overriden.
            System.out.println("-------------------------------");
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
