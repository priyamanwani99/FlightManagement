package com.mindtree.DAOImplementation;



import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mindtree.DAO.FlightDAO;
import com.mindtree.entity.Flight;
import com.mindtree.utility.DBConnection;

public class FlightDAOImpl implements FlightDAO{


	static Connection connection = null;

	@Override
	public  void insertFlight(Flight flight) {
		PreparedStatement pst = null;
		connection = DBConnection.getDBConnection();
		String query = "INSERT INTO flight VALUES(?,?,?)";
		try {
			pst = connection.prepareStatement(query);
			pst.setString(1, flight.getFlightName());
			pst.setString(2, flight.getSource());
			pst.setString(3, flight.getDestination());
			if (pst.execute()) {
				System.out.println("Added successfully");
			}
		} catch (SQLException e) {
			System.out.println("something went wrong while inserting flight " + e.getMessage());
		} finally {
			try {
				pst.close();
				connection.close();
			} catch (SQLException e) {
				System.out.println("something went wrong while closing the connection " + e.getMessage());
			}
		}
	}

	public ArrayList<Flight> getFlights(String source, String destination) {
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Flight> flights = new ArrayList<>();
		connection = DBConnection.getDBConnection();
		String procedure = "call getFlightsBySrcAndDest('"+source+"','"+destination+"')";
		try {
			CallableStatement  cs = connection.prepareCall(procedure);
			resultSet = cs.executeQuery();
			while (resultSet.next()) {
				Flight flight = new Flight();
				flight.setFlightName(resultSet.getString(1));
				flight.setSource(resultSet.getString(2));
				flight.setDestination(resultSet.getString(3));
				flights.add(flight);
			}
		} catch (SQLException e) {
			System.out.println("something went wrong while fetching the flights data " + e.getMessage());
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				System.out.println("something went wrong while closing the connection " + e.getMessage());
			}
		}
		return flights;
	}
}
