package test;

import static org.junit.Assert.assertEquals;
import org.junit.*;

import outils.ConversionEuro;

public class TestConversion 
{

	@Before
	public void setUp() 
	{

	}

	@Test
	public void testConversionEuroVersDollar() 
	{
		double valeurEnEuro = 10;
		double resultatAttendu = 11.20;
		assertEquals(resultatAttendu,ConversionEuro.euroToDollar(valeurEnEuro), 1);
	}
	
	@Test
	public void testConversionEuroVersLivres() 
	{
		double valeurEnEuro = 10;
		double resultatAttendu = 8.71;
		assertEquals(resultatAttendu,ConversionEuro.euroToLivre(valeurEnEuro), 1);
	}
	
	@Test
	public void testConversionDollarVersEuro() 
	{
		double valeurEnDollar = 10;
		double resultatAttendu = 8.92;
		assertEquals(resultatAttendu,ConversionEuro.dollarToEuro(valeurEnDollar), 1);
	}
	
	@Test
	public void testConversionLivresVersEuro() 
	{
		double valeurEnLivres = 10;
		double resultatAttendu = 11.48;
		assertEquals(resultatAttendu,ConversionEuro.livreToEuro(valeurEnLivres), 1);
	}
}
