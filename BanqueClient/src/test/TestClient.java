package test;

import static org.junit.Assert.assertEquals;
import org.junit.*;

import main.Client;

public class TestClient 
{
	private Client client;

	@Before
	public void setUp() 
	{
		client = new Client();
	}
	
	@Test
	public void testGetClient() 
	{
		// Given
	    String expectedResult = "0123456789";

	    // When
	    String result = client.getClient();

	    // Then
	    assertEquals("La méthode getClient ne renvoie pas le résultat attendu", expectedResult, result);
	}
}
