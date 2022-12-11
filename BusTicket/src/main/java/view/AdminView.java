package view;

import controller.UserController;

public class AdminView implements UserController{

	@Override
	public void login(String emailId, String password) {
		// TODO Auto-generated method stub
		
	}
	
	public void adminPage()
	{
		System.out.println("Choose any options \n1.View Bus Details \n2.Update Bus Details \n3.Delete Bus Details \n4.View Travels Details \n5.Update Travels Details \n 6.Delete Travel Details \n 7.Exit");
	}
	
}
