package library;

import java.time.LocalDate;

/**
 * Class that represents a general multimedia. Superclass of Article, Book, Journal, 
 * Magazine, News.
 * 
 * @author Matheus Reato (RA: 244088), Caio Taishi (RA: 242908).
 * @version 1.0
 */

abstract class Multimedia {
    // Private Attributes ---------------------------------------------------------------
    private String title;
    private String digitalContent; //Define content type
    private int ncpys;
    private int id;
    private boolean available;
    private int timesBorrowed;
    private LocalDate addedDate;

    // Constructor ----------------------------------------------------------------------
    public Multimedia(String title, String digitalContent, int ncpys, int id) {
        this.title = title;
        this.digitalContent = digitalContent;
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
    public void setDigitalContent(String digitalContent){
        this.digitalContent = digitalContent;
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
