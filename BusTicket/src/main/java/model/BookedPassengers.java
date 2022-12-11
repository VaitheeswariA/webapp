package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookedPassengers {
	private int ticketId;
	private int seatNumber;
	private String passengerName;
	
	
	public BookedPassengers(ResultSet resultSet) {
		
		try {
			this.setTicketId(resultSet.getInt(1));
			this.setSeatNumber(resultSet.getInt(2));
			this.setPassengerName(resultSet.getString(3));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public int getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	
	
	
	
}
