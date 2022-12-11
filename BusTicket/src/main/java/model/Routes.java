package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

public class Routes {
	private int routeId;
	private int scheduleId;
	private String startPlace;
	private String endPlace;
	private LocalDate travelStartDate; 
	private LocalDate travelEndDate; 
	private LocalTime travelStartTime;
	private LocalTime travelEndTime;
	private double travelFare;
	private double timeToReach;
	
	public Routes()
	{
		
	}
	public Routes(ResultSet resultSet) {
		try {
			this.setRouteId(resultSet.getInt(1));
			this.setScheduleId(resultSet.getInt(2));
			this.setStartPlace(resultSet.getString(3));
			this.setEndPlace(resultSet.getString(4));
			this.setTravelStartDate(resultSet.getDate(5).toLocalDate());
			this.setTravelEndDate(resultSet.getDate(6).toLocalDate());
			this.setTravelStartTime(resultSet.getTime(7).toLocalTime());
			this.setTravelEndTime(resultSet.getTime(8).toLocalTime());
			this.setTravelFare(resultSet.getDouble(9));
			this.setTimeToReach(resultSet.getDouble(10));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}
	public LocalDate getTravelStartDate() {
		return travelStartDate;
	}
	public void setTravelStartDate(LocalDate travelStartDate) {
		this.travelStartDate = travelStartDate;
	}
	public LocalDate getTravelEndDate() {
		return travelEndDate;
	}
	public void setTravelEndDate(LocalDate travelEndDate) {
		this.travelEndDate = travelEndDate;
	}
	public LocalTime getTravelStartTime() {
		return travelStartTime;
	}
	public void setTravelStartTime(LocalTime travelStartTime) {
		this.travelStartTime = travelStartTime;
	}
	public LocalTime getTravelEndTime() {
		return travelEndTime;
	}
	public void setTravelEndTime(LocalTime travelEndTime) {
		this.travelEndTime = travelEndTime;
	}
	public Double getTravelFare() {
		return travelFare;
	}
	public void setTravelFare(Double travelFare) {
		this.travelFare = travelFare;
	}
	public double getTimeToReach() {
		return timeToReach;
	}
	public void setTimeToReach(double timeToReach) {
		this.timeToReach = timeToReach;
	}
	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	public String getStartPlace() {
		return startPlace;
	}
	public void setStartPlace(String startPlace) {
		this.startPlace = startPlace;
	}
	public String getEndPlace() {
		return endPlace;
	}
	public void setEndPlace(String endPlace) {
		this.endPlace = endPlace;
	}
	
	
}
