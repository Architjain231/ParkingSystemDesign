package com.parking.model;

import com.parking.enums.VehicleType;
import com.parking.exception.ParkingIsFullException;
import com.parking.service.BillingService;
import com.parking.service.ManagerIdGenerator;
import com.parking.service.TicketGeneratorService;

import java.util.*;

public class ParkingManager extends Person{

    private int managerId;
    private ParkingLot lot;
    public ParkingManager(String name)
    {
        this.name=name;
        managerId= ManagerIdGenerator.generate();
    }
    public void assignLot(ParkingLot lot)
    {
        this.lot=lot;
    }
    public int getManagerId()
    {
        return managerId;
    }
    public ParkingTicket park(Vehicle vehicle) throws InterruptedException, ParkingIsFullException {
     boolean isAvailable=this.isParkingSpaceAvailable(vehicle.getVehicleType());

      if(!isAvailable) {
          throw new ParkingIsFullException(vehicle.getVehicleType());
      }
          ParkingTicket ticket= TicketGeneratorService.generateTicket(vehicle.getVehicleNumber());
          System.out.println("Parking vehicle Number: "+vehicle.getVehicleNumber());
          Thread.sleep(1500);
         Map<VehicleType,HashSet<ParkingSpot>> spotsPerVehicleTypeAvailable= lot.getSpotsPerVehicleTypeAvailable();
          Map<String,ParkingSpot> vehicleNumVsSpot= lot.getVehicleNumVsSpot();
          HashSet<ParkingSpot> set=spotsPerVehicleTypeAvailable.get(vehicle.getVehicleType());
         ParkingSpot spot= set.iterator().next();
          set.remove(spot);
        spotsPerVehicleTypeAvailable.put(vehicle.getVehicleType(),set);
          vehicleNumVsSpot.put(vehicle.getVehicleNumber(),spot);
          System.out.println("Parked Vehicle Number : "+vehicle.getVehicleNumber());
          System.out.println("---------------------------------------------------------------------------------------");
         return ticket;
    }
    public void unPark(ParkingTicket ticket,VehicleType type) throws InterruptedException {
       int payableAmount= BillingService.calculateBill(ticket,type);
        System.out.println("Amount Paid By: "+ ticket.getVehicleNumber()+" --> "+payableAmount);
        Thread.sleep(1500);
        Map<String,ParkingSpot> vehicleNumVsSpot= lot.getVehicleNumVsSpot();
        lot.getSpotsPerVehicleTypeAvailable().get(type).add(vehicleNumVsSpot.get(ticket.getVehicleNumber()));
        vehicleNumVsSpot.remove(ticket.getVehicleNumber());
        System.out.println("Vehicle Unparked : "+ticket.getVehicleNumber());
    }

    public boolean isParkingSpaceAvailable(VehicleType vehicleType)
    {
        Map<VehicleType, HashSet<ParkingSpot>> spotsPerVehicleTypeAvailable=lot.getSpotsPerVehicleTypeAvailable();
        if(spotsPerVehicleTypeAvailable.containsKey(vehicleType))
        {
            if(spotsPerVehicleTypeAvailable.get(vehicleType).size()>0)
            {
                return true;
            }
        }
        else
        {
            System.out.println(" Such vehicle type is now allowed yet");
        }
        return false;
    }
}
