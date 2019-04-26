package controller;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import dao.Dictionnaire;
import model.Main;
import vue.Vue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

	@FXML private TextField Text_NumeroCompte;	
	@FXML private PasswordField Text_Password;
	@FXML private Button Btn_Connexion;
	
	@FXML public void Btn_Connexion_Click() {
		//infoBox(Text_NumeroCompte.getText() + " - " + Text_Password.getText());
		try {			
			ResultSet Resultat = Main.Req.RequeteSelect(Dictionnaire.Req_Select_Login(Text_NumeroCompte.getText(), Text_Password.getText()));			
			while(Resultat.next())
			{
				if(Resultat.getInt("idUtilisateur") != 0)
				{
					System.out.println("ID : "+Resultat.getInt("idUtilisateur"));
					Main.IDClient = Resultat.getInt("idUtilisateur");
					new Vue("Compte",null,null);
				}
			}		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void infoBox(String infoMessage)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "Banque Client", JOptionPane.INFORMATION_MESSAGE);
    }
	
}
