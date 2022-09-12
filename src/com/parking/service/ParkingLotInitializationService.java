package com.parking.service;

import com.parking.enums.VehicleType;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotInitializationService {
    private final int DEFAULT_PARKING_SIZE=10;
    private  Map<VehicleType,Integer> spotsPerVehicleType;
     private int parkingSize;
    public ParkingLotInitializationService()
    {
        this.parkingSize=DEFAULT_PARKING_SIZE;
        spotsPerVehicleType =new HashMap<>();
        spotsPerVehicleType.put(VehicleType.TWO_WHEELER,parkingSize/2);
        spotsPerVehicleType.put(VehicleType.FOUR_WHEELER,(parkingSize+1)/2);
    }
    public ParkingLotInitializationService(int parkingSize)
    {
        spotsPerVehicleType =new HashMap<>();
        this.parkingSize=parkingSize;
        spotsPerVehicleType.put(VehicleType.TWO_WHEELER,parkingSize/2);
        spotsPerVehicleType.put(VehicleType.FOUR_WHEELER,(parkingSize+1)/2);
    }
    public ParkingLotInitializationService(int parkingSize ,Map<VehicleType,Integer> spotsPerVehicleType)
    {
        this.spotsPerVehicleType =spotsPerVehicleType;
        this.parkingSize=parkingSize;
    }

    public Map<VehicleType, Integer> getSpotsPerVehicleType() {
        return spotsPerVehicleType;
    }
}
