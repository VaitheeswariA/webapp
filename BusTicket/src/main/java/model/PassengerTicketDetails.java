package model;

import java.util.ArrayList;

public class PassengerTicketDetails {
	private ArrayList<BookedPassengers> passengerList;
	private BookingDetails bookingdetails;
	
	
	public ArrayList<BookedPassengers> getPassengerList() {
		return passengerList;
	}
	public void setPassengerList(ArrayList<BookedPassengers> passengerList) {
		this.passengerList = passengerList;
	}
	public BookingDetails getBookingdetails() {
		return bookingdetails;
	}
	public void setBookingdetails(BookingDetails bookingdetails) {
		this.bookingdetails = bookingdetails;
	}
	
	
}
