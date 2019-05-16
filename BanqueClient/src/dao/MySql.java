package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySql 
{
	private String ip = "127.0.0.1";
	private String port = "3306";
	private String user = "root";
	private String pwd = "";
	private String db = "bdd_bank";
	private Connection connexion = null;

	public MySql() throws ClassNotFoundException, SQLException 
	{		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Driver JDBC introuvable");
		}
		try
		{
			connexion=DriverManager.getConnection("jdbc:mysql://" + ip + ":" + port + "/" + db, user, pwd);
			System.out.println("Connexion établie");
		}
		catch(SQLException e)
		{
			System.out.println("Connexion à la BDD impossible");
			e.printStackTrace();
		}
	}
	
	public Connection get_connexion()
	{
		return connexion;
	}
	
	public void close_connexion() throws SQLException
	{
		this.connexion.close();
	}
}
