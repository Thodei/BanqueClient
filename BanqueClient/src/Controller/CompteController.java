package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import Dao.Dictionnaire;
import Dao.Requete;
import Model.Main;
import Vue.Vue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

public class CompteController {

	@FXML ListView<String> ListCompte;
	

	
    @FXML 
    public void initialize() {    	
    	
    	ListCompte.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	
            	String NumCompte = ListCompte.getSelectionModel().getSelectedItem();
            	NumCompte = NumCompte.substring(NumCompte.indexOf("(")+1, NumCompte.indexOf(")"));            	
                try {
					new Vue("DetailCompte",null,NumCompte);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
    	
    	ActualiseCompte();
    }  
    
    @FXML 
    public void Btn_NewCompte_Click() {
    	ActualiseCompte();
    }
    
	public void AddListCompte(String Text)
	{
		ListCompte.getItems().add(ListCompte.getItems().size(), Text);
	}
	
	public void ActualiseCompte()
	{    	
		ListCompte.getItems().clear();
		
		try {
			int i = 0;
			ResultSet Resultat = Main.Req.RequeteSelect(Dictionnaire.Req_Select_GetAllCompte(Main.IDClient));			
			while(Resultat.next())
			{
				AddListCompte("Compte " + i + "		("+Resultat.getString(0)+")								"+""+" €");
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
    	//AddListCompte("Compte 1  (1578559)												5 000 €");
	}
}
