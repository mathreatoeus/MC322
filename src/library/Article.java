package library;

import java.time.LocalDate;

/**
 * Class that represents an article belonging to a library.
 *
 * @author Matheus Reato (RA: 244088), Caio Taishi (RA: 242908).
 * @version 1.0
 */

public class Article {
    // Private Attributes ---------------------------------------------------------------
    private String title;
    private String section;
    private String knowledgeArea;
    private String publisher;
    private String educationalInstitution;
    private String country;
    private int year;
    private int month;
    private int id;
    private int ncpys;
    private boolean available;
    private int timesBorrowed;
    private LocalDate addedDate;
    
    // Constructor ----------------------------------------------------------------------
    public Article(String title, String section,
                String knowledgeArea, String publisher, String educationalInstitution, String country, int year, int month, int id, int ncpys) {
        this.title = title;
        this.section = section;
        this.knowledgeArea = knowledgeArea;
        this.publisher = publisher;
        this.year = year;
        this.month = month;
        this.ncpys = ncpys;
        this.id = id;                // Book ID will be generated by hash in the future.
        this.available = true;
        this.timesBorrowed = 0;
        this.addedDate = LocalDate.now();

    }

    // Getters -------------------------------------------------------------------------
    public String getTitle() {
        return title;
    }

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

    public int getId() {
        return id;
    }

    public boolean getAvailable() {
        return available;
    }

    public int getTimesBorrowed() {
        return timesBorrowed;
    }

    public LocalDate getAddedDate() {
        return addedDate;
    }

    // Setters -------------------------------------------------------------------------

    public void setSection(String newSection) {
        this.section = newSection;
    }

    public void setPublisher(String newPublisher) {
        this.publisher = newPublisher;
    }

    public void setId(int newId) {
        this.id = newId;
    }

    public void setAvailable(boolean newStatus) {
        this.available = newStatus;
    }

    // Methods --------------------------------------------------------------------------
    /**
     * Method to try and increment the amount of times a magazine has been borrowed by a user
     * or member of staff upon lending it.
     *
     * @return true on success and false on failure.
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