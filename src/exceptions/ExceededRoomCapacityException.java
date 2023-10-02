package exceptions;

import models.library.infrastructure.Room;

public class ExceededRoomCapacityException extends Exception {
    // Private Attributes ---------------------------------------------------------------
    private final int maxCapacity;

    // Constructor ----------------------------------------------------------------------
    public ExceededRoomCapacityException(String message, Room room) {
        super(message);
        this.maxCapacity = room.getMaxCapacity();
    }

    // Getters --------------------------------------------------------------------------
    public int getMaxCapacity() {
        return maxCapacity;
    }
}
