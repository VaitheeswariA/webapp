package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;

public class BusDetail {
	public Bus bus;
	public TravelAdmin travels;
	public Routes routes;
	public TripInfo tripinfo;
	
	public BusDetail(ResultSet resultSet) {
		bus=new Bus();
		routes = new Routes();
		travels = new TravelAdmin();
		tripinfo=new TripInfo();
		try {
			bus.setBusId(resultSet.getInt(1));
			bus.setTravelsId(resultSet.getInt(2));
			bus.setBusNumber(resultSet.getString(3));
			bus.setBusType(resultSet.getString(4));
			bus.setSeatTypeId(resultSet.getInt(5));
			bus.setTotalseats(resultSet.getInt(6));
			bus.setRating(resultSet.getInt(7));
			travels.setTravelId(resultSet.getInt(8));
			travels.setEmailId(resultSet.getString(9));
			travels.setTravelsName(resultSet.getString(10));
			travels.setPassword(resultSet.getString(11));
			tripinfo.setScheduleId(resultSet.getInt(12));
			tripinfo.setBusId(resultSet.getInt(13));
			tripinfo.setDriverId(resultSet.getInt(14));
			tripinfo.setTripDate(resultSet.getDate(15).toLocalDate());
			tripinfo.setTripStartTime(resultSet.getTime(16).toLocalTime());
			tripinfo.setAvailableSeats(resultSet.getInt(17));
			routes.setRouteId(resultSet.getInt(18));
			routes.setScheduleId(resultSet.getInt(19));
			routes.setStartPlace(resultSet.getString(20));
			routes.setEndPlace(resultSet.getString(21));
			routes.setTravelStartDate(resultSet.getDate(22).toLocalDate());
			routes.setTravelEndDate(resultSet.getDate(23).toLocalDate());
			routes.setTravelStartTime(resultSet.getTime(24).toLocalTime());
			routes.setTravelEndTime(resultSet.getTime(25).toLocalTime());
			routes.setTravelFare(resultSet.getDouble(26));
			routes.setTimeToReach(resultSet.getDouble(27));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static JSONObject mergeJsonObjs(JSONObject target, JSONObject source) throws JSONException{
		Iterator<String> keys = source.keys();
		while(keys.hasNext()){
			String key = keys.next();
			target.put(key, source.get(key));
		}
		return target;
	}
	
	
}
