package library;

import java.time.LocalDate;

/**
 * Class that represents a daily news belonging to a library. 
 *
 * @author Matheus Reato (RA: 244088), Caio Taishi (RA: 242908).
 */

public class DailyNews extends Multimedia {
    // Private Attributes ---------------------------------------------------------------
    private String dayOfWeek;
    private String conservation;
    private int monthOfPublication;
    private int dayOfPublication;
    private int ncpysAvailable;
    
    // Constructor ----------------------------------------------------------------------
    public DailyNews(String title, String digitalContent, String author, String publishingCompany, String genre, String summary, 
                     String cover, String dayOfWeek, String whereToFound, String conservation, int yearOfPublication, int ncpys, 
                     int monthOfPublication, int dayOfPublication, int id) {
        super(title, digitalContent, author, publishingCompany, genre, summary, cover, whereToFound, yearOfPublication, ncpys, id);
        this.dayOfWeek = dayOfWeek;
        this.conservation = conservation;
        this.monthOfPublication = monthOfPublication;
        this.dayOfPublication = dayOfPublication;
        this.ncpysAvailable = ncpysAvailable;

    }

    // Getters -------------------------------------------------------------------------
    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public String getConservation() {
        return conservation;
    }

    public int getMonthOfPublication() {
        return monthOfPublication;
    }

    public int getDayOfPublication() {
        return dayOfPublication;
    }

    public int ncpysAvailable() {
        return ncpysAvailable;
    }

    // Setters -------------------------------------------------------------------------
    public void setConservation(String newConservation) {
        this.conservation = newConservation;
    }

    public void setNcpysAvailable(int newNcpysAvailable) {
        this.ncpysAvailable = newNcpysAvailable;
    }
    // Methods --------------------------------------------------------------------------
}