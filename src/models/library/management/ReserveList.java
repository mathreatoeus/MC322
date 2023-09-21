package models.library.management;

import java.util.ArrayList;
import models.library.management.Reserve;
import models.library.infrastructure.RoomReservation;
import models.library.infrastructure.RoomReservationStatus;
import models.people.Person;

public class ReserveList<T> {
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
    public <T> boolean makeReservation(T objectToReserve, Person user) {
        // Reservation logic will go here...
        return true;
    }
}
