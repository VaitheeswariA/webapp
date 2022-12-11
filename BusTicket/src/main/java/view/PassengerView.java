package view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.UserController;
import controller.Utils;
import model.Passenger;

public class PassengerView{
	
	public Passenger login(String emailId, String password) {
		Connection connect=Utils.getInstance().dataBaseConnection();
		Passenger passengerDetails=null;
		try {
			PreparedStatement preparedStatement=connect.prepareStatement("SELECT * FROM Passenger WHERE EmailId=? AND Password=?");
			preparedStatement.setString(1, emailId);
			preparedStatement.setString(2, password);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
			{
				passengerDetails=new Passenger();
				passengerDetails.setPassengerId(resultSet.getInt(1));
				passengerDetails.setName(resultSet.getString(2));
				passengerDetails.setEmailId(resultSet.getString(3));
				passengerDetails.setPassword(resultSet.getString(4));
				passengerDetails.setMobileNumber(resultSet.getString(5));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return passengerDetails;
	}
	
	public void passengerPage(Passenger passengerDetails)
	{
		System.out.println("Choose any choice \n1.Search Bus \n2.My bookings \n3.Book ticket \n4.My account \n5.Exit");
	}
}
