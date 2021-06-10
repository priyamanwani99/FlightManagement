package com.mindtree.services;
import java.util.Scanner;

import com.mindtree.DAOImplementation.FlightDAOImpl;
import com.mindtree.DAOImplementation.PassengerDAOImpl;
import com.mindtree.entity.Passenger;

public class CreatePassengers {
	
	static Scanner sc=new Scanner(System.in);
	static PassengerDAOImpl PassengerDaoImp = new PassengerDAOImpl();
		public static void bookTicket() {
			System.out.println("Enter the flight name from the list");
			String flightName = sc.next();
			System.out.println("Enter first name");
			String firstName = sc.next();
			System.out.println("Enter last name");
			String lastName =sc.next();
			System.out.println("Enter age");
			byte age = sc.nextByte();
			System.out.println("Enter gender");
			String gender = sc.next();
			Passenger passenger = new Passenger(firstName, lastName, age, gender, flightName);
			PassengerDaoImp.insertPassengers(passenger);
		}
}
