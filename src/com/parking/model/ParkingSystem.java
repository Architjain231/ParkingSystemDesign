package com.parking.model;

import com.parking.model.ParkingManager;
import com.parking.service.LotIdGenerator;

import java.util.ArrayList;
import java.util.List;

public class ParkingSystem {
    private static final int DEFAULT_NUM_OF_LOTS=1;
    private int numOfLots;
    private ParkingDirector director;
    private final List<ParkingLot> listOfLots;
    public ParkingSystem()
    {
        this(DEFAULT_NUM_OF_LOTS);
    }
    public ParkingSystem(ParkingDirector director)
    {
        this(DEFAULT_NUM_OF_LOTS);
        this.director=director;
    }
    public ParkingSystem(int numOfLots)
    {
        this.numOfLots=numOfLots;
        listOfLots=new ArrayList<>(numOfLots);
        initializeParking();
    }
    private void initializeParking()
    {
        for(int i=1;i<=numOfLots;i++)
        {
            listOfLots.add(new ParkingLot(LotIdGenerator.generate()));
        }
    }
    public void addLot()
    {
        listOfLots.add(new ParkingLot(LotIdGenerator.generate()));
    }

    public ParkingDirector getDirector() {
        return director;
    }

    public void setDirector(ParkingDirector director) {
        this.director = director;
    }

    public List<ParkingLot> getListOfLots() {
        return listOfLots;
    }
}
