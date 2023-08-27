package library;

import java.time.LocalDate;

/**
 * Class that represents an audible content mp3/mp4 belonging to a library.
 *
 * @author Matheus Reato (RA: 244088), Caio Taishi (RA: 242908).
 */

public class AudibleContent extends Multimedia {
    // Private Attributes ---------------------------------------------------------------
    private String authorName;
    private String section;
    private String genre;
    private String contentType;
    private String summary;

    // Constructor ----------------------------------------------------------------------
    public AudibleContent(String title, String digitalContent, String authorName, String section,
                String genre, String contentType, String summary, int ncpys, int id) {
        super(title, digitalContent, ncpys, id);
        this.authorName = authorName;
        this.section = section;
        this.genre = genre;
        this.contentType = contentType;
        this.summary = summary;
    }

    // Getters --------------------------------------------------------------------------
    public String getAuthorName() {
        return authorName;
    }

    public String getSection() {
        return section;
    }

    public String getGenre() {
        return genre;
    }

    public String getcontentType() {
        return contentType;
    }

    public String getSummary() {
        return summary;
    }

    // Setters --------------------------------------------------------------------------
    public void setSection(String newSection) {
        this.section = newSection;
    }

    public void setGenre(String newGenre) {
        this.genre = newGenre;
    }

    public void setSummary(String newSummary) {
        this.summary = newSummary;
    }
    // Methods --------------------------------------------------------------------------
}
