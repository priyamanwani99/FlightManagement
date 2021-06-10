package com.mindtree.DAOImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mindtree.DAO.PassengerDAO;
import com.mindtree.entity.Passenger;
import com.mindtree.utility.DBConnection;

public class PassengerDAOImpl implements PassengerDAO {

	static Connection connection = null;

	public void insertPassengers(Passenger passenger) {
		connection = DBConnection.getDBConnection();
		PreparedStatement pst = null;
		String query = "INSERT INTO passenger VALUES(?,?,?,?,?)";
		try {
			pst = connection.prepareStatement(query);
			pst.setString(1, passenger.getFirstName());
			pst.setString(2, passenger.getLastName());
			pst.setByte(3, passenger.getAge());
			pst.setString(4, passenger.getGender());
			pst.setString(5, passenger.getFlightName());
			if (pst.execute()) {
				System.out.println("Booked successfully");
			}
		} catch (SQLException e) {
			System.out.println("something went wrong while inserting passenger " + e.getMessage());
		} finally {
			try {
				pst.close();
				connection.close();
			} catch (SQLException e) {
				System.out.println("something went wrong while closing the connection " + e.getMessage());
			}
		}
	}

	public  ArrayList<Passenger> getPassengers(String flightName) {
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Passenger> passengers = new ArrayList<>();
		connection = DBConnection.getDBConnection();
		String query = "SELECT * FROM passenger WHERE flight_name='" + flightName + "'";
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				Passenger passenger = new Passenger();
				passenger.setFirstName(resultSet.getString(1));
				passenger.setLastName(resultSet.getString(2));
				passenger.setAge(resultSet.getByte(3));
				passenger.setGender(resultSet.getString(4));
				passenger.setFlightName(flightName);
				passengers.add(passenger);
			}
		} catch (SQLException e) {
			System.out.println("something went wrong while fetching the passengers " + e.getMessage());
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				System.out.println("something went wrong while closing the connection " + e.getMessage());
			}
		}
		return passengers;
	}

	@Override
	public void insertPassenger(Passenger passenger) {
		// TODO Auto-generated method stub
		
	}
}
