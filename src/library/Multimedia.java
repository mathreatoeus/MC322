package library;

import java.time.LocalDate;

/**
 * Class that represents a general multimedia. Superclass of Article, Book, Journal, 
 * Magazine, News.
 * 
 * @author Matheus Reato (RA: 244088), Caio Taishi (RA: 242908).
 */

abstract class Multimedia {
    // Private Attributes ---------------------------------------------------------------
    private String title;
    private String digitalContent; //Define content type
    private String author;
    private String publishingCompany;
    private String genre;
    private String summary;
    private String cover;
    private int yearOfPublication;
    private int ncpys;
    private int id;
    private boolean available;
    private int timesBorrowed;
    private LocalDate addedDate;

    // Constructor ----------------------------------------------------------------------
    public Multimedia(String title, String digitalContent, String author, String publishingCompany, String genre, String summary, 
                      String cover, int yearOfPublication, int ncpys, int id) {
        this.title = title;
        this.digitalContent = digitalContent;
        this.author = author;
        this.publishingCompany = publishingCompany;
        this.genre = genre;
        this.summary = summary;
        this.cover = cover;
        this.yearOfPublication = yearOfPublication;
        this.ncpys = ncpys;
        this.id = id;                 // Multimedia ID will be generated by hash in the future.
        this.available = true;
        this.timesBorrowed = 0;
        this.addedDate = LocalDate.now();
    }

    // Getters --------------------------------------------------------------------------
    public String getTitle() {
        return title;
    }

    public String getDigitalContent() {
        return digitalContent;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublishingCompany() {
        return publishingCompany;
    }

    public String getGenre() {
        return genre;
    }

    public String getSummary() {
        return summary;
    }

    public String getCover() {
        return cover;
    }

    public String getYearOfPublication() {
        return yearOfPublication;
    }

    public int getNcpys() {
        return ncpys;
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

    // Setters --------------------------------------------------------------------------
    public void setDigitalContent(String newDigitalContent) {
        this.digitalContent = newDigitalContent;
    }
    
    public void setAuthor(String newAuthor) {
        this.author = newAuthor;
    }

    public void setPublishingCompany(String newPublishingCompany) {
        this.publishingCompany = newPublishingCompany;
    }

    public void setGenre(String newGenre) {
        this.genre = newGenre;
    }

    public void setSummary(String newSummary) {
        this.summary = newSummary;
    }

    public void setCover(String newCover) {
        this.cover = newCover;
    }

    public void setYearOfPublication(int newYearOfPublication) {
        this.yearOfPublication = newYearOfPublication;
    }

    public void setNcpys(int newNcpys) {
        this.ncpys = newNcpys;
    }

    public void setId(int newId) {
        this.id = newId;
    }

    public void setAvailable(boolean newStatus) {
        this.available = newStatus;
    }

    // Methods --------------------------------------------------------------------------
    /**
     * Method to try and increment the amount of times a multimedia has been borrowed by a user
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
