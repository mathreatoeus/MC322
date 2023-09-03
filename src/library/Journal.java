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
    private int monthOfPublication;  
    
    // Constructor ----------------------------------------------------------------------
    public Journal(String title, String digitalContent, String author, String publishingCompany, String genre, String summary, String cover, String section,
                String knowledgeArea, int monthOfPublication, int yearOfPublication, int ncpys, int id) {
        super(title, digitalContent, author, publishingCompany, genre, summary, cover, yearOfPublication, ncpys, id);
        this.section = section;
        this.knowledgeArea = knowledgeArea;
        this.publisher = publisher;
        this.month = monthOfPublication;

    }

    // Getters -------------------------------------------------------------------------
    public String getSection() {
        return section;
    }

    public String getKnowledgeArea() {
        return knowledgeArea;
    }

    public int getMonthOfPublication() {
        return monthOfPublication;
    }

    // Setters -------------------------------------------------------------------------
    public void setSection(String newSection) {
        this.section = newSection;
    }

    // Methods --------------------------------------------------------------------------
}