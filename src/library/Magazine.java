package library;

/**
 * Class that represents a magazine belonging to a library. 
 *
 * @author Matheus Reato (RA: 244088), Caio Taishi (RA: 242908).
 */

public class Magazine extends Multimedia {
    // Private Attributes ---------------------------------------------------------------
    private String maganizeName;
    private String section;
    private String genre;
    private String publisher;
    private int year;
    private int month;
    
    // Constructor ----------------------------------------------------------------------
    public Magazine(String title, String digitalContent, String magazineName, String section,
                String genre, String publisher, int year, int month, int ncpys, int id) {
        super(title, digitalContent, ncpys, id);
        this.maganizeName = magazineName;
        this.section = section;
        this.genre = genre;
        this.publisher = publisher;
        this.year = year;
        this.month = month;
    }

    // Getters -------------------------------------------------------------------------
    public String getMagazineName() {
        return maganizeName;
    }

    public String getSection() {
        return section;
    }

    public String getGenre() {
        return genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    // Setters -------------------------------------------------------------------------
    public void setSection(String newSection) {
        this.section = newSection;
    }

    public void setGenre(String newGenre) {
        this.genre = newGenre;
    }

    public void setPublisher(String newPublisher) {
        this.publisher = newPublisher;
    }

    // Methods --------------------------------------------------------------------------

}