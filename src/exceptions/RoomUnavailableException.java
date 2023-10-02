package exceptions;

import models.library.infrastructure.Room;

public class RoomUnavailableException extends Exception {
    // Private Attributes ---------------------------------------------------------------
    private final Room room;

    // Constructor ----------------------------------------------------------------------
    public RoomUnavailableException(String message, Room room) {
        super(message);
        this.room = room;
    }

    // Getters --------------------------------------------------------------------------
    public Room getRoom() {
        return room;
    }
}
