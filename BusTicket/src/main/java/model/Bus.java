package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Bus {
	private int busId;
	private int travelsId;
	private String busNumber;
	private String busType;
	private int seatTypeId;
	private int totalseats;
	private int rating;
	
	public Bus()
	{
		
	}
	
	public Bus(ResultSet resultSet) {
		try {
			this.setBusId(resultSet.getInt(1));
			this.setTravelsId(resultSet.getInt(2));
			this.setBusNumber(resultSet.getString(3));
			this.setBusType(resultSet.getString(4));
			this.setSeatTypeId(resultSet.getInt(5));
			this.setTotalseats(resultSet.getInt(6));
			this.setRating(resultSet.getInt(7));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getBusId() {
		return busId;
	}
	public void setBusId(int busId) {
		this.busId = busId;
	}
	public int getTravelsId() {
		return travelsId;
	}
	public void setTravelsId(int travelsId) {
		this.travelsId = travelsId;
	}
	public String getBusNumber() {
		return busNumber;
	}
	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}
	public String getBusType() {
		return busType;
	}
	public void setBusType(String busType) {
		this.busType = busType;
	}
	public int getSeatTypeId() {
		return seatTypeId;
	}
	public void setSeatTypeId(int seatTypeId) {
		this.seatTypeId = seatTypeId;
	}
	public int getTotalseats() {
		return totalseats;
	}
	public void setTotalseats(int totalseats) {
		this.totalseats = totalseats;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
}
