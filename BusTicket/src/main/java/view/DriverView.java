package view;

import controller.UserController;

public class DriverView implements UserController{

	@Override
	public void login(String emailId, String password) {
		// TODO Auto-generated method stub
		
	}
	
	public void driverPage()
	{
		System.out.println("Choose any option \n1. My schedules \n2.Exit");
	}

}
