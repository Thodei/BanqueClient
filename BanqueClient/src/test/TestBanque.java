package test;

import static org.junit.Assert.assertEquals;
import org.junit.*;

import main.Banque;

public class TestBanque 
{
	private Banque banque;

	@Before
	public void setUp() 
	{
		banque = new Banque();
	}
	
	@Test
	public void testGetBanque() 
	{
		// Given
	    String expectedResult = "0123456789";

	    // When
	    String result = banque.getBanque();

	    // Then
	    assertEquals("La m�thode getBanque ne renvoie pas le r�sultat attendu", expectedResult, result);
	}
}
