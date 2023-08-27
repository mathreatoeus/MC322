package library;

import java.time.LocalDate;

/**
 * Class that represents a daily news belonging to a library. 
 *
 * @author Matheus Reato (RA: 244088), Caio Taishi (RA: 242908).
 * @version 1.0
 */

    public class DailyNews extends Multimedia {
    // Private Attributes ---------------------------------------------------------------
    private String publisher;
    private String dayOfWeek;
    private int year;
    private int month;
    private int day;
    
    // Constructor ----------------------------------------------------------------------
    public DailyNews(String title, String digitalContent, String publisher, String dayOfWeek, 
                    int year, int ncpys, int month, int day, int id) {
        super(title, digitalContent, ncpys, id);
        this.publisher = publisher;
        this.dayOfWeek = dayOfWeek;
        this.year = year;
        this.month = month;
        this.day = day;

    }

    // Getters -------------------------------------------------------------------------
    public String getPublisher() {
        return publisher;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    // Setters -------------------------------------------------------------------------
    public void setSection(String newSection) {
        this.section = newSection;
    }

    public void setGenre(String newGenre) {
        this.genre = newGenre;
    }

    public void setPublisher(String newPublisher) {
        this.publisher = newPublisher;
    }

    // Methods --------------------------------------------------------------------------
}