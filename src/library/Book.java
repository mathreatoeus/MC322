package library;

import java.time.LocalDate;

/**
 * Class that represents a book belonging to a library.
 *
 * @author Matheus Reato (RA: 244088), Caio Taishi (RA: 242908).
 * @version 1.0
 */

public class Book extends Multimedia {
    // Private Attributes ---------------------------------------------------------------
    private String authorName;
    private String authorSurname; // Author's name has been separated to ease user input.
    private String section;
    private String genre;
    private int edition;

    // Constructor ----------------------------------------------------------------------
    public Book(String title, String digitalContent, String authorName, String authorSurname, String section,
                String genre, int edition, int ncpys, int id) {
        super(title, digitalContent, npcys, id);
        this.authorName = authorName;
        this.authorSurname = authorSurname;
        this.section = section;
        this.genre = genre;
        this.edition = edition;
    }

    // Getters --------------------------------------------------------------------------
    public String getAuthorName() {
        return authorName;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public String getSection() {
        return section;
    }

    public String getGenre() {
        return genre;
    }

    public int getEdition() {
        return edition;
    }

    public int getId() {
        return id;
    }

    // Setters --------------------------------------------------------------------------
    public void setSection(String newSection) {
        this.section = newSection;
    }

    public void setGenre(String newGenre) {
        this.genre = newGenre;
    }

    // Methods --------------------------------------------------------------------------
}
