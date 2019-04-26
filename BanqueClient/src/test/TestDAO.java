package test;

import static org.junit.Assert.assertEquals;
import org.junit.*;

import dao.MySql;
import junit.framework.Assert;

import java.sql.*;

public class TestDAO 
{
	@Test
	public void testConnection() throws SQLException, ClassNotFoundException 
	{
		MySql dbConnection = new MySql();
	    Connection test = dbConnection.get_connexion();
	    Assert.assertNotNull(test);
	}
}
