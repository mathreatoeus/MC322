package models.library.infrastructure;

import java.util.ArrayList;

import java.time.LocalDateTime;

public class Room {
    // Private Attributes ---------------------------------------------------------------
    private final String roomNumber;
    private final RoomType type;
    private final int maxCapacity;
    private final ArrayList<Equipment.Informatics> informaticsEquipment;
    private final ArrayList<Equipment.AudiovisualEquipment> audiovisualEquipment;
    private final ArrayList<Equipment.PrintingEquipment> printingEquipment;
    private final ArrayList<LocalDateTime[]> reserves;             // {{Start , Finish}}.
    private boolean available;
    private final boolean hasComputer;
    private final boolean hasProjector;
    private final boolean hasIndividualCabin;

    // Constructor ----------------------------------------------------------------------
    public Room(String roomNumber, RoomType type, int maxCapacity, boolean hasComputer,
                boolean hasProjector, boolean hasIndividualCabin) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.maxCapacity = maxCapacity;
        this.informaticsEquipment = new ArrayList<>();
        this.audiovisualEquipment = new ArrayList<>();
        this.printingEquipment = new ArrayList<>();
        this.reserves = new ArrayList<>();
        this.available = true;
        this.hasComputer = hasComputer;
        this.hasProjector = hasProjector;
        this.hasIndividualCabin = hasIndividualCabin;
    }

    // Enums ----------------------------------------------------------------------------
    private enum RoomType {
        INDIVIDUAL, GROUP, SILENT, MULTIMEDIA
    }

    // Getters --------------------------------------------------------------------------
    public String getRoomNumber() {
        return roomNumber;
    }

    public RoomType getType() {
        return type;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public ArrayList<Equipment.Informatics> getInformaticsEquipment() {
        return informaticsEquipment;
    }

    public ArrayList<Equipment.AudiovisualEquipment> getAudiovisualEquipment() {
        return audiovisualEquipment;
    }

    public ArrayList<Equipment.PrintingEquipment> getPrintingEquipment() {
        return printingEquipment;
    }

    public ArrayList<LocalDateTime[]> getReserves() {
        return reserves;
    }

    public boolean getAvailable() {
        return available;
    }

    public boolean getHasComputer() {
        return hasComputer;
    }

    public boolean getHasProjector() {
        return hasProjector;
    }

    public boolean getHasIndividualCabin() {
        return hasIndividualCabin;
    }

    // Setters --------------------------------------------------------------------------
    public void setAvailable(boolean available) {
        this.available = available;
    }

    // Methods --------------------------------------------------------------------------
    public void addInformaticsEquipment(Equipment.Informatics newEquipment) {
        (this.informaticsEquipment).add(newEquipment);
    }

    public void addAudiovisualEquipment(Equipment.AudiovisualEquipment newEquipment) {
        (this.audiovisualEquipment).add(newEquipment);
    }

    public void addPrintingEquipment(Equipment.PrintingEquipment newEquipment) {
        (this.printingEquipment).add(newEquipment);
    }

    public void addIndividualReserve(RoomReservation.IndividualRoomReserve reserve) {
        LocalDateTime[] times = new LocalDateTime[2];
        times[0] = reserve.getStartDateTime();
        times[1] = reserve.getFinishDateTime();

        this.reserves.add(times);
    }

    public void addGroupReserve(RoomReservation.GroupRoomReserve reserve) {
        LocalDateTime[] times = new LocalDateTime[2];
        times[0] = reserve.getStartDateTime();
        times[1] = reserve.getFinishDateTime();

        this.reserves.add(times);
    }

    public void addSilentReserve(RoomReservation.SilentRoomReserve reserve) {
        LocalDateTime[] times = new LocalDateTime[2];
        times[0] = reserve.getStartDateTime();
        times[1] = reserve.getFinishDateTime();

        this.reserves.add(times);
    }

    public void addMultimediaReserve(RoomReservation.MultimediaRoomReserve reserve) {
        LocalDateTime[] times = new LocalDateTime[2];
        times[0] = reserve.getStartDateTime();
        times[1] = reserve.getFinishDateTime();

        this.reserves.add(times);
    }
}
