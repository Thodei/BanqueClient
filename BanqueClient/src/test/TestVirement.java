package test;

import static org.junit.Assert.assertEquals;
import org.junit.*;

import dao.Dictionnaire;
import dao.Requete;
import outils.ConversionEuro;
import vue.Vue;

public class TestVirement 
{
	private Requete query;
	private Dictionnaire req;

	@Before
	public void setUp() 
	{

	}
	
	@Test
	public void testVirementCompteEmetteur() 
	{
		String compteEmetteur = "1";
		String compteDestinataire = "2";
		req.Req_SELECT_GetSolde(compteEmetteur);
		
		int soldeAvantDebit = Integer.parseInt(req.Req_SELECT_GetSolde(compteEmetteur));
		int montantVirement = 300;
		int soldeApresDebitAttendu = soldeAvantDebit - montantVirement;
		
		query = new Requete();
		query.virement(montantVirement, compteEmetteur, compteDestinataire);
		
		
		assertEquals(soldeApresDebitAttendu,query.virement(montantVirement, compteEmetteur, compteDestinataire), 1);
	}
	
	public void testVirementCompteDestinataire() 
	{
		double montantVirement = 250;
		double resultatAttendu = 11.20;
		assertEquals(resultatAttendu,ConversionEuro.euroToDollar(valeurEnEuro), 1);
	}
}
