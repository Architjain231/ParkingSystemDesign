package com.parking.service;

import com.parking.enums.VehicleType;
import com.parking.model.ParkingTicket;
import com.parking.model.Vehicle;

public class TicketGeneratorService {

    public static ParkingTicket generateTicket(String vehicleNumber)
    {
        return new ParkingTicket(vehicleNumber);
    }
}
