package model;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
	public void start(Stage arg0) throws Exception 
	{
		parentWindow = arg0;	
		try {
			new Vue("Login",arg0,null);
		}
		catch (Exception e) {			
			e.printStackTrace();
		}
		
	}
	
	public static void message_erreur(String infoMessage)
    {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("");
		alert.setHeaderText("Erreur");
		alert.setContentText(infoMessage);
		alert.showAndWait();
    }
	
	public static void message_info(String infoMessage)
    {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("");
		alert.setHeaderText("Information");
		alert.setContentText(infoMessage);
		alert.showAndWait();
    }
}
