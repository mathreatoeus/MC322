package library.management;

/**
 * Class that represents the reservation of a Library room by a user or member of staff.
 *
 * @author Matheus Reato (RA: 244088), Caio Taishi (RA: 242908).
 */

import java.util.ArrayList;
import java.time.LocalDateTime;
import library.room.*;
import people.Person;

public abstract class RoomReservation {
    // **********************************************************************************
    public static class IndividualRoomReserve {
        // Private Attributes ***************************************
        private final Room room;
        private final Person ambassador;
        private final ArrayList<Person> users;
        private LocalDateTime startDateTime;
        private LocalDateTime finishDateTime;

        // Constructor **********************************************
        public IndividualRoomReserve(Room room, Person ambassador, LocalDateTime startDateTime,
                                     LocalDateTime finishDateTime) {
            this.room = room;
            this.ambassador = ambassador;
            this.users = new ArrayList<>();
            this.startDateTime = startDateTime;
            this.finishDateTime = finishDateTime;

            (this.users).add(this.ambassador);
            (this.room).addIndividualReserve(this);
        }

        // Getters **************************************************
        public Room getRoom () {
            return room;
        }

        private Person getAmbassador() {
            return ambassador;
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
    public static class GroupRoomReserve {
        private final Room room;
        private final Person ambassador;
        private final ArrayList<Person> users;
        private LocalDateTime startDateTime;
        private LocalDateTime finishDateTime;

        // Constructor **********************************************
        public GroupRoomReserve(Room room, Person ambassador, LocalDateTime startDateTime,
                                     LocalDateTime finishDateTime) {
            this.room = room;
            this.ambassador = ambassador;
            this.users = new ArrayList<>();
            this.startDateTime = startDateTime;
            this.finishDateTime = finishDateTime;

            (this.users).add(this.ambassador);
            (this.room).addGroupReserve(this);
        }

        // Getters **************************************************
        public Room getRoom () {
            return room;
        }

        private Person getAmbassador() {
            return ambassador;
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
    public static class SilentRoomReserve {
        private final Room room;
        private final Person ambassador;
        private final ArrayList<Person> users;
        private LocalDateTime startDateTime;
        private LocalDateTime finishDateTime;

        // Constructor **********************************************
        public SilentRoomReserve(Room room, Person ambassador, LocalDateTime startDateTime,
                                     LocalDateTime finishDateTime) {
            this.room = room;
            this.ambassador = ambassador;
            this.users = new ArrayList<>();
            this.startDateTime = startDateTime;
            this.finishDateTime = finishDateTime;

            (this.users).add(this.ambassador);
            (this.room).addSilentReserve(this);
        }

        // Getters **************************************************
        public Room getRoom () {
            return room;
        }

        private Person getAmbassador() {
            return ambassador;
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
    public static class MultimediaRoomReserve {
        private final Room room;
        private final Person ambassador;
        private final ArrayList<Person> users;
        private LocalDateTime startDateTime;
        private LocalDateTime finishDateTime;

        // Constructor **********************************************
        public MultimediaRoomReserve(Room room, Person ambassador, LocalDateTime startDateTime,
                                     LocalDateTime finishDateTime) {
            this.room = room;
            this.ambassador = ambassador;
            this.users = new ArrayList<>();
            this.startDateTime = startDateTime;
            this.finishDateTime = finishDateTime;

            (this.users).add(this.ambassador);
            (this.room).addMultimediaReserve(this);
        }

        // Getters **************************************************
        public Room getRoom () {
            return room;
        }

        private Person getAmbassador() {
            return ambassador;
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
