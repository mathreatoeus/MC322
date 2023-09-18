package models.library.management;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Iterator;

import models.library.content.Item;
import models.people.Person;
import models.people.User;
import models.people.LibraryStaff;

/**
 * Class that represents a report, which stores info on the Library's operation.
 *
 * @author Matheus Reato (RA: 244088), Caio Taishi (RA: 242908).
 */

public class Report {
    // Private Attributes ---------------------------------------------------------------
    private ReportType type;
    private final String reportTitle;
    private final Person user;
    private final LocalDate emissionDate;
    private final Item item;
    private final Library library;
    private static int instanceCount = 0;

    // Constructor (User) ---------------------------------------------------------------
    public Report(ReportType type, Person user, Item item, Library library) {
        this.type = type;
        this.reportTitle = this.type + "Report" + instanceCount;
        this.user = user;
        this.item = item;
        this.library = library;
        this.emissionDate = LocalDate.now();
        instanceCount++;
    }

    // Getters --------------------------------------------------------------------------
    public ReportType getReportType() {
        return type;
    }

    public Person getUser() {
        return user;
    }

    public Item getItem() {
        return item;
    }

    public String getItemTitle() {
        return item.getTitle();
    }

    public Library getLibrary() {
        return library;
    }

    // Setters --------------------------------------------------------------------------
    private void setType(ReportType newType) {
        this.type = newType;
    }

    // Methods --------------------------------------------------------------------------

    /**
     * Method that tries to generate a .txt report file based on the situation. The file
     * will be stored in the root directory.
     *
     * @return true on success and false on failure.
     */
    public boolean generateReport(Library library) {
        // The report's 3 building blocks.
        String title;
        String headers;
        String content;

        // Checking for the report type.
        switch (this.type) {
            case USER_ACTIVITY:
                // Getting the library's lists of members.
                LinkedList<User> users = library.getUsers();
                LinkedList<LibraryStaff> staffMembers = library.getStaff();

                // Iterating over the members and their loans/reserves.
                Iterator<User> userIterator = users.iterator();
                Iterator<LibraryStaff> staffIterator = staffMembers.iterator();

                content = "--------------- INFO ---------------\n" + "USER LOANS:\n";

                while(userIterator.hasNext()) {
                    User currentUser = userIterator.next();
                    LinkedList<Loan> currentUserLoans = currentUser.getLoans();
                    Iterator<Loan> loanIterator = currentUserLoans.iterator();

                    content += "--------------------\n" + "USER: " + currentUser.getName() +
                            " " + currentUser.getSurname() + "\n" + "MEMBER ID: " + currentUser.getMemberId() +
                            "\n";
                }

                break;

            case ITEM_USAGE:

                break;

            case FINES_AND_PAYMENT:

                break;

            case ITEM_AVAILABILITY:

                break;

            case USER_STATISTICS:

                break;

            case POPULAR_ITEMS:

                break;
        }

        // Creating the Report File
        try {
            FileWriter writer = new FileWriter(this.reportTitle + ".txt");
            writer.write(""); // Strings will go here,
            writer.close();
            System.out.println("Report file generated successfully.");
            return true;
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            return false;
        }
    }
}
