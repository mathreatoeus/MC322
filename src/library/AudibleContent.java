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
    private String chapters;
    private String conservation;
    private String subtitles;
    private int length;
    private int ncpysAvailable;

    // Constructor ----------------------------------------------------------------------
    public AudibleContent(String title, String digitalContent, String author, String publishingCompany, String genre, String summary, 
                          String cover, String section, String contentType, String chapters, String conservation, String subtitles,
                          String whereToFound, int yearOfPublication, int ncpys, int id, int length, int ncpysAvailable) {
        super(title, digitalContent, author, publishingCompany, genre, summary, cover, whereToFound, yearOfPublication, ncpys, id);
        this.section = section;
        this.contentType = contentType;
        this.chapters = chapters;
        this.conservation = conservation;
        this.subtitles = subtitles;
        this.length = length;
        this.ncpysAvailable = ncpysAvailable;
    }

    // Getters --------------------------------------------------------------------------
    public String getSection() {
        return section;
    }

    public String getcontentType() {
        return contentType;
    }

    public String getChapters() {
        return chapters;
    }

    public String getConservation() {
        return conservation;
    }

    public String getSubtitles() {
        return subtitles;
    }

    public int getNcpysAvailable() {
        return ncpysAvailable;
    }

    public int getLength() {
        return length;
    }

    // Setters --------------------------------------------------------------------------
    public void setSection(String newSection) {
        this.section = newSection;
    }

    public void setChapters(String newChapters) {
        this.chapters = newChapters;
    }

    public void setConservation(String newConservation) {
        this.conservation = newConservation;
    }

    public void setSubtitles(String newSubtitles) {
        this.subtitles = newSubtitles;
    }

    public void setNcpysAvailable(int newNcpysAvailable) {
        this.ncpysAvailable = newNcpysAvailable;
    }

    public void setLength(int newLength) {
        this.length = newLength;
    }

    // Methods --------------------------------------------------------------------------
}
