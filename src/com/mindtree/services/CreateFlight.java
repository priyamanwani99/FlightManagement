package com.mindtree.services;

import java.util.Scanner;

import com.mindtree.DAOImplementation.FlightDAOImpl;
import com.mindtree.entity.Flight;

public class CreateFlight {

	static Scanner sc = new Scanner(System.in);
	static FlightDAOImpl flightDaoImp = new FlightDAOImpl();

	public static void createFlight() {
		System.out.println("Enter flight name");
		String flightName = sc.next();
		System.out.println("Enter the source");
		String source = sc.next();
		System.out.println("Enter the destination");
		String destination = sc.next();
		Flight flight = new Flight(flightName, source, destination);
		flightDaoImp.insertFlight(flight);
	}
}
