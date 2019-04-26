package test;

import static org.junit.Assert.assertEquals;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.*;

import dao.MySql;

public class TestInitialisationDB 
{
	private static Connection test;
	  
	@AfterClass
	public static void end() throws SQLException
	{
		test.close();
	}

	@Test
	public void initDb() throws SQLException, ClassNotFoundException 
	{
		MySql dbConnection = new MySql();
		test = dbConnection.get_connexion();
		
	    String requete = "SELECT idClient, nomClient, prenomClient FROM client";
	    try 
	    {
	    	Statement stmt = test.createStatement();
	    	stmt.executeQuery(requete);
	    } 
	    catch (SQLException e) 
	    {
	    	createTable(test);
	    }
	    test.close();
	}

	private void createTable(Connection test) 
	{
		String requete = "CREATE TABLE client " +
	        "(" +
	        "idClient INT NOT NULL AUTO_INCREMENT," +
	        "nomClient VARCHAR(45) NOT NULL," +
	        "prenomClient VARCHAR(45) NOT NULL," +
	        "numClient INT NOT NULL," +
	        "mdpClient VARCHAR(45) NOT NULL," +
	        "PRIMARY KEY (idClient)" +
	        ")";
	    try 
	    {
	    	Statement stmt = test.createStatement();
	    	stmt.executeUpdate(requete);
	    } 
	    catch (SQLException e) 
	    {
	    	Assert.fail(e.getMessage());
	    }
	}
}
