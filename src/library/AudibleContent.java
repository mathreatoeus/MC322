package library;

import java.time.LocalDate;

/**
 * Class that represents an audible content mp3/mp4 belonging to a library.
 *
 * @author Matheus Reato (RA: 244088), Caio Taishi (RA: 242908).
 */

public class AudibleContent extends Multimedia {
    // Private Attributes ---------------------------------------------------------------
    private String section;
    private String contentType;

    // Constructor ----------------------------------------------------------------------
    public AudibleContent(String title, String digitalContent, String author, String publishingCompany, String genre, String summary, 
                          String cover, String section, String contentType, int yearOfPublication, int ncpys, int id) {
        super(title, digitalContent, author, publishingCompany, genre, summary, cover, yearOfPublication, ncpys, id);
        this.section = section;
        this.contentType = contentType;
    }

    // Getters --------------------------------------------------------------------------
    public String getSection() {
        return section;
    }

    public String getcontentType() {
        return contentType;
    }

    // Setters --------------------------------------------------------------------------
    public void setSection(String newSection) {
        this.section = newSection;
    }

    // Methods --------------------------------------------------------------------------
}
