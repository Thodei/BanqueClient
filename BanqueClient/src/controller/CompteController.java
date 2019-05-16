package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.Main;
import vue.Vue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

public class CompteController {

	@FXML ListView<String> ListCompte;
	
    @FXML 
    public void initialize() 
    {    
    	ListCompte.setOnMouseClicked(new EventHandler<MouseEvent>() 
    	{
            @Override
            public void handle(MouseEvent event) 
            {
            	String NumCompte = null; 
        		NumCompte = ListCompte.getSelectionModel().getSelectedItem();
        		
        		try 
        		{
        			NumCompte = NumCompte.substring(NumCompte.indexOf("∞")+1 , NumCompte.indexOf(" ", NumCompte.indexOf("∞")));    
        		}catch(Exception ignore) { }        		
            		
            	if (NumCompte != null && NumCompte != "")
            	{
	                try 
	                {
						new Vue("DetailCompte",null,NumCompte);
					} catch (Exception e) 
	                {
						e.printStackTrace();
					} 
            	}
            }
        });
    	
    	ActualiseCompte();
    }  
    
    @FXML 
    public void Btn_NewCompte_Click() 
    {
    	ActualiseCompte();
    }
    
    @FXML 
    public void Btn_Deconnexion_Click() 
    {
    	Main.IDClient = 0;
    	 try {
				new Vue("Login",null,null);
			} catch (Exception e) {
				e.printStackTrace();
			}  
    }
    
    
	public void AddListCompte(String Text)
	{
		ListCompte.getItems().add(ListCompte.getItems().size(), Text);
	}
	
	public void ActualiseCompte() 
	{    	
		ListCompte.getItems().clear();
		
		//On r√©cup√®re tous les comptes d'un client
		ResultSet liste_comptes;
		try 
		{
			liste_comptes = Main.Req.recuperer_comptes(String.valueOf(Main.IDClient));

			if (liste_comptes.isBeforeFirst())
			{
				while(liste_comptes.next())
				{
					String numCompte = String.valueOf(liste_comptes.getInt(1));
					
					//On r√©cup√®re les d√©tails de chaque compte
					ResultSet compte = Main.Req.details_compte(numCompte);
					compte.next();
					String soldeCompte = String.valueOf(compte.getDouble("balanceCompte"));
					AddListCompte("Compte n∞" + numCompte + " ( Solde : "+ soldeCompte +" Ä )");
				}
			}
			else
				AddListCompte("Aucun compte existant.");
		} catch (SQLException e) 
		{
			Main.message_erreur("Erreur lors de la rÈcupÈration des comptes. (" + e.toString() + ")");
			e.printStackTrace();
		}
	}
	
    @FXML 
    public void btn_quitter() 
    {
    	Main.parentWindow.close();
    }
}
