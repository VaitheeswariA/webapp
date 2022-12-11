package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;
import org.json.JSONArray;
import org.json.JSONObject;

import controller.PassengerController;
import model.BusDetail;


public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PassengerController passengercontroller=new PassengerController();
		String action=request.getParameter("action");
		String fromLocation=request.getParameter("fromLocation");
		String toLocation=request.getParameter("toLocation");
		String travelDate=request.getParameter("travelDate".toString());
		//String travelDate="2022-10-30";
		//LocalDate dt= LocalDate.parse(travelDate);

		List<BusDetail> buslist=passengercontroller.searchBus(fromLocation, toLocation, travelDate);
		response.setContentType("application/json");
		JSONObject resp=new JSONObject();
		if(buslist.size()>0) {
			response.setStatus(HttpStatus.SC_ACCEPTED);
			JSONArray dataarr=new JSONArray();
			for(int index=0;index<buslist.size();index++) {
				JSONObject Jsonresp=new JSONObject();
				
				JSONObject busJson=new JSONObject(buslist.get(index).bus);
				Jsonresp=BusDetail.mergeJsonObjs(busJson, Jsonresp);
				
				JSONObject travelsJson=new JSONObject(buslist.get(index).travels);
				Jsonresp=BusDetail.mergeJsonObjs(travelsJson, Jsonresp);
				
				JSONObject tripInfoJson=new JSONObject(buslist.get(index).tripinfo);
				Jsonresp=BusDetail.mergeJsonObjs(tripInfoJson, Jsonresp);
				
				JSONObject routesJson=new JSONObject(buslist.get(index).routes);
				Jsonresp=BusDetail.mergeJsonObjs(routesJson, Jsonresp);
				
				dataarr.put(Jsonresp);
				
			}
			resp.put("data", dataarr);
			resp.put("status", "success");
		}
		else {
			response.setStatus(HttpStatus.SC_UNAUTHORIZED);
			resp.put("status", "failure");
		}
		
		response.getWriter().write(resp.toString());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
