package com.parking.model;

import com.parking.enums.VehicleType;
import com.parking.service.ParkingLotInitializationService;
import com.parking.service.SpotIdGenerator;

import java.util.*;

public class ParkingLot {
    private static final int DEFAULT_PARKING_SIZE = 10;
    private int lotId;
    private int parkingSize;
    private final Map<VehicleType, HashSet<ParkingSpot>> spotsPerVehicleTypeAvailable;
    private final Map<String,ParkingSpot>  vehicleNumVsSpot;
    private ParkingManager manager;
    ParkingLot(int lotId) {
        this(DEFAULT_PARKING_SIZE,lotId);
    }

    ParkingLot(int parkingSize,int lotId) {
        this.parkingSize = parkingSize;
        spotsPerVehicleTypeAvailable = new HashMap<>();
        vehicleNumVsSpot=new HashMap<>();
        this.lotId=lotId;
        initializeLot();
    }

    public int getLotId() {
        return lotId;
    }

    public void setLotId(int lotId) {
        this.lotId = lotId;
    }

    public int getParkingSize() {
        return parkingSize;
    }

    public ParkingManager getManager() {
        return manager;
    }

    public Map<VehicleType, HashSet<ParkingSpot>> getSpotsPerVehicleTypeAvailable() {
        return spotsPerVehicleTypeAvailable;
    }
    public Map<String, ParkingSpot> getVehicleNumVsSpot() {
        return vehicleNumVsSpot;
    }

    public void setManager(ParkingManager manager) {
        this.manager = manager;
    }

    private void initializeLot() {
        ParkingLotInitializationService service = new ParkingLotInitializationService(parkingSize);

        for (Map.Entry<VehicleType, Integer> entry : service.getSpotsPerVehicleType().entrySet()) {
            VehicleType type = entry.getKey();
            int spotCount = entry.getValue();
             while(spotCount-->0)
             {
                 spotsPerVehicleTypeAvailable.put(type,spotsPerVehicleTypeAvailable.getOrDefault(type,new HashSet<>()));
                HashSet<ParkingSpot> setOfSpots=spotsPerVehicleTypeAvailable.get(type);
                setOfSpots.add((new ParkingSpot(SpotIdGenerator.generate(),type)));
                 spotsPerVehicleTypeAvailable.put(type,setOfSpots);
             }
        }
    }
}
