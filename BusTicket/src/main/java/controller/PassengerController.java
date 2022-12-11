package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import model.BoardingPoint;
import model.BookedPassengers;
import model.BookingDetails;
import model.Bus;
import model.BusDetail;
import model.Passenger;
import model.PassengerTicketDetails;
import model.Routes;

public class PassengerController {
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
	public boolean signUp(String name,String emailId,String password,String mobileNumber)
	{
		Connection connect=Utils.getInstance().dataBaseConnection();
		int rowsAffected=0;
		try {
			PreparedStatement preparedStatement=connect.prepareStatement("INSERT INTO Passenger (Name,EmailId,Password,MobileNumber) VALUES (?,?,?,?)");
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, emailId);
			preparedStatement.setString(3, password);
			preparedStatement.setString(4, mobileNumber);
			rowsAffected=preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(rowsAffected>0)
			return true;
		return false;
	}
	
	public List<BusDetail> searchBus(String fromLocation,String toLocation,String travelStartDate)
	{
		List<BusDetail> busList=new ArrayList<>();
		Connection connect=Utils.getInstance().dataBaseConnection();
		try {
			PreparedStatement preparedStatement=connect.prepareStatement("SELECT B.*,TA.*,T.*,R.* FROM TripInfo T INNER JOIN Routes R ON T.ScheduleId=R.ScheduleId INNER JOIN Bus B ON T.BusId=B.BusId INNER JOIN TravelAdmin TA ON B.TravelId=TA.Id WHERE R.startPlace=? AND R.endPlace=? AND R.travelStartDate=?");
			preparedStatement.setString(1, fromLocation);
			preparedStatement.setString(2, toLocation);
			preparedStatement.setString(3,travelStartDate);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				BusDetail busdetail=new BusDetail(resultSet);
				busList.add(busdetail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return busList;
	}
	
	public List<BusDetail> searchBus(String fromLocation,String toLocation,LocalDate travelStartDate,LocalTime startRange,LocalTime endRange)
	{
		List<BusDetail> busList=new ArrayList<>();
		Connection connect=Utils.getInstance().dataBaseConnection();
		try {
			PreparedStatement preparedStatement=connect.prepareStatement("SELECT B.*,TA.*,R.* FROM TravelSchedule T"
																			+ "INNER JOIN Routes R ON T.RouteId=R.RouteId "
																			+ "INNER JOIN Bus B ON T.BusId=B.BusId "
																			+ "INNER JOIN TravelAdmin TA ON B.TravelId=TA.Id"
																			+ "WHERE R.startPlace=? AND R.endPlace=? AND R.travelStartDate=? AND"
																			+ "R.travelStartTime BETWEEN ? AND ?");
			preparedStatement.setString(1, fromLocation);
			preparedStatement.setString(2, toLocation);
			preparedStatement.setDate(3,Date.valueOf(travelStartDate));
			preparedStatement.setTime(4, Time.valueOf(startRange));
			preparedStatement.setTime(5, Time.valueOf(endRange));
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				BusDetail busdetail=new BusDetail(resultSet);
				busList.add(busdetail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return busList;
	}
	
	public List<BusDetail> searchBus(String busType,String fromLocation,String toLocation,LocalDate travelStartDate,LocalTime startRange,LocalTime endRange)
	{
		List<BusDetail> busList=new ArrayList<>();
		Connection connect=Utils.getInstance().dataBaseConnection();
		try {
			PreparedStatement preparedStatement=connect.prepareStatement("SELECT B.*,TA.*,R.* FROM TravelSchedule T"
																			+ "INNER JOIN Routes R ON T.RouteId=R.RouteId "
																			+ "INNER JOIN Bus B ON T.BusId=B.BusId "
																			+ "INNER JOIN TravelAdmin TA ON B.TravelId=TA.Id"
																			+ "WHERE R.startPlace=? AND R.endPlace=? AND R.travelStartDate=? AND"
																			+ "B.busType=? AND R.travelStartTime BETWEEN ? AND ?");
			preparedStatement.setString(1, fromLocation);
			preparedStatement.setString(2, toLocation);
			preparedStatement.setDate(3,Date.valueOf(travelStartDate));
			preparedStatement.setString(4, busType);
			preparedStatement.setTime(5, Time.valueOf(startRange));
			preparedStatement.setTime(6, Time.valueOf(endRange));
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				BusDetail busdetail=new BusDetail(resultSet);
				busList.add(busdetail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return busList;
	}
	
	public List<BusDetail> searchBus(String seatType,String busType,String fromLocation,String toLocation,LocalDate travelStartDate,LocalTime startRange,LocalTime endRange)
	{
		List<BusDetail> busList=new ArrayList<>();
		Connection connect=Utils.getInstance().dataBaseConnection();
		try {
			int seatTypeId=seatType.equals("Sleeper")? 1:seatType.equals("SemiSleeper")? 2:3;
			PreparedStatement preparedStatement=connect.prepareStatement("SELECT B.*,TA.*,R.* FROM TravelSchedule T"
																			+ "INNER JOIN Routes R ON T.RouteId=R.RouteId "
																			+ "INNER JOIN Bus B ON T.BusId=B.BusId "
																			+ "INNER JOIN TravelAdmin TA ON B.TravelId=TA.Id"
																			+ "WHERE R.startPlace=? AND R.endPlace=? AND R.travelStartDate=? AND"
																			+ "B.busType=? AND B.seatTypeId AND R.travelStartTime BETWEEN ? AND ?");
			preparedStatement.setString(1, fromLocation);
			preparedStatement.setString(2, toLocation);
			preparedStatement.setDate(3,Date.valueOf(travelStartDate));
			preparedStatement.setString(4, busType);
			preparedStatement.setInt(5,seatTypeId);
			preparedStatement.setTime(6, Time.valueOf(startRange));
			preparedStatement.setTime(7, Time.valueOf(endRange));
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				BusDetail busdetail=new BusDetail(resultSet);
				busList.add(busdetail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return busList;
	}
	
	public PassengerTicketDetails myBookings(int passengerId)
	{
		Connection connect=Utils.getInstance().dataBaseConnection();
		PassengerTicketDetails ticketdetail=null;
		
		try {
			PreparedStatement preparedStatement=connect.prepareStatement("SELECT * FROM BookingDetails WHERE PassengerId=? ORDER BY TicketId DESC");
			preparedStatement.setInt(1, passengerId);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				BookingDetails bookingDetail=new BookingDetails(resultSet);
				
				PreparedStatement preparedStatement1=connect.prepareStatement("SELECT SeatNumber,PassengerName FROM BookedPassengers WHERE TicketId=?");
				preparedStatement1.setInt(1, bookingDetail.getTicketId());
				ResultSet resultSet1=preparedStatement1.executeQuery();
				ArrayList<BookedPassengers> passengerList=new ArrayList<>();
				while(resultSet1.next())
				{
				BookedPassengers bookedPassengers=new BookedPassengers(resultSet1);
				passengerList.add(bookedPassengers);
				}
				ticketdetail.setBookingdetails(bookingDetail);
				ticketdetail.setPassengerList(passengerList);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return ticketdetail;
	}
	

	public ArrayList<BoardingPoint> showBoardingPoints(int routeId)
	{
		ArrayList<BoardingPoint> boardingPointList=new ArrayList<>();
		Connection connect=Utils.getInstance().dataBaseConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			preparedStatement=connect.prepareStatement("SELECT * FROM BoardingPoints WHERE RouteId=? ORDER BY BoardingOrder");
			preparedStatement.setInt(1, routeId);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				BoardingPoint boardingPoint=new BoardingPoint(resultSet);
				boardingPointList.add(boardingPoint);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardingPointList;
	}
	
	public void bookTicket(int routeId,int passengerId,int boardingId,ArrayList<LinkedHashMap<Integer,String>> passengerList)
	{
		Connection connect=Utils.getInstance().dataBaseConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		int rowsAffected=0;
		
		try {
			PreparedStatement preparedStatement1=connect.prepareStatement("SELECT * FROM Routes WHERE RouteId=?");
			preparedStatement1.setInt(1, routeId);
			ResultSet resultSet1=preparedStatement1.executeQuery();
			Routes routes=null;
			while(resultSet1.next())
			{
				routes=new Routes(resultSet1);
			}
			
			PreparedStatement preparedStatement2=connect.prepareStatement("SELECT BusId From TripInfo WHERE ScheduleId=?");
			preparedStatement2.setInt(1, routes.getScheduleId());
			ResultSet resultSet2=preparedStatement2.executeQuery();
			int busId=0;
			while(resultSet2.next())
			{
				busId=resultSet2.getInt(1);
			}
			
			PreparedStatement preparedStatement3=connect.prepareStatement("SELECT * FROM BoardingPoint WHERE BoardingId=?");
			preparedStatement3.setInt(1, boardingId);
			ResultSet resultSet3=preparedStatement3.executeQuery();
			BoardingPoint boardingDetail=null;
			while(resultSet3.next())
			{
				boardingDetail=new BoardingPoint(resultSet3);
			}
			
			preparedStatement=connect.prepareStatement("INSERT INTO BookingDetails (BusId,RouteId,PassengerId,BookedDate,TravelDate,BoardingTime,BoardingPoint,DroppingTime,DroppingPoint,TicketCount,Fare,BookingStatus)"
														+ "VALUES (?,?,?,?,?,?,?,?,?,?)");
			preparedStatement.setInt(1, busId);
			preparedStatement.setInt(2, routes.getRouteId());
			preparedStatement.setInt(3, passengerId);
			preparedStatement.setDate(4,Date.valueOf(LocalDate.now()));
			preparedStatement.setDate(5, Date.valueOf(routes.getTravelStartDate()));
			preparedStatement.setTime(6, Time.valueOf(boardingDetail.getBoardingTime()));
			preparedStatement.setString(7, boardingDetail.getBoardingPlace());
			preparedStatement.setTime(8, Time.valueOf(routes.getTravelEndTime()));
			preparedStatement.setString(9, routes.getEndPlace());
			preparedStatement.setInt(10, passengerList.size());
			double fare=(passengerList.size()* routes.getTravelFare())+(passengerList.size()* routes.getTravelFare()*0.05);
			preparedStatement.setDouble(11,fare);
			preparedStatement.setString(12, "Confirmed");
			rowsAffected=preparedStatement.executeUpdate();
			if(rowsAffected>0)
			{
				System.out.println("Booking details :"+rowsAffected+"record(s) added successfully");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public PassengerTicketDetails showLastTicket(int passengerId)
	{
		Connection connect=Utils.getInstance().dataBaseConnection();
		PassengerTicketDetails ticketdetail=null;
		
		try {
			PreparedStatement preparedStatement=connect.prepareStatement("SELECT * FROM BookingDetails WHERE PassengerId=? ORDER BY TicketId DESC LIMIT 1");
			preparedStatement.setInt(1, passengerId);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				BookingDetails bookingDetail=new BookingDetails(resultSet);
				
				PreparedStatement preparedStatement1=connect.prepareStatement("SELECT SeatNumber,PassengerName FROM BookedPassengers WHERE TicketId=?");
				preparedStatement1.setInt(1, bookingDetail.getTicketId());
				ResultSet resultSet1=preparedStatement1.executeQuery();
				ArrayList<BookedPassengers> passengerList=new ArrayList<>();
				while(resultSet1.next())
				{
				BookedPassengers bookedPassengers=new BookedPassengers(resultSet1);
				passengerList.add(bookedPassengers);
				}
				ticketdetail.setBookingdetails(bookingDetail);
				ticketdetail.setPassengerList(passengerList);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return ticketdetail;
	}
	
	
	
	public void cancelTicket(int ticketId)
	{
		Connection connect=Utils.getInstance().dataBaseConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		int rowsAffected=0;
		try {
			preparedStatement=connect.prepareStatement("UPDATE BookingDetails SET bookingStatus=? WHERE ticketId=?");
			preparedStatement.setString(1, "Cancelled");
			preparedStatement.setInt(2, ticketId);
			rowsAffected=preparedStatement.executeUpdate();
			if(rowsAffected>0)
			{
				System.out.println("Ticket cancelled successfully");
				rowsAffected=0;
			}
			
			PreparedStatement preparedStatement1=connect.prepareStatement("DELETE FROM BookedPassengers WHERE ticketId=?");
			preparedStatement1.setInt(1, ticketId);
			rowsAffected=preparedStatement1.executeUpdate();
			if(rowsAffected>0)
			{
				System.out.println("Passengers List deleted");
				rowsAffected=0;
			}
			
			PreparedStatement preparedStatement2=connect.prepareStatement("SELECT ticketCount FROM BookingDetails WHERE ticketId=?");
			preparedStatement2.setInt(1, ticketId);
			ResultSet resultSet1=preparedStatement2.executeQuery();
			int ticketcount=0;
			while(resultSet1.next())
			{
				ticketcount=resultSet1.getInt(1);
			}
			//to update ticket count
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
