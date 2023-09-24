package models.library.management;

import java.util.ArrayList;
import java.time.LocalDateTime;

import models.library.infrastructure.Room;
import models.people.Person;

public abstract class RoomReservation {
    // **********************************************************************************

    /**
     * Cass that represents a reservation of an Individual Room.
     */
    public static class IndividualRoomReserve extends Reserve {
        // Private Attributes ***************************************
        private final Room room;
        private RoomReservationStatus status;
        private final ArrayList<Person> users;
        private LocalDateTime startDateTime;
        private LocalDateTime finishDateTime;

        // Constructor **********************************************
        public IndividualRoomReserve(Person ambassador, Room room, LocalDateTime startDateTime,
                                     LocalDateTime finishDateTime) {
            super(ambassador);
            this.room = room;
            status = RoomReservationStatus.PENDING;
            this.users = new ArrayList<>();
            this.startDateTime = startDateTime;
            this.finishDateTime = finishDateTime;

            (this.users).add(ambassador);
            (this.room).addIndividualReserve(this);
        }

        // Getters **************************************************
        public Room getRoom () {
            return room;
        }

        public RoomReservationStatus getStatus() {
            return status;
        }

        private ArrayList<Person> getUsers() {
            return users;
        }

        public LocalDateTime getStartDateTime() {
            return startDateTime;
        }

        public LocalDateTime getFinishDateTime() {
            return finishDateTime;
        }

        // Setters **************************************************
        private void setStatus(RoomReservationStatus newStatus) {
            this.status = newStatus;
        }

        private void setStartDateTime(LocalDateTime newStartDateTime) {
            this.startDateTime = newStartDateTime;
        }

        private void setFinishDateTime(LocalDateTime newFinishDateTime) {
            this.finishDateTime = newFinishDateTime;
        }

        // Methods **************************************************
        public void addUser(Person newUser) {
            (this.users).add(newUser);
        }
    }

    // **********************************************************************************

    /**
     * Clas that represents a reservation of a Group Room.
     */
    public static class GroupRoomReserve extends Reserve {
        private final Room room;
        private RoomReservationStatus status;
        private final ArrayList<Person> users;
        private LocalDateTime startDateTime;
        private LocalDateTime finishDateTime;

        // Constructor **********************************************
        public GroupRoomReserve(Room room, Person ambassador, LocalDateTime startDateTime,
                                     LocalDateTime finishDateTime) {
            super(ambassador);
            this.room = room;
            status = RoomReservationStatus.PENDING;
            this.users = new ArrayList<>();
            this.startDateTime = startDateTime;
            this.finishDateTime = finishDateTime;

            (this.users).add(ambassador);
            (this.room).addGroupReserve(this);
        }

        // Getters **************************************************
        public Room getRoom () {
            return room;
        }

        public RoomReservationStatus getStatus() {
            return status;
        }

        private ArrayList<Person> getUsers() {
            return users;
        }

        public LocalDateTime getStartDateTime() {
            return startDateTime;
        }

        public LocalDateTime getFinishDateTime() {
            return finishDateTime;
        }

        // Setters **************************************************
        private void setStatus(RoomReservationStatus newStatus) {
            this.status = newStatus;
        }

        private void setStartDateTime(LocalDateTime newStartDateTime) {
            this.startDateTime = newStartDateTime;
        }

        private void setFinishDateTime(LocalDateTime newFinishDateTime) {
            this.finishDateTime = newFinishDateTime;
        }

        // Methods **************************************************
        public void addUser(Person newUser) {
            (this.users).add(newUser);
        }
    }

    // **********************************************************************************

    /**
     * Class that represents a reservation of a Silent Room.
     */
    public static class SilentRoomReserve extends Reserve {
        private final Room room;
        private RoomReservationStatus status;
        private final ArrayList<Person> users;
        private LocalDateTime startDateTime;
        private LocalDateTime finishDateTime;

        // Constructor **********************************************
        public SilentRoomReserve(Room room, Person ambassador, LocalDateTime startDateTime,
                                     LocalDateTime finishDateTime) {
            super(ambassador);
            this.room = room;
            status = RoomReservationStatus.PENDING;
            this.users = new ArrayList<>();
            this.startDateTime = startDateTime;
            this.finishDateTime = finishDateTime;

            (this.users).add(ambassador);
            (this.room).addSilentReserve(this);
        }

        // Getters **************************************************
        public Room getRoom () {
            return room;
        }

        public RoomReservationStatus getStatus() {
            return status;
        }

        private ArrayList<Person> getUsers() {
            return users;
        }

        public LocalDateTime getStartDateTime() {
            return startDateTime;
        }

        public LocalDateTime getFinishDateTime() {
            return finishDateTime;
        }

        // Setters **************************************************
        private void setStatus(RoomReservationStatus newStatus) {
            this.status = newStatus;
        }

        private void setStartDateTime(LocalDateTime newStartDateTime) {
            this.startDateTime = newStartDateTime;
        }

        private void setFinishDateTime(LocalDateTime newFinishDateTime) {
            this.finishDateTime = newFinishDateTime;
        }

        // Methods **************************************************
        public void addUser(Person newUser) {
            (this.users).add(newUser);
        }
    }

    // **********************************************************************************

    /**
     * Class that represents a reservation of a Multimedia Room.
     */
    public static class MultimediaRoomReserve extends Reserve {
        private final Room room;
        private RoomReservationStatus status;
        private final ArrayList<Person> users;
        private LocalDateTime startDateTime;
        private LocalDateTime finishDateTime;

        // Constructor **********************************************
        public MultimediaRoomReserve(Room room, Person ambassador, LocalDateTime startDateTime,
                                     LocalDateTime finishDateTime) {
            super(ambassador);
            this.room = room;
            status = RoomReservationStatus.PENDING;
            this.users = new ArrayList<>();
            this.startDateTime = startDateTime;
            this.finishDateTime = finishDateTime;

            (this.users).add(ambassador);
            (this.room).addMultimediaReserve(this);
        }

        // Getters **************************************************
        public Room getRoom () {
            return room;
        }

        public RoomReservationStatus getStatus() {
            return status;
        }

        private ArrayList<Person> getUsers() {
            return users;
        }

        public LocalDateTime getStartDateTime() {
            return startDateTime;
        }

        public LocalDateTime getFinishDateTime() {
            return finishDateTime;
        }

        // Setters **************************************************
        private void setStatus(RoomReservationStatus newStatus) {
            this.status = newStatus;
        }

        private void setStartDateTime(LocalDateTime newStartDateTime) {
            this.startDateTime = newStartDateTime;
        }

        private void setFinishDateTime(LocalDateTime newFinishDateTime) {
            this.finishDateTime = newFinishDateTime;
        }

        // Methods **************************************************
        public void addUser(Person newUser) {
            (this.users).add(newUser);
        }
    }
}
