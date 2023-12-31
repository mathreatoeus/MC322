package models.library.management;

import java.util.ArrayList;

public class ReserveList<T extends Reserve> {
    // Private Attributes ---------------------------------------------------------------
    private final ArrayList<T> reservations;
    private int numReservations;

    // Constructor ----------------------------------------------------------------------
    public ReserveList() {
        this.reservations = new ArrayList<>();
        this.numReservations = 0;
    }

    // Getters --------------------------------------------------------------------------
    public ArrayList<T> getReservations() {
        return reservations;
    }

    public int getNumReservations() {
        return numReservations;
    }

    // Setters --------------------------------------------------------------------------
    private void setNumReservations(int numReservations) {
        this.numReservations = numReservations;
    }

    // Methods --------------------------------------------------------------------------
    public void addReservation(T reservation) {
        this.reservations.add(reservation);
    }
}
