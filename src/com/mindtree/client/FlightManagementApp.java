package com.mindtree.client;

import java.util.Scanner;

import com.mindtree.exception.InvalidInputException;
import com.mindtree.services.CreateFlight;
import com.mindtree.services.CreatePassengers;
import com.mindtree.services.Display;
import com.mindtree.services.DisplayDetails;

public class FlightManagementApp {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		byte choice = 0;
		boolean flag = true;
		do {
			Display.displayMenu();
			choice = input.nextByte();
			switch (choice) {
			case 1:
				CreateFlight.createFlight();
				break;
			case 2:
				CreatePassengers.bookTicket();
				break;
			case 3:
				try {
					DisplayDetails.displayPassengers();
				} catch (InvalidInputException e) {
					System.out.println("something went wrong " + e.getMessage());
				}
				break;
			case 4:
				System.out.println("Thank you for visiting Airlines App!");
				System.exit(0);
				flag = false;

			default:
				break;
			}
		} while (flag);
	}
}
