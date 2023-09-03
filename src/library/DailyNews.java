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
    private int monthOfPublication;
    private int dayOfPublication;
    
    // Constructor ----------------------------------------------------------------------
    public DailyNews(String title, String digitalContent, String author, String publishingCompany, String genre, String summary, 
                     String cover, String dayOfWeek, int yearOfPublication, int ncpys, int monthOfPublication, int dayOfPublication,
                     int id) {
        super(title, digitalContent, author, genre, summary, cover, yearOfPublication, ncpys, id);
        this.dayOfWeek = dayOfWeek;
        this.month = monthOfPublication;
        this.day = dayOfPublication;

    }

    // Getters -------------------------------------------------------------------------
    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public int getMonthOfPublication() {
        return monthOfPublication;
    }

    public int getDayOfPublication() {
        return dayOfPublication;
    }

    // Setters -------------------------------------------------------------------------

    // Methods --------------------------------------------------------------------------
}