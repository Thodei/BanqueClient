package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Main;
import outils.ConversionEuro;
import vue.Vue;

public class DetailCompteController {

	@FXML private Button button_virement;
	@FXML private Button button_quitter;
	@FXML private TextField text_virement_n_compte;
	@FXML private TextField text_virement_somme;
	@FXML private Label text_balance;
	@FXML private Label solde_dollar;
	@FXML private Label solde_livre;
	@FXML private Label text_decouvert;
	@FXML private Label Label_Titre;
	
	private double solde;
	private ResultSet details_compte;
	
	@FXML 
    public void initialize() 
	{    
		Label_Titre.setText("Compte n° " + Vue.NumCompte);
		rafraichir_solde();
		rafraichir_solde_dollar();
		rafraichir_solde_livre();
		rafraichir_decouvert();
    }  
	
	@FXML
	public void rafraichir_solde()
	{
		try 
		{
			details_compte = Main.Req.details_compte(String.valueOf(Main.IDClient));
			details_compte.next();
			String solde = String.valueOf(details_compte.getDouble("balanceCompte"));
			text_balance.setText(solde + " €");
			this.solde = details_compte.getDouble("balanceCompte");
		} catch (SQLException e) 
		{
			Main.message_erreur("Erreur : Impossible d'afficher le solde" + e.toString());
		}
	}
	
	private void rafraichir_solde_dollar()
	{
		Double solde_dollars = ConversionEuro.euroToDollar(this.solde);
		solde_dollar.setText(String.valueOf(solde_dollars + " $"));
	}
	
	private void rafraichir_solde_livre()
	{
		Double solde_livres = ConversionEuro.euroToLivre(this.solde);
		solde_livre.setText(String.valueOf(solde_livres + " £"));
	}
	
	private void rafraichir_decouvert()
	{
		try 
		{
			Double decouvert = details_compte.getDouble("decouvertCompte");
			text_decouvert.setText(String.valueOf(decouvert) + " €");
		} catch (SQLException e) 
		{
			Main.message_erreur("Impossible de charger le découvert. Cause : " + e.toString()); 
		}
	}
	
	
	@FXML
	private void virement()
	{
		String somme = text_virement_somme.getText(); 
		String compte = text_virement_n_compte.getText();
		
		if(somme.isEmpty() || compte.isEmpty())
			Main.message_erreur("Entrez une somme à virer ainsi que le n° de compte du destinataire.");
		else
		{
			try 
			{
				if(somme.contains("-"))
				{
					Main.message_erreur("La somme ne doit pas être négative !");
					return;
				}
				
				if(Main.Req.virement(Double.parseDouble(somme), Vue.NumCompte, compte))
				{
					rafraichir_solde();
					Main.message_info("Virement a été Reussi");					
				}
				else
					Main.message_erreur("Le virement a échoué. Peut-être que le compte destinataire n'existe pas ou que votre solde est insuffisant.");
			} catch (NumberFormatException e) 
			{
				Main.message_erreur("Veuillez entrer une somme correcte. Erreur : " + e.toString());
			} catch (SQLException e) 
			{
				Main.message_erreur("Erreur lors du virement. Erreur : " + e.toString());
			}
		}
	}
	
    @FXML 
    public void Btn_Retour_Click() 
    {
    	try 
    	{
			new Vue("Compte",null,null);
		} catch (Exception e) 
    	{
			Main.message_erreur("Impossible de revenir à la fenêtre précédente. Erreur : " + e.toString());
		}
    }
    
    @FXML 
    public void btn_quitter() 
    {
    	Main.parentWindow.close();
    }
}
