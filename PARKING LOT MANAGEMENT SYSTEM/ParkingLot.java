public class ParkingLot {
    private ParkingSlot[] parkingSlots;
    private CustomQueue entryQueue;
    private CustomStack exitStack;

    // Constructor
    public ParkingLot(int size) {
        parkingSlots = new ParkingSlot[size];
        for (int i = 0; i < size; i++) {
            parkingSlots[i] = new ParkingSlot(i + 1);
        }
        entryQueue = new CustomQueue(size);
        exitStack = new CustomStack(size);
    }

    // Add a vehicle (entry)
    public void addVehicle(String licenseNumber) {
        for (ParkingSlot slot : parkingSlots) {
            if (!slot.isOccupied) {
                slot.licenseNumber = licenseNumber;
                slot.isOccupied = true;
                System.out.println("Vehicle with license " + licenseNumber + " added to Slot " + slot.slotNumber);
                return;
            }
        }
        System.out.println("No available slots. Vehicle added to waiting queue.");
        entryQueue.enqueue(licenseNumber);
    }

    // Remove a vehicle (exit)
    public void removeVehicle(String licenseNumber) {
        for (ParkingSlot slot : parkingSlots) {
            if (slot.isOccupied && slot.licenseNumber.equals(licenseNumber)) {
                slot.isOccupied = false;
                exitStack.push(licenseNumber);
                System.out.println("Vehicle with license " + licenseNumber + " removed from Slot " + slot.slotNumber);

                // Check waiting queue
                if (!entryQueue.isEmpty()) {
                    String nextVehicle = entryQueue.dequeue();
                    slot.licenseNumber = nextVehicle;
                    slot.isOccupied = true;
                    System.out.println("Vehicle with license " + nextVehicle + " added to Slot " + slot.slotNumber);
                }
                return;
            }
        }
        System.out.println("Vehicle with license " + licenseNumber + " not found.");
    }

    // View parking lot status
    public void viewParkingStatus() {
        System.out.println("Parking Lot Status:");
        for (ParkingSlot slot : parkingSlots) {
            if (slot.isOccupied) {
                System.out.println("Slot " + slot.slotNumber + ": Occupied (License: " + slot.licenseNumber + ")");
            } else {
                System.out.println("Slot " + slot.slotNumber + ": Vacant");
            }
        }
    }

    // Search for a vehicle using Binary Search
    public void searchVehicle(String licenseNumber) {
        // Create an array of license numbers for occupied slots
        int count = 0;
        for (ParkingSlot slot : parkingSlots) {
            if (slot.isOccupied) count++;
        }

        String[] licenses = new String[count];
        int index = 0;
        for (ParkingSlot slot : parkingSlots) {
            if (slot.isOccupied) {
                licenses[index++] = slot.licenseNumber;
            }
        }

        // Sort the array using Quick Sort
        quickSort(licenses, 0, licenses.length - 1);

        // Perform Binary Search
        int result = binarySearch(licenses, licenseNumber, 0, licenses.length - 1);
        if (result == -1) {
            System.out.println("Vehicle with license " + licenseNumber + " not found.");
        } else {
            System.out.println("Vehicle with license " + licenseNumber + " is parked.");
        }
    }

    // Quick Sort
    private void quickSort(String[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(String[] arr, int low, int high) {
        String pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) < 0) {
                i++;
                String temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        String temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // Binary Search
    private int binarySearch(String[] arr, String key, int low, int high) {
        if (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid].equals(key)) return mid;

            if (arr[mid].compareTo(key) > 0) return binarySearch(arr, key, low, mid - 1);

            return binarySearch(arr, key, mid + 1, high);
        }
        return -1;
    }

    // View recently exited vehicles
    public void viewRecentlyExited() {
        System.out.println("Recently Exited Vehicles:");
        if (exitStack.isEmpty()) {
            System.out.println("No recent exits.");
            return;
        }
        while (!exitStack.isEmpty()) {
            System.out.println(exitStack.pop());
        }
    }
}