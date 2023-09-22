package models.library.content;

import java.time.LocalDate;
import java.util.ArrayList;

public class ReadingItem {
    // Enums -----------------------------------------------------------------------------
    public enum ReadingItemType {
        BOOK, EBOOK, DAILY_NEWS, JOURNAL, MAGAZINE
    }

    public enum ConservationState {
        GOOD, MEDIUM, BAD
    }

    // Static nested classes ------------------------------------------------------------
    public static class Book extends Item {
        // Private Attributes ***********************************************************
        private final ReadingItemType type;
        private final String isbn;
        private final String authorName;
        private final String authorSurname;
        private final byte edition;
        private ConservationState conservationState;
        private String location;
        private int numCopiesAvailable;  

        // Constructor ******************************************************************
        public Book(String title, LocalDate publicationDate, int numCopies, String isbn,
                    String authorName, String authorSurname, byte edition,
                    ConservationState conservationState, String location, int numCopiesAvailable) {
            super(title, publicationDate, numCopies, yearOfPublication, genre, synopsis, urlLinkForCover);
            this.type = ReadingItemType.BOOK;
            this.isbn = isbn;
            this.authorName = authorName;
            this.authorSurname = authorSurname;
            this.edition = edition;
            this.conservationState = conservationState;
            this.location = location;
            this.numCopiesAvailable = numCopiesAvailable;
        }

        // Getters **********************************************************************
        public ReadingItemType getType() {
            return type;
        }

        public String getIsbn() {
            return isbn;
        }

        public String getAuthorName() {
            return authorName;
        }

        public String getAuthorSurname() {
            return authorSurname;
        }

        public byte getEdition() {
            return edition;
        }

        public ConservationState getConservationState() {
            return conservationState;
        }

        public String getLocation() {
            return location;
        }

        public int getNumCopiesAvailable() {
            return numCopiesAvailable;
        }

        // Setters **********************************************************************
        public void setConservationState(ConservationState conservationState) {
            this.conservationState = conservationState;
        }

        public void setLocation(String newLocation) {
            this.location = newLocation;
        }

        public void setNumCopiesAvailable(int newNumCopiesAvailable) {
            this.numCopiesAvailable = newNumCopiesAvailable;
        }
    }

    public static class Ebook extends Item {
        // Private Attributes ***********************************************************
        private final ReadingItemType type;
        private final String authorFullName;
        private final String format;
        private byte numOflicenses;
        private String url;
        private final ArrayList<String> readingRequisites;
        private final String[] availabilityInterval;

        // Constructor ******************************************************************
        public Ebook(String title, LocalDate publicationDate, int numCopies, String authorFullName,
                     String format, byte numOfLicenses, String url, ArrayList<String> readingRequisites,
                     String[] availabilityInterval) {
            super(title, publicationDate, numCopies, yearOfPublication, genre, synopsis, urlLinkForCover);
            this.type = ReadingItemType.EBOOK;
            this.authorFullName = authorFullName;
            this.format = format;
            this.numOflicenses = numOfLicenses;
            this.url = url;
            this.readingRequisites = readingRequisites;
            this.availabilityInterval = availabilityInterval;
        }

        // Getters **********************************************************************
        public ReadingItemType getType() {
            return type;
        }

        public String getAuthorFullName() {
            return authorFullName;
        }

        public String getFormat() {
            return format;
        }

        public byte getNumOflicenses() {
            return numOflicenses;
        }

        public String getUrl() {
            return url;
        }

        public ArrayList<String> getReadingRequisites() {
            return readingRequisites;
        }

        public String[] getAvailabilityInterval() {
            return availabilityInterval;
        }

        // Setters **********************************************************************
        public void setNumOflicenses(byte newNumOflicenses) {
            this.numOflicenses = newNumOflicenses;
        }

        public void setUrl(String newUrl) {
            this.url = newUrl;
        }
    }

    public static class DailyNews extends Item {
        // Private Attributes ***********************************************************
        private final ReadingItemType type;
        private final String publisher;
        private String location; 
        private int numCopiesAvailable;  
        private ConservationState conservationState;

        // Constructor ******************************************************************
        public DailyNews(String title, LocalDate publicationDate, int numCopies,
                         String publisher, String location, int numCopiesAvailable, ConservationState conservationState) {
            super(title, publicationDate, numCopies, yearOfPublication, genre, synopsis, urlLinkForCover);
            this.type = ReadingItemType.DAILY_NEWS;
            this.publisher = publisher;
            this.location = location;
            this.numCopiesAvailable = numCopiesAvailable;
            this.conservationState = conservationState;
        }

        // Getters **********************************************************************
        public ReadingItemType getType() {
            return type;
        }

        public String getPublisher() {
            return publisher;
        }
        
        public String getLocation() {
            return location;
        }

        public String getNumCopiesAvailable() {
            return numCopiesAvailable;
        }

        public ConservationState getConservationState() {
            return conservationState;
        }
    }

        // Setters **********************************************************************
        public void setConservationState(ConservationState newConservationState) {
            this.conservationState = newConservationState;
        }

        public String setLocation(String newLocation) {
            this.location = newLocation;
        }  

        public String setNumCopiesAvailable(int newNumCopiesAvailable) {
            this.numCopiesAvailable = newNumCopiesAvailable;
        }

    public static class Journal extends Item {
        // Private Attributes ***********************************************************
        private final ReadingItemType type;
        private String section;
        private final String knowledgeArea;
        private ConservationState conservationState;
        private String location;
        private int numCopiesAvailable;

        // Constructor ******************************************************************
        public Journal(String title, LocalDate publicationDate, int numCopies, String section,
                       String knowledgeArea, ConservationState conservationState, String location, int numCopiesAvailable) {
            super(title, publicationDate, numCopies, yearOfPublication, genre, synopsis, urlLinkForCover);
            this.type = ReadingItemType.JOURNAL;
            this.section = section;
            this.knowledgeArea = knowledgeArea;
            this.conservationState = conservationState;
            this.location = location;
            this.numCopiesAvailable = numCopiesAvailable;
        }

        // Getters **********************************************************************
        public ReadingItemType getType() {
            return type;
        }

        public String getSection() {
            return section;
        }

        public String getKnowledgeArea() {
            return knowledgeArea;
        }

        public ConservationState getConservationState() {
            return conservationState;
        }

        public String getLocation() {
            return location;
        }

        public String getNumCopiesAvailable() {
            return numCopiesAvailable;
        }

        // Setters **********************************************************************
        private void setSection(String newSection) {
            this.section = newSection;
        }

        private void setConservationState(ConservationState newConservationState) {
            this.conservationState = newConservationState;
        }

        public String setLocation(String newLocation) {
            this.location = newLocation;
        }  

        public String setNumCopiesAvailable(int newNumCopiesAvailable) {
            this.numCopiesAvailable = newNumCopiesAvailable;
        }
    }

    public static class Magazine extends Item {
        // Private Attributes ***********************************************************
        private final ReadingItemType type;
        private String section;
        private ConservationState conservationState;
        private String location;
        private int numCopiesAvailable;

        // Constructor ******************************************************************
        public Magazine(String title, LocalDate publicationDate, int numCopies,
                        ReadingItemType type, String section, ConservationState conservationState, 
                        String location, int numCopiesAvailable) {
            super(title, publicationDate, numCopies, yearOfPublication, genre, synopsis, urlLinkForCover);
            this.type = ReadingItemType.MAGAZINE;
            this.section = section;
            this.conservationState = conservationState;
            this.location = location;
            this.numCopiesAvailable = numCopiesAvailable;

        }

        // Getters **********************************************************************
        public ReadingItemType getType() {
            return type;
        }

        public String getSection() {
            return section;
        }

        public ConservationState getConservationState() {
            return conservationState;
        }
        
        public String getLocation() {
            return location;
        }

        public String getNumCopiesAvailable() {
            return numCopiesAvailable;
        }

        // Setters **********************************************************************
        private void setSection(String newSection) {
            this.section = newSection;
        }

        private void setConservationState(ConservationState newConservationState) {
            this.conservationState = newConservationState;
        }

        public String setLocation(String newLocation) {
            this.location = newLocation;
        }  

        public String setNumCopiesAvailable(int newNumCopiesAvailable) {
            this.numCopiesAvailable = newNumCopiesAvailable;
        }  
    }
}
