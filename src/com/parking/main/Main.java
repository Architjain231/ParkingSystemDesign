package com.parking.main;
import com.parking.enums.VehicleType;
import com.parking.exception.ParkingIsFullException;
import com.parking.model.*;

import java.util.*;
public class Main {
    public static void main(String args[]) throws ParkingIsFullException, InterruptedException {
        Scanner sc=new Scanner(System.in);
        ParkingDirector director=new ParkingDirector("Archit Jain");
        ParkingManager manager=new ParkingManager("Vandit Jain");

        ParkingSystem parkingSystem=new ParkingSystem(director);
        List<ParkingLot> listOfLots =parkingSystem.getListOfLots();
        ParkingLot lot= listOfLots.get(0);
        director.assignManager(manager,lot);
        Vehicle v1=new Vehicle("A", VehicleType.TWO_WHEELER);
        Vehicle v2=new Vehicle("B", VehicleType.FOUR_WHEELER);
        Vehicle v3=new Vehicle("C", VehicleType.TWO_WHEELER);
        Vehicle v4=new Vehicle("D", VehicleType.TWO_WHEELER);
        ParkingTicket t1=manager.park(v1);
        ParkingTicket t2=manager.park(v2);
        ParkingTicket t3=manager.park(v3);
        ParkingTicket t4=manager.park(v4);
        Thread.sleep(2000);
        manager.unPark(t1,VehicleType.TWO_WHEELER);
        manager.unPark(t2,VehicleType.FOUR_WHEELER);
        manager.unPark(t3,VehicleType.TWO_WHEELER);
        manager.unPark(t4,VehicleType.TWO_WHEELER);
    }
}
