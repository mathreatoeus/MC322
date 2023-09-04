package library;

import java.time.LocalDate;

/**
 * Class that represents a journal belonging to a library. 
 *
 * @author Matheus Reato (RA: 244088), Caio Taishi (RA: 242908).
 */

public class Journal extends Multimedia {
    // Private Attributes ---------------------------------------------------------------
    private String section;
    private String knowledgeArea;
    private String conservation;
    private int monthOfPublication;  
    private int ncpysAvailable;

    // Constructor ----------------------------------------------------------------------
    public Journal(String title, String digitalContent, String author, String publishingCompany, String genre, String summary, String cover, String section,
                String knowledgeArea, String whereToFound, String conservation, int monthOfPublication, int yearOfPublication, int ncpys, int id) {
        super(title, digitalContent, author, publishingCompany, genre, summary, cover, whereToFound, yearOfPublication, ncpys, id);
        this.section = section; 
        this.knowledgeArea = knowledgeArea;
        this.conservation = conservation;
        this.month = monthOfPublication;
        this.ncpysAvailable = ncpysAvailable;
    }

    // Getters -------------------------------------------------------------------------
    public String getSection() {
        return section;
    }

    public String getKnowledgeArea() {
        return knowledgeArea;
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

    public void setNcpysAvailable(int newNcpysAvailable) {
        this.ncpysAvailable = newNcpysAvailable;
    }

    // Methods --------------------------------------------------------------------------
}