package models.library.content;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import models.library.management.Loan;
import models.library.management.Reserve;
import models.library.management.Comment;

public abstract class Item {
    // Private Attributes ---------------------------------------------------------------
    private final String title;
    private final LocalDate publicationDate;
    private final int numCopies;
    private final String id;
    private boolean available;
    private final int timesBorrowed;
    private final LocalDate additionDate;
    private Loan currentLoan;
    private final PriorityQueue<Reserve> reserves;
    private final ArrayList<Comment> comments;

    // Constructor ----------------------------------------------------------------------
    public Item(String title, LocalDate publicationDate, int numCopies) {
        this.title = title;
        this.publicationDate = publicationDate;
        this.numCopies = numCopies;
        this.id = generateId(title);
        this.available = true;
        this.timesBorrowed = 0;
        this.additionDate = LocalDate.now();
        this.currentLoan = null;
        this.reserves = new PriorityQueue<>(new ReservesComparator());
        this.comments = new ArrayList<>();
    }

    // Custom Comparator ----------------------------------------------------------------
    private static class ReservesComparator implements Comparator<Reserve> {
        @Override
        public int compare(Reserve reserve1, Reserve reserve2) {
            return reserve2.getPickupDate().compareTo(reserve1.getPickupDate());
        }
    }

    // Getters --------------------------------------------------------------------------
    public String getTitle() {
        return title;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public int getNumCopies() {
        return numCopies;
    }

    public String getId() {
        return id;
    }

    public boolean getAvailable() {
        return available;
    }

    public int getTimesBorrowed() {
        return timesBorrowed;
    }

    public LocalDate getAdditionDate() {
        return  additionDate;
    }

    public Loan getCurrentLoan() {
        return currentLoan;
    }

    public PriorityQueue<Reserve> getReserves() {
        return reserves;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    // Setters --------------------------------------------------------------------------
    public void setAvailable(boolean newStatus) {
        this.available = newStatus;
    }

    public void setCurrentLoan(Loan loan){
        this.currentLoan = loan;
    }

    // Methods --------------------------------------------------------------------------

    @Override
    public String toString() {
        return "Title: " + this.title + "\n" +
                "ID: " + this.id + "\n" +
                "Num of Copies: " + this.numCopies + "\n";
    }

    /**
     * Takes a title and hashes it using SHA-256 to generate a secure ID.
     *
     * @param title the item's title.
     * @return the hash (item's ID).
     */
    private String generateId(String title) {
        try {
            MessageDigest msgDigest = MessageDigest.getInstance(("SHA-256"));
            byte[] hashBytes = msgDigest.digest(title.getBytes());

            StringBuilder hexString = new StringBuilder();

            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);

                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            return "none";
        }
    }

    /**
     * @return the reserve with the latest pickupDate.
     */
    public Reserve pickLatestReserve() {
        return (this.reserves).peek();
    }

    /**
     * Adds a reserve to the reserve list.
     *
     * @param reserve reserve to add.
     */
    public void addReserve(Reserve reserve) {
        (this.reserves).add(reserve);
    }
}

