package com.parking.exception;

import com.parking.enums.VehicleType;

public class ParkingIsFullException extends Exception{
    public ParkingIsFullException(VehicleType type)
    {
        super("No Parking Available for "+String.valueOf(type));
    }
}
