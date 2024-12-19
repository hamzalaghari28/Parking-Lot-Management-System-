class ParkingSlot {
    int slotNumber;
    String licenseNumber;
    boolean isOccupied;

    public ParkingSlot(int slotNumber) {
        this.slotNumber = slotNumber;
        this.isOccupied = false;
        this.licenseNumber = null;
    }
}
