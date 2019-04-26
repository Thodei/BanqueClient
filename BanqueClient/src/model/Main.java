package model;

import javafx.application.Application;
import javafx.stage.Stage;
import dao.Requete;
import vue.Vue;

public class Main  extends Application  {
	public static Stage parentWindow;
	public static Requete Req;
	public static int IDClient;
	
	public static void main(String[] args) {	
		Req = new Requete();
		try 
		{
			launch(args);
		}
		catch (Exception e) 
		{
			 e.printStackTrace();
		}	
	}	

	@Override
	public void start(Stage arg0) throws Exception {
		parentWindow = arg0;	
		try {
			new Vue("Login",arg0,null);
		}
		catch (Exception e) {			
			e.printStackTrace();
		}
		
	}
}
