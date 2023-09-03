package library;

import people.users.User;
import people.staff.LibraryStaff;

import java.util.LinkedList;

/**
 * Class that represents a library belonging to an institute of the university.
 *
 * @author Matheus Reato (RA: 244088), Caio Taishi (RA: 242908).
 */

public class Library {
    // Private Attributes ---------------------------------------------------------------
    private String institute;
    private LinkedList<Book> books;  // Might be substituted by a min-heap in the future.
    private LinkedList<AudibleContent> audibles;
    private LinkedList<Magazine> magazines;
    private LinkedList<DailyNews> dailyNews;
    private LinkedList<Journal> journals;
    private LinkedList<LibraryStaff> libStaff;
    private LinkedList<User> users;

    // Constructor ----------------------------------------------------------------------
    public Library(String institute) {
        this.institute = institute;
        this.books = new LinkedList<>();
        this.audibles = new LinkedList<>();
        this.magazines = new LinkedList<>();
        this.dailyNews = new LinkedList<>();
        this.journals = new LinkedList<>();
        this.libStaff = new LinkedList<>();
        this.users = new LinkedList<>();
    }

    // Getters --------------------------------------------------------------------------
    public String getInstitute() {
        return institute;
    }

    public LinkedList<Book> getBooks() {
        return books;
    }

    public LinkedList<AudibleContent> getAudibles() {
        return audibles;
    }

    public LinkedList<Magazine> getMagazines() {
        return magazines;
    }

    public LinkedList<DailyNews> getDailyNews() {
        return dailyNews;
    }

    public LinkedList<Journal> getJournals() {
        return journals;
    }

    public LinkedList<LibraryStaff> getStaff() {
        return libStaff;
    }

    public LinkedList<User> getUsers() {
        return users;
    }

    // Setters --------------------------------------------------------------------------
    private void setInstitute(String newInstitute) {
        this.institute = newInstitute;
    }

    // Methods -------------------------------------------------------------------------

    /**
     * Method to try and add a Book to the Library.
     *
     * @param newBook Book to be added.
     * @return true on succcess and false on failure.
     */
    public boolean addBook(Book newBook) {
        if (!this.books.contains(newBook)) {
            this.books.add(newBook);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Method to try and remove a Book from the Library.
     *
     * @param bookToRemove Book to be removed.
     * @return true on success and false on failure.
     */
    public boolean removeBook(Book bookToRemove) {
        if (this.books.contains(bookToRemove)) {
            this.books.remove(bookToRemove);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Method to try and add an AudibleContent to the Library.
     *
     * @param newAudible AudibleContent to be added.
     * @return true on succcess and false on failure.
     */
    public boolean addAudible(AudibleContent newAudible) {
        if (!this.audibles.contains(newAudible)) {
            this.audibles.add(newAudible);
            return true;
        }
        else {
            return false;
        }
    }

        /**
     * Method to try and remove an AudibleContent from the Library.
     *
     * @param audibleToRemove AudibleContent to be removed.
     * @return true on success and false on failure.
     */
    public boolean removeAudible(Book audibleToRemove) {
        if (this.audibles.contains(audibleToRemove)) {
            this.audibles.remove(audibleToRemove);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Method to try and add a Magazine to the Library.
     *
     * @param newMagazine Magazine to be added.
     * @return true on succcess and false on failure.
     */
    public boolean addMagazine(Magazine newMagazine) {
        if (!this.magazines.contains(newMagazine)) {
            this.magazines.add(newMagazine);
            return true;
        }
        else {
            return false;
        }
    }

        /**
     * Method to try and remove a Magazine from the Library.
     *
     * @param magazineToRemove Magazine to be removed.
     * @return true on success and false on failure.
     */
    public boolean removeMagazine(Magazine magazineToRemove) {
        if (this.magazines.contains(magazineToRemove)) {
            this.magazines.remove(magazineToRemove);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Method to try and add a DailyNews to the Library.
     *
     * @param newDailyNews DailyNews to be added.
     * @return true on succcess and false on failure.
     */
    public boolean addDailyNews(DailyNews newDailyNews) {
        if (!this.dailyNews.contains(newDailyNews)) {
            this.dailyNews.add(newDailyNews);
            return true;
        }
        else {
            return false;
        }
    }

        /**
     * Method to try and remove a DailyNews from the Library.
     *
     * @param dailyNewsToRemove DailyNews to be removed.
     * @return true on success and false on failure.
     */
    public boolean removeNews(DailyNews dailyNewsToRemove) {
        if (this.dailyNews.contains(dailyNewsToRemove)) {
            this.dailyNews.remove(dailyNewsToRemove);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Method to try and add a Journal to the Library.
     *
     * @param newJournal Journal to be added.
     * @return true on succcess and false on failure.
     */
    public boolean addJournal(Journal newJournal) {
        if (!this.journals.contains(newJournal)) {
            this.journals.add(newJournal);
            return true;
        }
        else {
            return false;
        }
    }

        /**
     * Method to try and remove a Journal from the Library.
     *
     * @param journalToRemove Journal to be removed.
     * @return true on success and false on failure.
     */
    public boolean removeJournal(Journal journalToRemove) {
        if (this.journals.contains(journalToRemove)) {
            this.journals.remove(journalToRemove);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Method to try and add a new staff member to a Library's staff list.
     *
     * @param staffMember The new staff member to be added to the list.
     * @return true on success and false on failure.
     */
    public boolean addStaff(LibraryStaff staffMember) {
        if (!this.libStaff.contains(staffMember)) {
            this.libStaff.add(staffMember);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Method to try and remove a staff member from a Library's staff.
     *
     * @param staffMember The staff member to be removed.
     * @return true on success and false on failure.
     */
    public boolean removeStaff(LibraryStaff staffMember) {
        if (this.libStaff.contains(staffMember)) {
            this.libStaff.remove(staffMember);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Method to try and add a new user to a Library's user list.
     *
     * @param newUser User to be added.
     * @return true on success and false on failure.
     */
    public boolean addUser(User newUser) {
        if(!this.users.contains(newUser)) {
            this.users.add(newUser);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Method to try and remove a user from a Library's user list.
     *
     * @param user User to be removed.
     * @return true on success and false on failure.
     */
    public boolean removeUser(User user) {
        if(this.users.contains(user)) {
            this.users.remove(user);
            return true;
        }
        else {
            return false;
        }
    }
}
