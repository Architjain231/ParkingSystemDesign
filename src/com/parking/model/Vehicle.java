package com.parking.model;

import com.parking.enums.VehicleType;

public class Vehicle {
    private final String vehicleNumber;
    // init type
    private VehicleType vehicleType;

    public Vehicle(String vehicleNumber, VehicleType vehicleType)
    {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType=vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

}
