package controller;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import dao.Dictionnaire;
import model.Main;
import vue.Vue;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class LoginController {

	@FXML private TextField Text_NumeroCompte;	
	@FXML private PasswordField Text_Password;
	@FXML private Button Btn_Connexion;
	
	@FXML public void Btn_Connexion_Click() 
	{
		String user = Text_NumeroCompte.getText();
		String password = Text_Password.getText();
		
		//On vérifie que les champs ne sont pas vides
		if(user.isEmpty() || password.isEmpty())
		{
			Main.message_erreur("Veuillez renseigner un numéro d'utilisateur ainsi qu'un mot de passe");
		}
		else
		{
			try 
			{
				ResultSet Resultat = Main.Req.connexion(user, password);
				
				if (Resultat.isBeforeFirst())
				{  
					while(Resultat.next())
					{
						int numClient = Resultat.getInt("numClient");
						if(numClient != 0)
						{
							Main.IDClient = numClient;
							new Vue("Compte",null,null);
						}
					}
				}
				else
					Main.message_erreur("Numéro d'utilisateur ou mot de passe incorrect.");
		
			} catch (Exception e) 
			{
				Main.message_erreur("Erreur lors de la connexion : " + e.toString());
			}
		}
	}

    @FXML 
    public void btn_quitter() 
    {
    	Main.parentWindow.close();
    }
	
}
