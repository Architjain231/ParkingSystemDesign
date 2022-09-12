package com.parking.model;

public class ParkingDirector extends Person {

    public ParkingDirector(String name) {
        this.name = name;
    }

    public void assignManager(ParkingManager manager,ParkingLot lot)
    {
        lot.setManager(manager);
        manager.assignLot(lot);
    }
}
