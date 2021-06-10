package com.mindtree.DAO;

import java.util.ArrayList;

import com.mindtree.entity.Flight;

public interface FlightDAO {
	public void insertFlight(Flight flight);
	ArrayList<Flight> getFlights(String source, String destination);
}
