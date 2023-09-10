package library.management;

import people.Person;
import library.management.equipment.Equipment;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Class that represents a room reserve in a library.
 *
 * @author Matheus Reato (RA: 244088), Caio Taishi (RA: 242908).
 */

public class RoomReserve {
    // Inner Classes --------------------------------------------------------------------
    // IndividualRoom Inner Class *******************************************************
    public static class IndividualRoom {
        // Private Attributes ***************************************
        private LocalDate reservedDate;
        private LocalTime start;
        private LocalTime finish;
        private final Person user;
        private final String roomNumber;
        private final boolean hasComputer;

        // Constructor **********************************************
        public IndividualRoom(LocalDate reservedDate, LocalTime start, LocalTime finish,
                              String roomNumber, Person user, boolean hasComputer) {
            this.user = user;

            if (!(this.user).getIsSuspended()) {
                this.reservedDate = reservedDate;
                this.start = start;
                this.finish = finish;
                this.roomNumber = roomNumber;
                this.hasComputer = hasComputer;
            }
            else {
                System.out.println("Sorry, it seems as the room is not currently available" +
                        "or you have been suspended. Therefore, the reservation cannot be completed.");

                this.reservedDate = null;
                this.start = null;
                this.finish = null;
                this.roomNumber = null;
                this.hasComputer = false;
            }
        }

        // Getters **************************************************
        public LocalDate getReservedDate() {
            return reservedDate;
        }

        public LocalTime getStart() {
            return start;
        }

        public LocalTime getFinish() {
            return finish;
        }

        public Person getUser() {
            return user;
        }

        public boolean getHasComputer() {
            return hasComputer;
        }

        // Setters **************************************************
        private void setReservedDate(LocalDate newDate) {
            this.reservedDate = newDate;
        }

        private void setStart(LocalTime newStart) {
            this.start = newStart;
        }

        private void setFinish(LocalTime newFinish) {
            this.finish = newFinish;
        }
    }

    // GroupRoom Inner Class ***********************************************************
    public static class GroupRoom {
        // Private Attributes ***************************************
        private LocalDate reservedDate;
        private LocalTime start;
        private LocalTime finish;
        private final Person user;
        private final String roomNumber;
        private final int maxPeople;
        private final boolean hasProjector;

        // Constructor **********************************************
        public GroupRoom(LocalDate reservedDate, LocalTime start, LocalTime finish,
                         Person user, String roomNumber, int maxPeople, boolean hasProjector) {
            this.user = user;

            if (!user.getIsSuspended()) {
                this.reservedDate = reservedDate;
                this.start = start;
                this.finish = finish;
                this.roomNumber = roomNumber;
                this.maxPeople = maxPeople;
                this.hasProjector = hasProjector;
            }
            else {
                System.out.println("Sorry, it seems as you have been suspended. Therefore, " +
                        "you are unable to complete the reservation.");

                this.reservedDate = null;
                this.start = null;
                this.finish = null;
                this.roomNumber = null;
                this.maxPeople = 0;
                this.hasProjector = false;
            }
        }

        // Getters **************************************************
        public LocalDate getReservedDate() {
            return reservedDate;
        }

        public LocalTime getStart() {
            return start;
        }

        public LocalTime getFinish() {
            return finish;
        }

        public Person getUser() {
            return user;
        }

        public String getRoomNumber() {
            return roomNumber;
        }

        public int getMaxPeople() {
            return maxPeople;
        }

        public boolean getHasProjector() {
            return hasProjector;
        }

        // Setters **************************************************
        private void setReservedDate(LocalDate newReservedDate) {
            this.reservedDate = newReservedDate;
        }

        private void setStart(LocalTime newStart) {
            this.start = newStart;
        }

        private void setFinish(LocalTime newFinish) {
            this.finish = newFinish;
        }
    }

    // SilentRoom Inner Class ***********************************************************
    public static class SilentRoom {
        // Private Attributes ***************************************
        private LocalDate reservedDate;
        private LocalTime start;
        private LocalTime finish;
        private final Person user;
        private final String roomNumber;
        private final int numOfSeats;
        private final boolean hasIndividualCubicle;

        // Constructor **********************************************
        public SilentRoom(LocalDate reservedDate, LocalTime start, LocalTime finish,
                          Person user, String roomNumber, int numOfSeats,
                          boolean hasIndividualCubicle) {
            this.user = user;

            if (!user.getIsSuspended()) {
                this.reservedDate = reservedDate;
                this.start = start;
                this.finish = finish;
                this.roomNumber = roomNumber;
                this.numOfSeats = numOfSeats;
                this.hasIndividualCubicle = hasIndividualCubicle;
            }
            else {
                System.out.println("Sorry, it seems as you have been suspended. Therefore, " +
                        "you are unable to complete the reservation.");

                this.reservedDate = null;
                this.start = null;
                this.finish = null;
                this.roomNumber = null;
                this.numOfSeats = 0;
                this.hasIndividualCubicle = false;
            }
        }

        // Getters **************************************************
        public LocalDate getReservedDate() {
            return reservedDate;
        }

        public LocalTime getStart() {
            return start;
        }

        public LocalTime getFinish() {
            return finish;
        }

        public Person getUser() {
            return user;
        }

        public String getRoomNumber() {
            return roomNumber;
        }

        public int getNumOfSeats() {
            return numOfSeats;
        }

        public boolean getHasIndividualCubicles() {
            return hasIndividualCubicle;
        }

        // Setters **************************************************
        private void setReservedDate(LocalDate newReservedDate) {
            this.reservedDate = newReservedDate;
        }

        private void setStart(LocalTime newStart) {
            this.start = newStart;
        }

        private void setFinish(LocalTime newFinish) {
            this.finish = newFinish;
        }
    }

    // MultimediaRoom Inner Class *******************************************************
    public static class MultimediaRoom {
        // Private Attributes ***************************************
        private LocalDate reservedDate;
        private LocalTime start;
        private LocalTime finish;
        private final Person user;
        private final String roomNumber;
        private final ArrayList<Equipment> equipmentPieces;

        // Constructor **********************************************
        public MultimediaRoom(LocalDate reservedDate, LocalTime start, LocalTime finish,
                              Person user, String roomNumber) {
            this.user = user;

            if (!user.getIsSuspended()) {
                this.reservedDate = reservedDate;
                this.start = start;
                this.finish = finish;
                this.roomNumber = roomNumber;
                this.equipmentPieces = new ArrayList<>();
            }
            else {
                System.out.println("Sorry, it seems as you have been suspended. Therefore, " +
                        "you are unable to complete the reservation.");

                this.reservedDate = null;
                this.start = null;
                this.finish = null;
                this.roomNumber = null;
                this.equipmentPieces = null;
            }
        }

        // Getters **************************************************
        public LocalDate getReservedDate() {
            return reservedDate;
        }

        public LocalTime getStart() {
            return start;
        }

        public LocalTime getFinish() {
            return finish;
        }

        public Person getUser() {
            return user;
        }

        public String getRoomNumber() {
            return roomNumber;
        }

        public ArrayList<Equipment> getEquipment() {
            return equipmentPieces;
        }

        // Setters **************************************************
        private void setReservedDate(LocalDate newReservedDate) {
            this.reservedDate = newReservedDate;
        }

        private void setStart(LocalTime newStart) {
            this.start = newStart;
        }

        private void setFinish(LocalTime newFinish) {
            this.finish = newFinish;
        }

        // Methods **************************************************

        /**
         * Method to add a new equipment piece to the equipment list.
         *
         * @param newEquipment the equipment piece to be added.
         */
        public void addEquipment(Equipment newEquipment) {
            (this.equipmentPieces).add(newEquipment);
        }
    }

}
