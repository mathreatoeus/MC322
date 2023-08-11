package library;

/**
 * Class that represents a book belonging to a library.
 *
 * @author Matheus Reato (RA: 244088).
 * @version 1.0
 */

public class Book {
    // Private Attributes ---------------------------------------------------------------
    private String title;
    private String authorName;
    private String authorSurname;   // Author's name has been separated to ease user input.
    private String section;
    private String genre;
    private byte edition;
    private int id;
    private boolean available;
    private int timesBorrowed;

    // Constructor ----------------------------------------------------------------------
    public Book(String title, String authorName, String authorSurname, String section,
                String genre, byte edition, int id, boolean available) {
        this.title = title;
        this.authorName = authorName;
        this.authorSurname = authorSurname;
        this.section = section;
        this.genre = genre;
        this.edition = edition;
        this.id = id;
        this.available = available;
        this.timesBorrowed = 0;
    }

    // Getters --------------------------------------------------------------------------
    public String getTitle() {
        return title;
    }

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

    public byte getEdition() {
        return edition;
    }

    public int getId() {
        return id;
    }

    public boolean getAvailable() {
        return available;
    }

    public int getTimesBorrowed() {
        return timesBorrowed;
    }

    // Setters --------------------------------------------------------------------------
    public void setSection(String newSection) {
        this.section = newSection;
    }

    public void setGenre(String newGenre) {
        this.genre = newGenre;
    }

    public void setId(int newId) {
        this.id = newId;
    }

    public void setAvailable(boolean newStatus) {
        this.available = newStatus;
    }

    // Methods --------------------------------------------------------------------------
    /**
     * Method to try and increment the amount of times a book has been borrowed by a user
     * or member of staff upon lending it.
     *
     * @return true on success and false on failure
     */
    public boolean incrementTimesBorrowed() {
        if (this.available) {
            this.timesBorrowed++;
            return true;
        }
        else {
            return false;
        }
    }
}
