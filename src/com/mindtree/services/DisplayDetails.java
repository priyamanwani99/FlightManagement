package com.mindtree.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.mindtree.DAOImplementation.FlightDAOImpl;
import com.mindtree.DAOImplementation.PassengerDAOImpl;
import com.mindtree.entity.Flight;
import com.mindtree.entity.Passenger;
import com.mindtree.exception.InvalidInputException;

public class DisplayDetails {

	static Scanner sc = new Scanner(System.in);
	static FlightDAOImpl flightDaoImp = new FlightDAOImpl();
	static PassengerDAOImpl PassengerDaoImp = new PassengerDAOImpl();
	public static void displayFlights() {
		System.out.println("Enter source");
		String source = sc.next();
		System.out.println("Enter destination");
		String destination = sc.next();
		ArrayList<Flight> flights = flightDaoImp.getFlights(source, destination);
		System.out.println("Available flights between" +source+ "and" +destination);
		for (Flight flight : flights) {
			System.out.println("=============================================");
			System.out.println(flight.getFlightName());
			System.out.println("=============================================");
		}
	}

	public static void displayPassengers() throws InvalidInputException {
		System.out.println("Enter source");
		String source = sc.next();
		System.out.println("Enter the destination");
		String destination = sc.next();
		ArrayList<Flight> flights = flightDaoImp.getFlights(source, destination);
		if (flights.size() != 0) {
			for (Flight flight : flights) {
				ArrayList<Passenger> passengers = PassengerDaoImp.getPassengers(flight.getFlightName());
				System.out.println("================================================");
				System.out.println("Flight name " + flight.getFlightName());
				for (Passenger passenger : passengers) {
					System.out.println(passenger.getLastName().charAt(0) + ". " + passenger.getFirstName());
				}
				System.out.println("================================================");
			}
		} else {
			try {
				 throw new SQLException();
		    } catch (SQLException sqlException) {
		      sqlException.printStackTrace();
		      throw new InvalidInputException("Invalid input" +sqlException.getMessage());
		     
		    }
			}
			
		}
	}


