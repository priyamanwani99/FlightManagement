package com.mindtree.DAO;


import java.util.ArrayList;

import com.mindtree.entity.Passenger;

public interface PassengerDAO {
	public void insertPassenger(Passenger passenger);
	public  ArrayList<Passenger> getPassengers(String flightName);
}
