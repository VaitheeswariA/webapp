package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;

public class BoardingPoint {
	private int boardingPointId;
	private int routeId;
	private int boardingOrder;
	private String boardingPlace;
	private LocalTime boardingTime;
	
	public BoardingPoint()
	{
		
	}
	
	public BoardingPoint(ResultSet resultSet) {
		
		try {
			this.setBoardingPointId(resultSet.getInt(1));
			this.setRouteId(resultSet.getInt(2));
			this.setBoardingOrder(resultSet.getInt(3));
			this.setBoardingPlace(resultSet.getString(4));
			this.setBoardingTime(resultSet.getTime(5).toLocalTime());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public int getBoardingPointId() {
		return boardingPointId;
	}

	public void setBoardingPointId(int boardingPointId) {
		this.boardingPointId = boardingPointId;
	}

	public LocalTime getBoardingTime() {
		return boardingTime;
	}

	public void setBoardingTime(LocalTime boardingTime) {
		this.boardingTime = boardingTime;
	}

	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	public int getBoardingOrder() {
		return boardingOrder;
	}
	public void setBoardingOrder(int boardingOrder) {
		this.boardingOrder = boardingOrder;
	}
	public String getBoardingPlace() {
		return boardingPlace;
	}
	public void setBoardingPlace(String boardingPlace) {
		this.boardingPlace = boardingPlace;
	}
	
	
}
