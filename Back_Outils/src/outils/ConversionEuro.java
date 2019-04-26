package outils;

public class ConversionEuro 
{
	
	public static double euroToDollar(double euro)
	{
		return euro * 1.11;
	}
	
	public static double euroToLivre(double euro)
	{
		return euro * 0.77;
	}
	
	
	public static double dollarToEuro(double dollar)
	{
		return dollar * 0.90;
	}

	public static double livreToEuro(double livre)
	{
		return livre * 1.16;
	}

}

