package com.parking.service;

import com.parking.enums.VehicleType;
import com.parking.model.ParkingTicket;

public interface BillingService {

    public static int calculateBill(ParkingTicket ticket, VehicleType vehicleType)
    {
        int costPerHour=0;
        switch(vehicleType)
        {
            case TWO_WHEELER:{
                costPerHour=5;
                break;
            }
            case THREE_WHEELER:{
                costPerHour=10;
                break;
            }
            case FOUR_WHEELER:{
                costPerHour=15;
                break;
            }
            // handle default/error case
        }
        int hours=calculateHours(ticket.getArrivalTime());
        return hours*costPerHour;
    }
    private static int calculateHours(long time)
    {
        return (int)(System.currentTimeMillis()-time)/(1000*60*60);
    }
}
