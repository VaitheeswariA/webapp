package view;

import controller.UserController;
import model.TravelAdmin;

public class TravelAdminView implements UserController{

	@Override
	public void login(String emailId, String password) {
		// TODO Auto-generated method stub
		
	}
	
	
	public void travelAdminPage(TravelAdmin travelAdminDetail)
	{
		System.out.println("Choose any choice \n1.Add bus Schedule \n2.Update bus schedule \n3.Delete bus schedule \n4.Add bus Details \n5.Update bus details \n6.Delete bus details \n7.View Bus Details \n8.View Bus Schedule \n9.My Account \n10.Exit");
	}

}
