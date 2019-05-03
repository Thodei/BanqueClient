package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Requete {
	
	private Connection Connexion;
	
	public Requete()
	{
		MySql DataBase = null;
		
		try 
		{
			DataBase = new MySql();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();			
		}
		
		Connexion = (Connection) DataBase.get_connexion();
	}

	/**
	 * V�rifie si un utilisateur et un mot de passe correspondent dans la BDD
	 * @return Un ResultSet � traiter contenant toutes les lignes de la requ�te
	 */
	public ResultSet connexion(String user, String password) throws SQLException
	{
		Statement statement = Connexion.createStatement();
		ResultSet resultat = statement.executeQuery(Dictionnaire.Req_SELECT_Login(user,password));
		return resultat;		
	}
	
	/**
	 * Renvoie tous les comptes d'un utilisateur pass� en param�tre
	 * @return Un ResultSet � traiter contenant toutes les lignes de la requ�te
	 */
	public ResultSet recuperer_comptes(String idUtilisateur) throws SQLException
	{
		Statement statement = Connexion.createStatement();
		ResultSet resultat = statement.executeQuery(Dictionnaire.Req_SELECT_GetCompte(idUtilisateur));
		return resultat;
	}
	
	/**
	 * Renvoie tous les details d'un compte pass� en param�tre
	 * @return Un ResultSet � traiter contenant toutes les lignes de la requ�te
	 */
	public ResultSet details_compte(String numCompte) throws SQLException
	{
		Statement statement = Connexion.createStatement();
		ResultSet resultat = statement.executeQuery(Dictionnaire.Req_SELECT_GetDetailsCompte(numCompte));
		return resultat;
	}
	
	/**
	 * Retire une somme � un compte et la distribue � un autre
	 */
	public Boolean virement(double somme, String emetteur, String destinataire) throws SQLException
	{
		ResultSet resultat_destinataire = get_compte(destinataire);
		//On v�rifie si l'emetteur a assez d'argent
		if(peut_virer(emetteur,somme))		
			//On v�rifie si le compte recepteur existe
			if(resultat_destinataire.isBeforeFirst())
			{
				Statement statement = Connexion.createStatement();
				//On d�bite l'emetteur
				if (statement.executeUpdate(Dictionnaire.Req_UPDATE_Debiter(emetteur, somme)) != 0)
				{
					//On cr�dite le desinataire
					if (statement.executeUpdate(Dictionnaire.Req_UPDATE_Crediter(destinataire, somme)) != 0)
					{
						return true;
					}
				}
			}
		return false;
	}
	
	/**
	 * V�rifie si un compte peut virer une somme en la comparant � son solde
	 * @throws SQLException 
	 */
	public Boolean peut_virer(String compte, double somme) throws SQLException
	{
		ResultSet resultat_compte = details_compte(compte);
		if(resultat_compte.isBeforeFirst())
		{
			resultat_compte.next();
			double solde = resultat_compte.getDouble("balanceCompte");
			if (solde >= somme)
				return true;
		}
		return false;		
	}
	
	
	
	
	
	
	
	
	
	
	
	public ResultSet get_compte(String compte) throws SQLException
	{
		Statement statement = Connexion.createStatement();
		ResultSet resultat = statement.executeQuery(Dictionnaire.Req_SELECT_GetDetailsCompte(compte));
		return resultat;
	}
	
	/**
	 * Renvoie la r�ponse d'une requete personnalis�e
	 */
	public ResultSet RequeteSelect(String Req) throws SQLException
	{
		Statement statement = Connexion.createStatement();
		ResultSet resultat = statement.executeQuery(Req);
		return resultat;
	}
}
