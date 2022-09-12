package com.parking.model;

import com.parking.enums.VehicleType;

public class ParkingTicket {
    // only vehicle number
  private String vehicleNumber;
  private int lotId;
  private int spotId;
    private long arrivalTime;
    public ParkingTicket(String vehicleNumber)
    {
        this.vehicleNumber=vehicleNumber;
        arrivalTime=System.currentTimeMillis();
    }

    public long getArrivalTime() {
        return arrivalTime;
    }
    public String getVehicleNumber()
    {
        return vehicleNumber;
    }
}
