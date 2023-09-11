package library;

import java.time.LocalDate;

/**
 * Class that represents a book belonging to a library.
 *
 * @author Matheus Reato (RA: 244088), Caio Taishi (RA: 242908).
 */

public class Book extends Multimedia {
    // Private Attributes ---------------------------------------------------------------
    private String authorSurname; // Author's name has been separated to ease user input.
    private String section;
    private String conservation;
    private int edition;
    private int isbn;

    // Eletrônic book
    private String compatibleApps;
    private int ncpysAvailable;
    private int nLicenses;

    // Constructor ----------------------------------------------------------------------
    public Book(String title, String digitalContent, String author, String publishingCompany,
                String genre, String summary, String cover, String authorName, String authorSurname,
                String section, String whereToFound, String conservation, String compatibleApps,
                int edition, int yearOfPublication, int ncpys, int id, int isbn, int ncpysAvailable,
                int nLicenses) {
        super(title, digitalContent, author, publishingCompany, genre, summary, cover, whereToFound,
                yearOfPublication, ncpys, id);

        this.authorSurname = authorSurname;
        this.section = section;        
        this.conservation = conservation;
        this.compatibleApps = compatibleApps;
        this.edition = edition;
        this.isbn = isbn;
        this.ncpysAvailable = ncpysAvailable;
        this.nLicenses = nLicenses;
    }

    // Getters --------------------------------------------------------------------------
    public String getAuthorSurname() {
        return authorSurname;
    }

    public String getSection() {
        return section;
    }

    public String getConservation() {
        return conservation;
    }

    public String getCompatibleApps() {
        return compatibleApps;
    }

    public int getEdition() {
        return edition;
    }

    public int getIsbn() {
        return isbn;
    }

    public int getNcpysAvailable() {
        return ncpysAvailable;
    }

    public int getNLicenses() {
        return nLicenses;
    }

    // Setters --------------------------------------------------------------------------
    public void setSection(String newSection) {
        this.section = newSection;
    }

    public void setConservation(String newConservation) {
        this.conservation = newConservation;
    }

    public void setCompatibleApps(String newCompatibleApps) {
        this.compatibleApps = newCompatibleApps;
    }

    public void setIsbn(int newIsbn) {
        this.isbn = newIsbn;
    }

    public void setNcpysAvailable(int newNcpysAvailable) {
        this.ncpysAvailable = newNcpysAvailable;
    }

    public void setNLicenses(int newNLicenses) {
        this.nLicenses = newNLicenses;
    }

    // Methods --------------------------------------------------------------------------
}
