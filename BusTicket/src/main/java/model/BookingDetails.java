package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

public class BookingDetails {
	private int ticketId;
	private int busId;
	private int routeId;
	private int passengerId;
	private LocalDate bookedDate;
	private LocalDate travelDate;
	private LocalTime boardingTime;
	private String boardingPoint;
	private String droppingPoint;
	private int ticketCount;
	private double ticketFare;
	private String bookingStatus;
	
	public BookingDetails(ResultSet resultSet) 
	{
		try {
			this.setTicketId(resultSet.getInt(1));
			this.setBusId(resultSet.getInt(2));
			this.setRouteId(resultSet.getInt(3));
			this.setPassengerId(resultSet.getInt(4));
			this.setBookedDate(resultSet.getDate(5).toLocalDate());
			this.setTravelDate(resultSet.getDate(6).toLocalDate());
			this.setBoardingTime(resultSet.getTime(7).toLocalTime());
			this.setBoardingPoint(resultSet.getString(8));
			this.setDroppingPoint(resultSet.getString(9));
			this.setTicketCount(resultSet.getInt(10));
			this.setTicketFare(resultSet.getDouble(11));
			this.setBookingStatus(resultSet.getString(12));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	public LocalTime getBoardingTime() {
		return boardingTime;
	}


	public void setBoardingTime(LocalTime boardingTime) {
		this.boardingTime = boardingTime;
	}

	public LocalDate getBookedDate() {
		return bookedDate;
	}
	public void setBookedDate(LocalDate bookedDate) {
		this.bookedDate = bookedDate;
	}

	public LocalDate getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}





	public String getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}


	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public int getBusId() {
		return busId;
	}
	public void setBusId(int busId) {
		this.busId = busId;
	}
	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	public int getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}
	public String getBoardingPoint() {
		return boardingPoint;
	}
	public void setBoardingPoint(String boardingPoint) {
		this.boardingPoint = boardingPoint;
	}
	public String getDroppingPoint() {
		return droppingPoint;
	}
	public void setDroppingPoint(String droppingPoint) {
		this.droppingPoint = droppingPoint;
	}
	public int getTicketCount() {
		return ticketCount;
	}
	public void setTicketCount(int ticketCount) {
		this.ticketCount = ticketCount;
	}
	public double getTicketFare() {
		return ticketFare;
	}
	public void setTicketFare(double ticketFare) {
		this.ticketFare = ticketFare;
	}
	
	
	
}
