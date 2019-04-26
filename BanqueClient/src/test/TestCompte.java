package test;

import static org.junit.Assert.assertEquals;
import org.junit.*;

import main.Compte;

public class TestCompte 
{
	private Compte compte;

	@Before
	public void setUp() 
	{
		compte = new Compte();
	}
	
	@Test
	public void testGetCompte() 
	{
		// Given
	    String expectedResult = "0123456789";

	    // When
	    String result = compte.getCompte();

	    // Then
	    assertEquals("La m�thode getCompte ne renvoie pas le r�sultat attendu", expectedResult, result);
	}
}
