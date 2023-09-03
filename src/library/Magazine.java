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
    private int monthOfPublication;
    
    // Constructor ----------------------------------------------------------------------
    public Magazine(String title, String digitalContent, String author, String publishingCompany, String genre, String summary,
                    String cover, String magazineName, String section, String publisher, int yearOfPublication, 
                    int monthOfPublication, int ncpys, int id) {
        super(title, digitalContent, author, publishingCompany, genre, summary, cover, yearOfPublication, ncpys, id);
        this.maganizeName = magazineName;
        this.section = section;

    }

    // Getters -------------------------------------------------------------------------
    public String getMagazineName() {
        return maganizeName;
    }

    public String getSection() {
        return section;
    }

    public int getMonthOfPublication() {
        return monthOfPublication;
    }

    // Setters -------------------------------------------------------------------------
    public void setSection(String newSection) {
        this.section = newSection;
    }

    public void setMonthOfPublication(int newMonthOfPublication) {
        this.monthOfPublication = newMonthOfPublication;
    }

    // Methods --------------------------------------------------------------------------

}