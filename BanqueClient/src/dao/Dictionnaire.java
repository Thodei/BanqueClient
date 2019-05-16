package dao;

public class Dictionnaire 
{	
	public static String Req_SELECT_GetAllCompte()
	{
		return "SELECT *  FROM compte";
	}

	public static String Req_SELECT_GetAllClient()
	{
		return "SELECT * FROM client";
	}

	public static String Req_SELECT_GetAllBanque()
	{
		return "SELECT * FROM banque";
	}

	public static String Req_SELECT_GetCompte(String idClient)
	{
		return "SELECT numCompte FROM compte JOIN client ON compte.Utilisateur_idUtilisateur = client.idClient WHERE client.idClient= "+ idClient;
	}

	public static String Req_SELECT_GetDetailsCompte(String numCompte)
	{
		return "SELECT * FROM compte JOIN client ON compte.Utilisateur_idUtilisateur = client.idClient WHERE numCompte = '"+ numCompte +"' ";
	}

	public static String Req_SELECT_GetDetailsClient(String numClient)
	{
		return "SELECT * FROM client WHERE numClient = '"+numClient+"' ";
	}

	public static String Req_SELECT_Login(String numClient, String MotDePasse)
	{
		return "SELECT numClient FROM client WHERE numClient = '"+numClient+"' AND mdpClient= '"+MotDePasse+"' ";
	}
	
	public static String Req_UPDATE_Crediter(String numCompte, double somme)
	{
		return "UPDATE compte SET balanceCompte = balanceCompte + " + somme + " WHERE numCompte = " + numCompte;
	}
	
	public static String Req_UPDATE_Debiter(String numCompte, double somme)
	{
		return "UPDATE compte SET balanceCompte = balanceCompte - " + somme + " WHERE numCompte = " + numCompte;
	}
	
	public static String Req_SELECT_GetSolde(String numCompte)
	{
		return "SELECT balanceCompte FROM compte WHERE numCompte = " +numCompte;
	}
}