package com.parking.model;

import com.parking.enums.VehicleType;

public class ParkingSpot {
    private int spotNumber;
    private VehicleType vehicleType;
    ParkingSpot(int spotNumber,VehicleType vehicleType)
    {
        this.spotNumber=spotNumber;
        this.vehicleType=vehicleType;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
