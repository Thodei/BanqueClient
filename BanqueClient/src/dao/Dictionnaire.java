package dao;

public class Dictionnaire 
{
	public static String Req_Select_Login(String NomUser, String PrenomUser) 
	{
		return "SELECT TOP(1) idUtilisateur FROM utilisateur WHERE nomUtilisateur = '"+NomUser+"' AND prenomUtilisateur = '"+PrenomUser+"' ";
	}

	public static String Req_Select_GetAllCompte(int IDUtilisateur) 
	{
		return "SELECT * FROM compte WHERE Utilisateur_idUtilisateur = " + String.valueOf(IDUtilisateur);
	}
}