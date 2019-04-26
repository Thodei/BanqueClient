package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Requete {
	
	private Connection Connexion;
	
	public Requete(){
		
		MySql DataBase = null;
		
		try {
			DataBase = new MySql();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();			
		} 
		catch (SQLException e) {
			e.printStackTrace();			
		}
		
		Connexion = (Connection) DataBase.get_connexion();
	}

	public ResultSet RequeteSelect(String Req) throws SQLException
	{
		Statement statement = Connexion.createStatement();
		ResultSet resultat = statement.executeQuery(Req);
		return resultat;
	}
	
	public Boolean RequeteInsert(String Req) throws SQLException
	{
		return null;		
	}
	
	public Boolean RequeteUpdate(String Req) throws SQLException
	{
		return null;		
	}
	
	public Boolean RequeteDelete(String Req) throws SQLException
	{
		return null;		
	}
}
