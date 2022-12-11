package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TravelAdmin {
	private int travelId;
	private String emailId;
	private String travelsName;
	private String password;
	
	public TravelAdmin()
	{
		
	}
	
	public TravelAdmin(ResultSet resultSet) {
		try {
			this.setTravelId(resultSet.getInt(1));
			this.setEmailId(resultSet.getString(2));
			this.setTravelsName(resultSet.getString(3));
			this.setPassword(resultSet.getString(4));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public int getTravelId() {
		return travelId;
	}
	public void setTravelId(int travelId) {
		this.travelId = travelId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getTravelsName() {
		return travelsName;
	}
	public void setTravelsName(String travelsName) {
		this.travelsName = travelsName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
