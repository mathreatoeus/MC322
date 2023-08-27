package library;

import java.time.LocalDate;

/**
 * Class that represents an article belonging to a library.
 *
 * @author Matheus Reato (RA: 244088), Caio Taishi (RA: 242908).
 * @version 1.0
 */

    public class Artcile extends Multimedia {
    // Private Attributes ---------------------------------------------------------------
    private String section;
    private String knowledgeArea;
    private String publisher;
    private String educationalInstitution;
    private String country;
    private int year;
    private int month;
    
    // Constructor ----------------------------------------------------------------------
    public Magazine(String title, String digitalContent, String section,String knowledgeArea, String publisher, private String educationalInstitution,
                    String country, int year, int month, int ncpys, int id) {
        super(title, digitalContent, ncpys, id);
        this.section = section;
        this.knowledgeArea = knowledgeArea;
        this.publisher = publisher;
        this.year = year;
        this.month = month;

    }

    // Getters -------------------------------------------------------------------------
    public String getSection() {
        return section;
    }

    public String getKnowledgeArea() {
        return knowledgeArea;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getEducationalInstitution() {
        return educationalInstitution;
    }

    public String getCountry() {
        return country;
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

    public void setPublisher(String newPublisher) {
        this.publisher = newPublisher;
    }

    // Methods --------------------------------------------------------------------------
}