package com.company;

public interface Storage {
    int getStorageCapacity();
    int TO_MB = 1024;
    int TO_KB = 1048576;

    default int getStorageCapacityMB() {
        return getStorageCapacity() * TO_MB;
    }

    default int getStorageCapacityKB() {
        return getStorageCapacity() * TO_KB;
    }
}
