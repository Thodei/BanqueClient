package test;

import static org.junit.Assert.assertEquals;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	public void testVirementCompteEmetteur() throws SQLException 
	{
		query = new Requete();
		
		String compteEmetteur = "1";
		String compteDestinataire = "2";
		int soldeAvantDebit = 0;
		int soldeApresDebit = 0;
		int soldeApresDebitAttendu = 0;
		int montantVirement = 300;
		
		
		ResultSet resultatAvant = query.RequeteSelect(req.Req_SELECT_GetSolde(compteEmetteur));
		while(resultatAvant.next()) 
		{
			soldeAvantDebit = resultatAvant.getInt(1);
		}
		soldeApresDebitAttendu = soldeAvantDebit - montantVirement;
		
		query.virement(montantVirement, compteEmetteur, compteDestinataire);
		
		ResultSet resultatApres = query.RequeteSelect(req.Req_SELECT_GetSolde(compteEmetteur));
		while(resultatApres.next()) 
		{
			soldeApresDebit = resultatApres.getInt(1);
		}
		
		assertEquals(soldeApresDebitAttendu,soldeApresDebit, 1);
	}
	
	@Test
	public void testVirementCompteDestinataire() throws SQLException 
	{
		query = new Requete();
		
		String compteEmetteur = "1";
		String compteDestinataire = "2";
		int soldeAvantCredit = 0;
		int soldeApresCredit = 0;
		int soldeApresCreditAttendu = 0;
		int montantVirement = 300;
		
		
		ResultSet resultatAvant = query.RequeteSelect(req.Req_SELECT_GetSolde(compteDestinataire));
		while(resultatAvant.next()) 
		{
			soldeAvantCredit = resultatAvant.getInt(1);
		}
		soldeApresCreditAttendu = soldeAvantCredit + montantVirement;
		
		query.virement(montantVirement, compteEmetteur, compteDestinataire);
		
		ResultSet resultatApres = query.RequeteSelect(req.Req_SELECT_GetSolde(compteDestinataire));
		while(resultatApres.next()) 
		{
			soldeApresCredit = resultatApres.getInt(1);
		}
		
		assertEquals(soldeApresCreditAttendu,soldeApresCredit, 1);
	}
}
