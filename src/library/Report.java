package library;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import people.User;
import people.LibraryStaff;
import library.Multimedia;

/**
 * Class that represents a report, which stores info on the Library's operation.
 *
 * @author Matheus Reato (RA: 244088), Caio Taishi (RA: 242908).
 */

public class Report {
    // Private Attributes ---------------------------------------------------------------
    private String type;                                  // Loan, Renewal or Suspension.
    private User user;                                                  // If applicable.
    private LibraryStaff libStaff;                                      // If applicable.
    private LocalDate emissionDate;
    private Multimedia item;

    // Constructor (User) ---------------------------------------------------------------
    public Report(String type, User user, Multimedia item) {
        this.type = type;
        this.user = user;
        this.libStaff = null;
        this.item = item;
        this.emissionDate = LocalDate.now();
    }

    // Constructor (Staff Member) -------------------------------------------------------
    public Report(String type, LibraryStaff libStaff, Multimedia item) {
        this.type = type;
        this.user = null;
        this.libStaff = libStaff;
        this.emissionDate = LocalDate.now();
        this.item = item;
    }

    // Getters --------------------------------------------------------------------------
    public String getReportType() {
        return type;
    }

    public User getUser() {
        return user;
    }

    public LibraryStaff getLibStaff() {
        return libStaff;
    }

    // Setters --------------------------------------------------------------------------
    private void setType(String newType) {
        this.type = newType;
    }

    private void setUser(User newUser) {
        this.user = newUser;
    }

    private void setLibStaff(LibraryStaff newLibStaff) {
        this.libStaff = newLibStaff;
    }

    // Methods --------------------------------------------------------------------------

    /**
     * Method that generates a .txt report file based on the situation. The file will be
     * stored in the root directory.
     *
     * @return true on success and false on failure.
     */
    public boolean generateReport() {
        // Creating the title.
        String title = "---------- " + this.type + " Report ----------\n";

        // Creating the headers.
        String headers = "";

        if (this.libStaff == null) {
            headers = "User: " + this.user.getName() + " " + this.user.getSurname() +
                    "\nMember ID: " + this.user.getMemberId() + "\nUsername: " +
                    this.user.getUsername() + "\nEmission Date: " + this.emissionDate + "\n";
        }
        else {
            headers = "User: " + this.libStaff.getName() + this.libStaff.getSurname() +
                    "\nStaff ID: " + this.libStaff.getStaffId() + "\nUsername: " +
                    this.libStaff.getUsername() + "\nEmission Date: " + this.emissionDate + "\n";
        }

        headers += "---------- Info ----------\n";

        // Creating the content.
        String content = "";

        if (this.type.equals("Loan")) {
            content = "User/Staff member has borrowed item '" + this.item.getTitle() + "'.";
        }
        else if (this.type.equals("Renewal")) {
            content = "User/Staff member has renewed item '" + this.item.getTitle() + "' for 7 days.";
        }
        else {
            content = "User/Staff member has been suspended for 2 days.";
        }

        try {
            FileWriter writer = new FileWriter(this.type +"Report.txt");
            writer.write(title + headers + content);
            writer.close();
            System.out.println("Report file generated successfully.");
            return true;
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            return false;
        }
    }
}
