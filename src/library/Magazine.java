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
    private String conservation;
    private int monthOfPublication;
    private int ncpysAvailable;
    
    // Constructor ----------------------------------------------------------------------
    public Magazine(String title, String digitalContent, String author, String publishingCompany, String genre, String summary,
                    String cover, String magazineName, String section, String conservation, String whereToFound, int yearOfPublication, 
                    int monthOfPublication, int ncpysAvailable, int ncpys, int id) {
        super(title, digitalContent, author, publishingCompany, genre, summary, cover, whereToFound, yearOfPublication, ncpys, id);
        this.maganizeName = magazineName;
        this.section = section;
        this.conservation = conservation;
        this.monthOfPublication = monthOfPublication;
        this.ncpysAvailable = ncpysAvailable;
    }

    // Getters -------------------------------------------------------------------------
    public String getMagazineName() {
        return maganizeName;
    }

    public String getSection() {
        return section;
    }

    public String getConservation() {
        return conservation;
    }

    public int getMonthOfPublication() {
        return monthOfPublication;
    }

    public int ncpysAvailable() {
        return ncpysAvailable;
    }

    // Setters -------------------------------------------------------------------------
    public void setSection(String newSection) {
        this.section = newSection;
    }

    public void setConservation(String newConservation) {
        this.conservation = newConservation;
    }

    public void setMonthOfPublication(int newMonthOfPublication) {
        this.monthOfPublication = newMonthOfPublication;
    }

    public void setNcpysAvailable(int newNcpysAvailable) {
        this.ncpysAvailable = newNcpysAvailable;
    }
    // Methods --------------------------------------------------------------------------

}